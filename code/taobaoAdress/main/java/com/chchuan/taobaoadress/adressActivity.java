package com.chchuan.taobaoadress;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class adressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adress);
        Intent intent = getIntent();
        Bundle bundle=intent.getExtras();
        String site=bundle.getString("site1")+bundle.getString("site2")+bundle.getString("site3");
        String name=bundle.getString("name");
        String phone=bundle.getString("phone");
        String email=bundle.getString("email");
        TextView tv_name=findViewById(R.id.name);
        TextView tv_phone=findViewById(R.id.phone);
        TextView tv_site=findViewById(R.id.site);
        tv_name.setText(name);
        tv_phone.setText(phone);
        tv_site.setText(site);
    }
}
