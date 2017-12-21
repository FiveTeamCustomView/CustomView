package com.example.administrator.customview.weight_zpc.pie;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.customview.R;

import java.util.ArrayList;

public class PieActivity extends AppCompatActivity {

    private PieView mPie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie);
        initView();
        initData();
    }

    private void initView() {
        mPie = (PieView) findViewById(R.id.pie);
    }
    public void initData(){
        ArrayList<PieData> list = new ArrayList<>();
        PieData data1 = new PieData("学习", 20);
        list.add(data1);
        PieData data2 = new PieData("游戏", 20);
        list.add(data2);
        PieData data3 = new PieData("睡觉", 20);
        list.add(data3);
        PieData data4 = new PieData("听歌", 20);
        list.add(data4);
        PieData data5 = new PieData("吃饭", 20);
        list.add(data5);
        mPie.setData(list);
        mPie.setStartAngle(0);
    }
}
