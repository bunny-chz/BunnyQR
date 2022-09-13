/**                     
    * Project:  BunnyQR
    * JDK version used: <JDK1.8>
    * Author： Bunny     Github: https://github.com/bunny-chz/
    * Create Date：2022-01-29
    * Version: 1.0
    */

package com.bunny.qr;
import android.content.Context;
import android.content.SharedPreferences;
public class SaveText {
    private final Context context;
    public SaveText(Context context){
        this.context = context;
    }
    public void saveBarcodeText(String value){
        String name = context.getResources().getString(R.string.code_text);
        SharedPreferences shp = context.getSharedPreferences(name,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shp.edit();
        String key = context.getResources().getString(R.string.BarcodeText);
        editor.putString(key,value);
        editor.apply();
    }
    public String loadBarcodeText(){
        String name = context.getResources().getString(R.string.code_text);
        SharedPreferences shp = context.getSharedPreferences(name,Context.MODE_PRIVATE);
        return shp.getString(context.getResources().getString(R.string.BarcodeText),null);
    }
    public void saveQrcodeText(String value){
        String name = context.getResources().getString(R.string.code_text);
        SharedPreferences shp = context.getSharedPreferences(name,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shp.edit();
        String key = context.getResources().getString(R.string.QrcodeText);
        editor.putString(key,value);
        editor.apply();
    }
    public String loadQrcodeText(){
        String name = context.getResources().getString(R.string.code_text);
        SharedPreferences shp = context.getSharedPreferences(name,Context.MODE_PRIVATE);
        return shp.getString(context.getResources().getString(R.string.QrcodeText),null);
    }
}