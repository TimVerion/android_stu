package com.chchuan.action2data;

import android.content.Intent;
import android.icu.util.ULocale;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton btn_tel=findViewById(R.id.imageButton_phone);
        ImageButton btn_sms=findViewById(R.id.imageButton_sms);
        //发送信息和拨打电话
        btn_tel.setOnClickListener(clickListener);
        btn_sms.setOnClickListener(clickListener);
        Button btn_home=findViewById(R.id.goHome);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                //设置Action常量
                intent.setAction(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);
            }
        });
    }
    View.OnClickListener clickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent();
            ImageButton imageButton=(ImageButton)v;
            switch (imageButton.getId()){
                case R.id.imageButton_phone:
                    //调用打电话面板
                    intent.setAction(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:17502570826"));
                    startActivity(intent);
                    break;
                case R.id.imageButton_sms:
                    //调用发信息的面板
                    intent.setAction(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("smsto:17502570826"));
                    intent.putExtra("sms_body","Weclome android world!");
                    startActivity(intent);
                    break;
            }
        }
    };
}
