/**                     
    * Project:  BunnyQR
    * JDK version used: <JDK1.8>
    * Author： Bunny     Github: https://github.com/bunny-chz/
    * Create Date：2022-01-29
    * Version: 1.0
    */

package com.bunny.qr;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;
public class MyAboutPage extends AppCompatActivity {
    private static final String SHARE_TEXT = "Bunny QR是一款主要支持二维码扫描和生成的软件。\n" +
            "支持相机扫码和图片扫码；\n" +
            "可以生成16种格式的条形码，\n" +
            "可以识别部分格式的条形码；\n" +
            "支持下拉通知栏打开相机扫码。\n" +
            "\n" +
            "点击下方链接下载\n" +
            "蓝奏云下载：https://zss233.lanzout.com/b00pi7vuh\n" +
            "密码:2333\n";
    private static final String UPDATE_LOG = "V1.0.0基本功能\n" +
            "\n" +
            "一、二维码解码\n" +
            "  1.相机扫码\n" +
            "  2.本地图片扫码\n" +
            "      以上都支持复制到剪切板\n" +
            "二、二维码编码\n" +
            "  1.文本编码成二维码\n" +
            "    (1)带logo(logo为软件图标)\n" +
            "    (2)不带logo\n" +
            "\n" +"\n" +
            "V1.1.0更新内容\n" +
            "\n" +
            "1.优化了图片扫码，可以扫花式二维码\n" +
            "2.优化了扫码结果提示的逻辑\n" +
            "         (如提示图片无二维码)\n" +
            "3.新增功能:扫码结果直接用浏览器访问\n" +
            "4.优化了软件大小，减小APP体积\n" +
            "5.改善了界面布局\n" +
            "\n" +"\n" +
            "V1.2.0更新内容\n" +
            "\n" +
            "1.新增条形码识别功能，整合在同一扫码按钮下\n" +
            "2.新增条形码生成功能\n" +
            "3.删除带Logo的二维码生成功能\n" +
            "4.优化了相机扫码\n" +
            "      (1)增加闪光灯功能\n" +
            "      (2)可手动聚焦拉近扫码\n" +
            "      (3)优化了界面的扫码框与扫描视觉效果\n" +
            "\n" +"\n" +
            "V1.3.0更新内容\n" +
            "\n" +
            "1.优化了输入的体验，取消自动清除，增加清除按钮\n" +
            "2.改进之前的只能生成一种类型的条形码，增加了16种新的条形码类型\n" +
            "3.另附有部分条形码的使用格式\n" +
            "4.增加再按一次退出操作\n" +
            "5.修复对话弹窗确定按钮的错误\n" +
            "\n" +"\n" +
            "V1.4.0更新内容\n" +
            "\n" +
            "1.优化界面布局，改进屏幕适配度\n" +
            "2.新增下拉通知栏快捷扫码功能\n" +
            "\n" +"\n" +
            "V1.5.0更新内容\n" +
            "\n" +
            "1.优化授予权限的操作，要授予的权限一览全知道\n" +
            "2.优化界面UI，增强屏幕适配度，同时适配夜间模式\n" +
            "3.增加返回按键，美化输入框风格，标题栏显示各个页面的主要功能\n" +
            "4.新增关于页面，声明软件开发相关信息；新增版权信息页面，声明开源代码的版权\n" +
            "5.生成二维码（条形码）功能中，对输入的文字进行存储记忆\n";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setImage(R.drawable.qr_icon)
                .setDescription(this.getResources().getString(R.string.APP_description))
                .addItem(new Element().setTitle("Version 1.5.0"))
                .addItem(getUpdateLog())
                .addItem(getShare())
                .addItem(getLicenseElement())
                .addGroup("联系开发者(Bunny)")
                .addGitHub("bunnyboy233","GitHub(bunnyboy233)")
                .create();
        setContentView(aboutPage);
    }
    Element getLicenseElement() {
        Element LicenseElement = new Element();
        LicenseElement.setTitle("版权信息");
        LicenseElement.setAutoApplyIconTint(true);
        LicenseElement.setIconTint(mehdi.sakout.aboutpage.R.color.about_item_icon_color);
        LicenseElement.setIconNightTint(android.R.color.white);
        LicenseElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MyAboutPage.this, LicensePage.class);
                startActivity(i);
            }
        });
        return LicenseElement;
    }
    Element getUpdateLog() {
        Element LicenseElement = new Element();
        LicenseElement.setTitle("更新日志");
        LicenseElement.setAutoApplyIconTint(true);
        LicenseElement.setIconTint(mehdi.sakout.aboutpage.R.color.about_item_icon_color);
        LicenseElement.setIconNightTint(android.R.color.white);
        LicenseElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MyAboutPage.this);
                builder.setCancelable(true);
                builder.setTitle("更新日志");
                builder.setMessage(UPDATE_LOG);
                builder.setPositiveButton("确定", null);
                builder.create().show();
            }
        });
        return LicenseElement;
    }
    Element getShare() {
        Element LicenseElement = new Element();
        LicenseElement.setTitle("分享");
        LicenseElement.setAutoApplyIconTint(true);
        LicenseElement.setIconTint(mehdi.sakout.aboutpage.R.color.about_item_icon_color);
        LicenseElement.setIconNightTint(android.R.color.white);
        LicenseElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, SHARE_TEXT);
                intent.setType("text/plain");
                startActivity(intent);
            }
        });
        return LicenseElement;
    }
    private void initView() {
        ActionBar actionBar1 = getSupportActionBar();
        if(actionBar1 != null){
            actionBar1.setHomeButtonEnabled(true);
            actionBar1.setDisplayHomeAsUpEnabled(true);
        }
        ActionBar actionBar2 = getSupportActionBar();
        actionBar2.setTitle("关于");
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}