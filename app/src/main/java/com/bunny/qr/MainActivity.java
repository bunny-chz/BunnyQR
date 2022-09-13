/**                     
    * Project:  BunnyQR
    * JDK version used: <JDK1.8>
    * Author： Bunny     Github: https://github.com/bunny-chz/
    * Create Date：2022-01-29
    * Version: 1.0
    */ 


package com.bunny.qr;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.king.zxing.CameraScan;
import com.king.zxing.CaptureActivity;
public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_PHOTO = 0X02;
    public static final int REQUEST_CODE_SCAN = 0X01;
    private List<Map<String, Object>> DataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView gridView = findViewById(R.id.gridview);
        initData();
        String[] OriginData = { "image", "text" };
        int[] Destination = { R.id.img, R.id.text };
        SimpleAdapter adapter = new SimpleAdapter(this, DataList, R.layout.gridview_item, OriginData, Destination );
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick( AdapterView <?> arg0, View arg1, int arg2, long arg3 ) {
                switch (arg2){
                    case 0:
                        startActivityForResult(new Intent(MainActivity.this, CaptureActivity.class),REQUEST_CODE_SCAN,null);
                        /*
                         跳转到默认的相机扫码界面（CaptureActivity.class，记得要在AndroidManifest.xml声明），
                         并传递REQUEST_CODE_SCAN
                         */
                        break;
                    case 1:
                        /*
                         点击进入相册，即进行startPhotoCode()操作
                         */
                        startPhotoCode();
                        break;
                    case 2:
                        /*
                         跳转到生成二维码（generateCode.class）的页面
                         */
                        Intent i1 = new Intent(MainActivity.this,generateCode.class);
                        startActivity(i1);
                        break;
                    case 3:
                        /*
                         跳转到生成条形码（generateBarcode.class）的页面
                         */
                        Intent i2 = new Intent(MainActivity.this,generateBarcode.class);
                        startActivity(i2);
                        break;
                }
            }
        });
        initPermission();
    }
    void initData() {
        int[] Icon = { R.mipmap.camera_scan, R.mipmap.image_scan, R.mipmap.generate_code, R.mipmap.generate_bar_code };
        String[] name ={"相机扫码", "图片扫码", "生成二维码", "生成条形码"};
        DataList = new ArrayList<>();
        for (int i = 0; i <Icon.length; i++) {
            Map<String, Object> map=new HashMap<>();
            map.put("image", Icon[i]);
            map.put("text",name[i]);
            DataList.add(map);
        }
    }
    /**
     判断扫码类型（相机扫码或图片扫码），获取到data,并调用 .parseScanResult和 .parsePhoto对data进行分析，
     赋值给result，最后进行弹窗输出等操作
     **/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null && requestCode == REQUEST_CODE_SCAN) {
                    String result = CameraScan.parseScanResult(data);
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setCancelable(true);
                    builder.setTitle("扫描结果");
                    builder.setMessage(result);
                    builder.setPositiveButton("确定", null);
                    builder.setNegativeButton("复制到剪切板", (dialogInterface, i) -> {
                        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clip = ClipData.newPlainText("result", result);
                        clipboard.setPrimaryClip(clip);
                        Toast.makeText(this, "已复制到剪切板", Toast.LENGTH_SHORT).show();
                    });
                    builder.setNeutralButton("浏览器访问", (dialogInterface, i) -> {
                        try {
                            Uri uri = Uri.parse(result);
                            Intent intent = new Intent();
                            intent.setAction("android.intent.action.VIEW");
                            intent.setData(uri);
                            startActivity(intent);
                        } catch (Exception e) {
                            Toast.makeText(MainActivity.this, "错误：网络链接有误或者没安装浏览器", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.create().show();
        } else if (resultCode == RESULT_OK && data != null && requestCode == REQUEST_CODE_PHOTO) {
            parsePhoto(data);
        }
    }
    /**
     对手机本地图片的data进行分析，并通过 .parseCode分析bitmap,
     赋给result，最后进行弹窗输出等操作
     **/
    private void parsePhoto(Intent data){
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),data.getData());//异步解析
                asyncThread(() -> {
                    final String result = com.king.zxing.util.CodeUtils.parseCode(bitmap);
                    runOnUiThread(() -> {
                        if(result == null)
                        {
                            Toast.makeText(MainActivity.this, "图片无二维码", Toast.LENGTH_SHORT).show();
                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(this);
                            builder.setCancelable(true);
                            builder.setTitle("扫描结果");
                            builder.setMessage(result);
                            builder.setPositiveButton("确定", null);
                            builder.setNegativeButton("复制到剪切板", (dialogInterface, i) -> {
                                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                                ClipData clip = ClipData.newPlainText("result", result);
                                clipboard.setPrimaryClip(clip);
                                Toast.makeText(this, "已复制到剪切板", Toast.LENGTH_SHORT).show();
                            });
                            builder.setNeutralButton("浏览器访问", (dialogInterface, i) -> {
                                try {
                                    Uri uri = Uri.parse(result);
                                    Intent intent = new Intent();
                                    intent.setAction("android.intent.action.VIEW");
                                    intent.setData(uri);
                                    startActivity(intent);
                                } catch (Exception e) {
                                    Toast.makeText(MainActivity.this, "错误：网络链接有误或者没安装浏览器", Toast.LENGTH_SHORT).show();
                                }
                            });
                            builder.create().show();
                        }
                    });
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    private void asyncThread(Runnable runnable){
        new Thread(runnable).start();
    }
    /**
     点击进入相册，选择图片进行扫码，并传递REQUEST_CODE_SCAN
     **/
    public void startPhotoCode(){
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("image/*");
        startActivityForResult(intent, REQUEST_CODE_PHOTO);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_about) {
            Intent i = new Intent(this, MyAboutPage.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
    /**
     * android 6.0 以上需要动态申请权限
     */
    private void initPermission() {
        String[] permissions = {Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE};
        ArrayList<String> toApplyList = new ArrayList<>();
        for (String perm : permissions) {
            if (PackageManager.PERMISSION_GRANTED != ContextCompat.checkSelfPermission(this, perm)) {
                toApplyList.add(perm);// 进入到这里代表没有权限.
            }
        }
        String[] tmpList = new String[toApplyList.size()];
        if (!toApplyList.isEmpty()) {
            ActivityCompat.requestPermissions(this, toApplyList.toArray(tmpList), 123);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        // 此处为android 6.0以上动态授权的回调，用户自行实现。
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
    /**
     再按一次退出主界面操作
     **/
    long exitTime = 0;
    @Override
    public void onBackPressed() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(this, "再按一次退出应用", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
            return;
        }
        finish();
    }
}