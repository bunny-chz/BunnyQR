/**                     
    * Project:  BunnyQR
    * JDK version used: <JDK1.8>
    * Author： Bunny     Github: https://github.com/bunny-chz/
    * Create Date：2022-01-29
    * Version: 1.0
    */

package com.bunny.qr;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.google.zxing.BarcodeFormat;
import com.king.zxing.util.CodeUtils;
public class generateBarcode extends AppCompatActivity {
    TextView barcode_about;
    ImageView generateBarCodeImage;
    Button barcodeBtn,barcodeclear;
    EditText generateBarCodeText;
    SaveText saveText = new SaveText(this);
    final String[] barcodetype = new String[] {"AZTEC","CODABAR","CODE_39","CODE_93","CODE_128","DATA_MATRIX","EAN_8","EAN_13","ITF","MAXICODE","PDF_417","RSS_14","RSS_EXPANDED","UPC_A","UPC_E","UPC_EAN_EXTENSION"};
    final String[] barcodeformat = new String[] {"AZTEC","CODABAR","CODE_39","CODE_93","CODE_128","DATA_MATRIX","EAN_8","EAN_13","ITF","PDF_417","UPC_A","UPC_E",};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.generate_barcode);
        ActionBar actionBar1 = getSupportActionBar();
        if(actionBar1 != null){
            actionBar1.setHomeButtonEnabled(true);
            actionBar1.setDisplayHomeAsUpEnabled(true);
        }
        ActionBar actionBar2 = getSupportActionBar();
        actionBar2.setTitle("生成条形码");
        generateBarCodeText = findViewById(R.id.generateBarCodeText);
        barcodeBtn = findViewById(R.id.barcodeBtn);
        barcodeclear = findViewById(R.id.barcodeclear);
        generateBarCodeImage = findViewById(R.id.generateBarCodeImage);
        barcode_about = findViewById(R.id.barcode_about);
        if(saveText.loadBarcodeText() != null)
        {
            generateBarCodeText.setText(saveText.loadBarcodeText());
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
     生成各种类型的条形码（BarcodeFormat.当中提供的所有类型）
     */
    private void startCodeAZTEC() {
        try {
            String textContent = generateBarCodeText.getText().toString();
            Bitmap bitmap = CodeUtils.createBarCode(textContent, BarcodeFormat.AZTEC, 650, 650, null, true);
            generateBarCodeImage.setImageBitmap(bitmap);
            saveText.saveBarcodeText(generateBarCodeText.getText().toString());
        } catch (Exception e) {
            Toast.makeText(generateBarcode.this, "错误：请输入条形码规定的字符", Toast.LENGTH_SHORT).show();
        }
    }
    private void startCodeCODABAR() {
        try {
            String textContent = generateBarCodeText.getText().toString();
            Bitmap bitmap = CodeUtils.createBarCode(textContent, BarcodeFormat.CODABAR, 1000, 500, null, true);
            generateBarCodeImage.setImageBitmap(bitmap);
            saveText.saveBarcodeText(generateBarCodeText.getText().toString());
        } catch (Exception e) {
            Toast.makeText(generateBarcode.this, "错误：请输入条形码规定的字符", Toast.LENGTH_SHORT).show();
        }
    }
    private void startCodeCODE_39() {
        try {
            String textContent = generateBarCodeText.getText().toString();
            Bitmap bitmap = CodeUtils.createBarCode(textContent, BarcodeFormat.CODE_39, 1000, 500, null, true);
            generateBarCodeImage.setImageBitmap(bitmap);
            saveText.saveBarcodeText(generateBarCodeText.getText().toString());
        } catch (Exception e) {
            Toast.makeText(generateBarcode.this, "错误：请输入条形码规定的字符", Toast.LENGTH_SHORT).show();
        }
    }
    private void startCodeCODE_93() {
        try {
            String textContent = generateBarCodeText.getText().toString();
            Bitmap bitmap = CodeUtils.createBarCode(textContent, BarcodeFormat.CODE_93, 1000, 500, null, true);
            generateBarCodeImage.setImageBitmap(bitmap);
            saveText.saveBarcodeText(generateBarCodeText.getText().toString());
        } catch (Exception e) {
            Toast.makeText(generateBarcode.this, "错误：请输入条形码规定的字符", Toast.LENGTH_SHORT).show();
        }
    }
    private void startCodeCODE_128() {
        try {
            String textContent = generateBarCodeText.getText().toString();
            Bitmap bitmap = CodeUtils.createBarCode(textContent, BarcodeFormat.CODE_128, 1000, 500, null, true);
            generateBarCodeImage.setImageBitmap(bitmap);
            saveText.saveBarcodeText(generateBarCodeText.getText().toString());
        } catch (Exception e) {
            Toast.makeText(generateBarcode.this, "错误：请输入条形码规定的字符", Toast.LENGTH_SHORT).show();
        }
    }
    private void startCodeDATA_MATRIX() {
        try {
            String textContent = generateBarCodeText.getText().toString();
            Bitmap bitmap = CodeUtils.createBarCode(textContent, BarcodeFormat.DATA_MATRIX, 750, 750, null, true);
            generateBarCodeImage.setImageBitmap(bitmap);
            saveText.saveBarcodeText(generateBarCodeText.getText().toString());
        } catch (Exception e) {
            Toast.makeText(generateBarcode.this, "错误：请输入条形码规定的字符", Toast.LENGTH_SHORT).show();
        }
    }
    private void startCodeEAN_8() {
        try {
            String textContent = generateBarCodeText.getText().toString();
            Bitmap bitmap = CodeUtils.createBarCode(textContent, BarcodeFormat.EAN_8, 1000, 500, null, true);
            generateBarCodeImage.setImageBitmap(bitmap);
            saveText.saveBarcodeText(generateBarCodeText.getText().toString());
        } catch (Exception e) {
            Toast.makeText(generateBarcode.this, "错误：请输入条形码规定的字符", Toast.LENGTH_SHORT).show();
        }
    }
    private void startCodeEAN_13() {
        try {
            String textContent = generateBarCodeText.getText().toString();
            Bitmap bitmap = CodeUtils.createBarCode(textContent, BarcodeFormat.EAN_13, 1000, 500, null, true);
            generateBarCodeImage.setImageBitmap(bitmap);
            saveText.saveBarcodeText(generateBarCodeText.getText().toString());
        } catch (Exception e) {
            Toast.makeText(generateBarcode.this, "错误：请输入条形码规定的字符", Toast.LENGTH_SHORT).show();
        }
    }
    private void startCodeITF() {
        try {
            String textContent = generateBarCodeText.getText().toString();
            Bitmap bitmap = CodeUtils.createBarCode(textContent, BarcodeFormat.ITF, 1000, 500, null, true);
            generateBarCodeImage.setImageBitmap(bitmap);
            saveText.saveBarcodeText(generateBarCodeText.getText().toString());
        } catch (Exception e) {
            Toast.makeText(generateBarcode.this, "错误：请输入条形码规定的字符", Toast.LENGTH_SHORT).show();
        }
    }
    private void startCodeMAXICODE() {
        try {
            String textContent = generateBarCodeText.getText().toString();
            Bitmap bitmap = CodeUtils.createBarCode(textContent, BarcodeFormat.MAXICODE, 750, 750, null, true);
            generateBarCodeImage.setImageBitmap(bitmap);
            saveText.saveBarcodeText(generateBarCodeText.getText().toString());
        } catch (Exception e) {
            Toast.makeText(generateBarcode.this, "错误：请输入条形码规定的字符", Toast.LENGTH_SHORT).show();
        }
    }
    private void startCodePDF_417() {
        try {
            String textContent = generateBarCodeText.getText().toString();
            Bitmap bitmap = CodeUtils.createBarCode(textContent, BarcodeFormat.PDF_417, 1000, 500, null, true);
            generateBarCodeImage.setImageBitmap(bitmap);
            saveText.saveBarcodeText(generateBarCodeText.getText().toString());
        } catch (Exception e) {
            Toast.makeText(generateBarcode.this, "错误：请输入条形码规定的字符", Toast.LENGTH_SHORT).show();
        }
    }
    private void startCodeRSS_14() {
        try {
            String textContent = generateBarCodeText.getText().toString();
            Bitmap bitmap = CodeUtils.createBarCode(textContent, BarcodeFormat.RSS_14, 1000, 500, null, true);
            generateBarCodeImage.setImageBitmap(bitmap);
            saveText.saveBarcodeText(generateBarCodeText.getText().toString());
        } catch (Exception e) {
            Toast.makeText(generateBarcode.this, "错误：请输入条形码规定的字符", Toast.LENGTH_SHORT).show();
        }
    }
    private void startCodeRSS_EXPANDED() {
        try {
            String textContent = generateBarCodeText.getText().toString();
            Bitmap bitmap = CodeUtils.createBarCode(textContent, BarcodeFormat.RSS_EXPANDED, 1000, 500, null, true);
            generateBarCodeImage.setImageBitmap(bitmap);
            saveText.saveBarcodeText(generateBarCodeText.getText().toString());
        } catch (Exception e) {
            Toast.makeText(generateBarcode.this, "错误：请输入条形码规定的字符", Toast.LENGTH_SHORT).show();
        }
    }
    private void startCodeUPC_A() {
        try {
            String textContent = generateBarCodeText.getText().toString();
            Bitmap bitmap = CodeUtils.createBarCode(textContent, BarcodeFormat.UPC_A, 1000, 500, null, true);
            generateBarCodeImage.setImageBitmap(bitmap);
            saveText.saveBarcodeText(generateBarCodeText.getText().toString());
        } catch (Exception e) {
            Toast.makeText(generateBarcode.this, "错误：请输入条形码规定的字符", Toast.LENGTH_SHORT).show();
        }
    }
    private void startCodeUPC_E() {
        try {
            String textContent = generateBarCodeText.getText().toString();
            Bitmap bitmap = CodeUtils.createBarCode(textContent, BarcodeFormat.UPC_E, 1000, 500, null, true);
            generateBarCodeImage.setImageBitmap(bitmap);
            saveText.saveBarcodeText(generateBarCodeText.getText().toString());
        } catch (Exception e) {
            Toast.makeText(generateBarcode.this, "错误：请输入条形码规定的字符", Toast.LENGTH_SHORT).show();
        }
    }
    private void startCodeUPC_EAN_EXTENSION() {
        try {
            String textContent = generateBarCodeText.getText().toString();
            Bitmap bitmap = CodeUtils.createBarCode(textContent, BarcodeFormat.UPC_EAN_EXTENSION, 1000, 500, null, true);
            generateBarCodeImage.setImageBitmap(bitmap);
            saveText.saveBarcodeText(generateBarCodeText.getText().toString());
        } catch (Exception e) {
            Toast.makeText(generateBarcode.this, "错误：请输入条形码规定的字符", Toast.LENGTH_SHORT).show();
        }
    }
    /**
     点击生成条形码
     **/
    public void barcodeBtn (View v) {
        String textContent = generateBarCodeText.getText().toString();
        if (TextUtils.isEmpty(textContent)) {
            Toast.makeText(this, "输入为空，请您输入字符！", Toast.LENGTH_SHORT).show();
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("选择条形码格式");
        builder.setItems(barcodetype,new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case 0:         //弹窗列表第一个选项为0
                        startCodeAZTEC();
                        break;
                    case 1:
                        startCodeCODABAR();
                        break;
                    case 2:
                        startCodeCODE_39();
                        break;
                    case 3:
                        startCodeCODE_93();
                        break;
                    case 4:
                        startCodeCODE_128();
                        break;
                    case 5:
                        startCodeDATA_MATRIX();
                        break;
                    case 6:
                        startCodeEAN_8();
                        break;
                    case 7:
                        startCodeEAN_13();
                        break;
                    case 8:
                        startCodeITF();
                        break;
                    case 9:
                        startCodeMAXICODE();
                        break;
                    case 10:
                        startCodePDF_417();
                        break;
                    case 11:
                        startCodeRSS_14();
                        break;
                    case 12:
                        startCodeRSS_EXPANDED();
                        break;
                    case 13:
                        startCodeUPC_A();
                        break;
                    case 14:
                        startCodeUPC_E();
                        break;
                    case 15:
                        startCodeUPC_EAN_EXTENSION();
                        break;
                }
            }
        });
        builder.create().show();
    }
    public void barcodeclear (View v) {
        generateBarCodeText.setText("");
        saveText.saveBarcodeText(generateBarCodeText.getText().toString());
    }
    /**
     部分条形码格式参考
     **/
    public void barcode_about (View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("选择条形码格式");
        builder.setItems(barcodeformat,new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case 0:
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(generateBarcode.this);
                        builder1.setCancelable(true);
                        builder1.setTitle("AZTEC格式");
                        builder1.setMessage("支持  文本  生成条形码（仅供参考，具体格式建议百度一下）");
                        builder1.setPositiveButton("确定", null);
                        builder1.create().show();
                        break;
                    case 1:
                        AlertDialog.Builder builder2 = new AlertDialog.Builder(generateBarcode.this);
                        builder2.setCancelable(true);
                        builder2.setTitle("CODABAR格式");
                        builder2.setMessage("只支持（注意是大写）  0~9 A B C D + - * / $ . : 字符生成条形码（仅供参考，具体格式建议百度一下）");
                        builder2.setPositiveButton("确定",null);
                        builder2.create().show();
                        break;
                    case 2:
                        AlertDialog.Builder builder3 = new AlertDialog.Builder(generateBarcode.this);
                        builder3.setCancelable(true);
                        builder3.setTitle("CODE_39格式");
                        builder3.setMessage("只支持  数字、大写字母和 + - * / % $  字符生成条形码（仅供参考，具体格式建议百度一下）");
                        builder3.setPositiveButton("确定", null);
                        builder3.create().show();
                        break;
                    case 3:
                        AlertDialog.Builder builder4 = new AlertDialog.Builder(generateBarcode.this);
                        builder4.setCancelable(true);
                        builder4.setTitle("CODE_93格式");
                        builder4.setMessage("只支持  数字、大写字母以及“空格符” + - * / % $ .  字符生成条形码，密度比CODE_39高（仅供参考，具体格式建议百度一下）");
                        builder4.setPositiveButton("确定", null);
                        builder4.create().show();
                        break;
                    case 4:
                        AlertDialog.Builder builder5 = new AlertDialog.Builder(generateBarcode.this);
                        builder5.setCancelable(true);
                        builder5.setTitle("CODE_128格式");
                        builder5.setMessage("只支持 ASCII 字符生成条形码（仅供参考，具体格式建议百度一下）");
                        builder5.setPositiveButton("确定", null);
                        builder5.create().show();
                        break;
                    case 5:
                        AlertDialog.Builder builder6 = new AlertDialog.Builder(generateBarcode.this);
                        builder6.setCancelable(true);
                        builder6.setTitle("DATA_MATRIX格式");
                        builder6.setMessage("支持URL、文本、电子邮件链接等生成条形码（仅供参考，具体格式建议百度一下）");
                        builder6.setPositiveButton("确定", null);
                        builder6.create().show();
                        break;
                    case 6:
                        AlertDialog.Builder builder7 = new AlertDialog.Builder(generateBarcode.this);
                        builder7.setCancelable(true);
                        builder7.setTitle("EAN_8格式");
                        builder7.setMessage("EAN-8码共8位数，包含国家代码2位，产品代码5位，以及最后1位根据前面数据生成的校验码。（仅供参考，具体格式建议百度一下）");
                        builder7.setPositiveButton("确定",null);
                        builder7.create().show();
                        break;
                    case 7:
                        AlertDialog.Builder builder8 = new AlertDialog.Builder(generateBarcode.this);
                        builder8.setCancelable(true);
                        builder8.setTitle("EAN_13格式");
                        builder8.setMessage("EAN_13码标准码共13位数，是由「国家代码」3位数，「厂商代码」4位数，「产品代码」5位数，以及「校正码」1位数组成。（仅供参考，具体格式建议百度一下）");
                        builder8.setPositiveButton("确定",null);
                        builder8.create().show();
                        break;
                    case 8:
                        AlertDialog.Builder builder9 = new AlertDialog.Builder(generateBarcode.this);
                        builder9.setCancelable(true);
                        builder9.setTitle("ITF格式");
                        builder9.setMessage("只支持长度大于4的数字（仅供参考，具体格式建议百度一下）");
                        builder9.setPositiveButton("确定", null);
                        builder9.create().show();
                        break;
                    case 9:
                        AlertDialog.Builder builder10 = new AlertDialog.Builder(generateBarcode.this);
                        builder10.setCancelable(true);
                        builder10.setTitle("PDF_417格式");
                        builder10.setMessage("支持  文本  生成条形码（仅供参考，具体格式建议百度一下）");
                        builder10.setPositiveButton("确定", null);
                        builder10.create().show();
                        break;
                    case 10:
                        AlertDialog.Builder builder11 = new AlertDialog.Builder(generateBarcode.this);
                        builder11.setCancelable(true);
                        builder11.setTitle("UPC_A格式");
                        builder11.setMessage("支持长度为11或12的数字，最后一位为校验位（仅供参考，具体格式建议百度一下）");
                        builder11.setPositiveButton("确定", null);
                        builder11.create().show();
                        break;
                    case 11:
                        AlertDialog.Builder builder12 = new AlertDialog.Builder(generateBarcode.this);
                        builder12.setCancelable(true);
                        builder12.setTitle("UPC_E格式");
                        builder12.setMessage("支持长度为7的数字（仅供参考，具体格式建议百度一下）");
                        builder12.setPositiveButton("确定", null);
                        builder12.create().show();
                        break;
                }
            }
        });
        builder.create().show();
    }
}