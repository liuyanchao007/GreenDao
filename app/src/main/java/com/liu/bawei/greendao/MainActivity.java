package com.liu.bawei.greendao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button insertButton,updateButton,deleteButton,queryButton;
    private Shop shop;
    private List<Shop> mShops;
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initDate();
        setListener();
    }

    private void setListener() {
        insertButton.setOnClickListener(this);
        updateButton.setOnClickListener(this);
        deleteButton.setOnClickListener(this);
        queryButton.setOnClickListener(this);
    }

    private void initDate() {
        shop = new Shop();
        shop.setId(1002L);
        shop.setName("Java开发指南");
        shop.setPrice(100);
        shop.setAddress("人民出版社");
        shop.setImage_url("https://www.baidu.com/img/bd_logo1.png");
        shop.setSell_num(15);
        shop.setType(Shop.TYPE_LOVE);
        mShops = new ArrayList<>();
    }


    private void initView() {
       insertButton = (Button) findViewById(R.id.insert);
       updateButton = (Button) findViewById(R.id.update);
       deleteButton = (Button) findViewById(R.id.delete);
       queryButton = (Button) findViewById(R.id.query);
    }

    @Override
    public void onClick(View v) {
      switch (v.getId()){
          case R.id.insert:
              LoveDao.insertLove(shop);
              break;
          case R.id.update:
              LoveDao.updateLove(shop);
              break;
          case R.id.delete:
              LoveDao.deleteLove(1002L);
              break;
          case R.id.query:
              mShops = LoveDao.queryLove();
              Log.i(TAG, "查询结果: " + mShops);
              break;


      }
    }
}
