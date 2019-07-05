package com.chchuan.fragmentdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView1=findViewById(R.id.image1);
        ImageView imageView2=findViewById(R.id.image2);
        ImageView imageView3=findViewById(R.id.image3);
        ImageView imageView4=findViewById(R.id.image4);
        imageView1.setOnClickListener(click);
        imageView2.setOnClickListener(click);
        imageView3.setOnClickListener(click);
        imageView4.setOnClickListener(click);
    }
    View.OnClickListener click=new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
            Fragment f=null;
            switch (v.getId()){
                case R.id.image1:
                    f=new wechat_fragment();
                    break;
                case R.id.image2:
                    f=new message_fragment();
                    break;
                case R.id.image3:
                    f=new find_fragment();
                    break;
                case R.id.image4:
                    f=new me_fragment();
                    break;
                default:
                    break;
            }
            //交换画面
            transaction.replace(R.id.fragment,f);
            transaction.commit();
        }
    };
}
