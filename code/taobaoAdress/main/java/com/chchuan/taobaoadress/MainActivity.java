package com.chchuan.taobaoadress;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String site1=((TextView)findViewById(R.id.et_site1)).getText().toString();
                String site2=((TextView)findViewById(R.id.et_site2)).getText().toString();
                String site3=((TextView)findViewById(R.id.et_site3)).getText().toString();
                String name=((TextView)findViewById(R.id.et_name)).getText().toString();
                String phone=((TextView)findViewById(R.id.et_phone)).getText().toString();
                String email=((TextView)findViewById(R.id.et_email)).getText().toString();
                if(!"".equals(site1)&&!"".equals(site2)&&!"".equals(site3)&&!"".equals(name)&&!"".equals(phone)&&!"".equals(email)){
                    Intent intent=new Intent(MainActivity.this,adressActivity.class);
                    Bundle bundle=new Bundle();
                    bundle.putCharSequence("name",name);
                    bundle.putCharSequence("phone",phone);
                    bundle.putCharSequence("email",email);
                    bundle.putCharSequence("site1",site1);
                    bundle.putCharSequence("site2",site2);
                    bundle.putCharSequence("site3",site3);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "请输入完整信息!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
