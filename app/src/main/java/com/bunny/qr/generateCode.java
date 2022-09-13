/**                     
    * Project:  BunnyQR
    * JDK version used: <JDK1.8>
    * Author： Bunny     Github: https://github.com/bunny-chz/
    * Create Date：2022-01-29
    * Version: 1.0
    */

package com.bunny.qr;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.king.zxing.util.CodeUtils;
public class generateCode extends AppCompatActivity {
    ImageView generateCodeImage;
    Button codeBtn,qrcodeclear;
    EditText generateCodeText;
    SaveText saveText = new SaveText(this);
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.generate_qrcode);
        ActionBar actionBar1 = getSupportActionBar();
        if(actionBar1 != null){
            actionBar1.setHomeButtonEnabled(true);
            actionBar1.setDisplayHomeAsUpEnabled(true);
        }
        ActionBar actionBar2 = getSupportActionBar();
        actionBar2.setTitle("生成二维码");
        generateCodeText = findViewById(R.id.generateCodeText);
        codeBtn = findViewById(R.id.codeBtn);
        qrcodeclear = findViewById(R.id.qrcodeclear);
        generateCodeImage = findViewById(R.id.generateCodeImage);
        if(saveText.loadQrcodeText() != null)
        {
            generateCodeText.setText(saveText.loadQrcodeText());
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    /**
     生成二维码
     **/
    private void startCode() {
        try {
            String textContent = generateCodeText.getText().toString();//获取EditText的输入内容并判断是否为空
            if (TextUtils.isEmpty(textContent)) {
                Toast.makeText(this, "输入为空，请您输入字符！", Toast.LENGTH_SHORT).show();
                return;
            }
            Bitmap bitmap = CodeUtils.createQRCode(textContent, 600, null);//生成高度为600的二维码
            generateCodeImage.setImageBitmap(bitmap);
        } catch (Exception e) {
            Toast.makeText(generateCode.this, "错误：无法生成二维码", Toast.LENGTH_SHORT).show();
        }
    }
    /**
     生成二维码按钮
     **/
    public void codeBtn (View v) {
        startCode();
        saveText.saveQrcodeText(generateCodeText.getText().toString());
    }
    /**
     手动清除按钮
     **/
    public void qrcodeclear (View v1) {
        generateCodeText.setText("");
        saveText.saveQrcodeText(generateCodeText.getText().toString());
    }
}