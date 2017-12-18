package com.example.administrator.customview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.administrator.customview.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 曾宇鑫
     */
    private Button mZeng;
    /**
     * 李琳
     */
    private Button mLi;
    /**
     * 刘俊贤
     */
    private Button mLiu;
    /**
     * 胡相军
     */
    private Button mHu;
    /**
     * 周鹏程
     */
    private Button mZhou;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mZeng = (Button) findViewById(R.id.zeng);
        mZeng.setOnClickListener(this);
        mLi = (Button) findViewById(R.id.li);
        mLi.setOnClickListener(this);
        mLiu = (Button) findViewById(R.id.liu);
        mLiu.setOnClickListener(this);
        mHu = (Button) findViewById(R.id.hu);
        mHu.setOnClickListener(this);
        mZhou = (Button) findViewById(R.id.zhou);
        mZhou.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.zeng:
                Intent intent1 = new Intent(this,ZengActivity.class);
                startActivity(intent1);
                break;
            case R.id.li:
                Intent intent2 = new Intent(this,LiActivity.class);
                startActivity(intent2);
                break;
            case R.id.liu:
                Intent intent3 = new Intent(this,LiuActivity.class);
                startActivity(intent3);
                break;
            case R.id.hu:
                Intent intent4 = new Intent(this,HuActivity.class);
                startActivity(intent4);
                break;
            case R.id.zhou:
                Intent intent5 = new Intent(this,ZhouActivity.class);
                startActivity(intent5);
                break;
        }
    }
}
