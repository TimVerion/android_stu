package com.chchuan.choseimage;

import android.content.Intent;
import android.graphics.ImageDecoder;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.HeaderViewListAdapter;
import android.widget.ImageView;

public class headActivity extends AppCompatActivity {
    public int[] imageId = new int[]{R.drawable.touxiang1, R.drawable.touxiang2,
            R.drawable.touxiang3, R.drawable.touxiang4, R.drawable.touxiang5
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head);
        GridView gridLayout=findViewById(R.id.gridView);
        final BaseAdapter baseAdapter=new BaseAdapter() {

            @Override
            public int getCount() {
                //图片资源的数量
                return imageId.length;
            }

            @Override
            public Object getItem(int position) {
                //例子的位置
                return imageId[position];
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView imageView;
                if(convertView==null){
                    imageView=new ImageView(headActivity.this);
                    /*************设置图像的宽度和高度******************/
                    imageView.setAdjustViewBounds(true);
                    imageView.setMaxWidth(158);
                    imageView.setMaxHeight(150);
                    //设置ImageView的内边距
                    imageView.setPadding(5, 5, 5, 5);
                }else{
                    imageView=(ImageView)convertView;
                }
                imageView.setImageResource(imageId[position]);
                return imageView;
            }
        };
        gridLayout.setAdapter(baseAdapter);
        gridLayout.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                bundle.putInt("imageId",imageId[position]);
                intent.putExtras(bundle);
                //将编号和内容传过去
                setResult(0x11,intent);
                finish();
            }
        });
    }
}
