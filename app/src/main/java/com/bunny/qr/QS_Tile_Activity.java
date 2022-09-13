/**                     
    * Project:  BunnyQR
    * JDK version used: <JDK1.8>
    * Author： Bunny     Github: https://github.com/bunny-chz/
    * Create Date：2022-01-29
    * Version: 1.0
    */

package com.bunny.qr;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.king.zxing.CameraScan;
import com.king.zxing.CaptureActivity;
public class QS_Tile_Activity extends AppCompatActivity {
    public static final int REQUEST_CODE_SCAN = 0X01;
    Button scan_again,mainPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qs_tile_title);
        mainPage = findViewById(R.id.QS_nevigation_mainPage);
        scan_again = findViewById(R.id.QS_nevigation_scan_again);
        QS_Tile_Result();
        ActionBar actionBar1 = getSupportActionBar();
        if(actionBar1 != null){
            actionBar1.setHomeButtonEnabled(true);
            actionBar1.setDisplayHomeAsUpEnabled(true);
        }
        ActionBar actionBar2 = getSupportActionBar();
        actionBar2.setTitle("扫码导航页");
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void QS_Tile_Result(){
    startActivityForResult(new Intent(this, CaptureActivity .class),REQUEST_CODE_SCAN,null);
    }
    public void mainPage(View view) {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
    public void scan_again (View view) {
        QS_Tile_Result();
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null && requestCode == REQUEST_CODE_SCAN) {
            String result = CameraScan.parseScanResult(data);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setTitle("扫描结果");
            builder.setMessage(result);
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            builder.setNegativeButton("复制到剪切板", (dialogInterface, i) -> {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("result", result);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(this, "已复制到剪切板", Toast.LENGTH_SHORT).show();
                finish();
            });
            builder.setNeutralButton("浏览器访问", (dialogInterface, i) -> {
                try {
                    Uri uri = Uri.parse(result);
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(uri);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                    Toast.makeText(this, "错误：网络链接有误或者没安装浏览器", Toast.LENGTH_SHORT).show();
                }
            });
            builder.create().show();
        }
    }
}