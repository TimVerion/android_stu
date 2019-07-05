package com.chchuan.there_act;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView pwd=findViewById(R.id.wang_mima);
        //忘记密码
        pwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,PwdActivity.class);
                startActivity(intent);
            }
        });
        Button btn_login=findViewById(R.id.btn_login);
        //登录
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=((EditText) findViewById(R.id.username)).getText().toString();
                String password=((EditText) findViewById(R.id.password)).getText().toString();
                Bundle bundle=new Bundle();
                bundle.putString("username",username);
                bundle.putString("password",password);
                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        Button btn_zhuce=findViewById(R.id.btn_zhuce);
        //注册
        btn_zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ZhuceActivity.class);
                startActivity(intent);
            }
        });
    }
}
