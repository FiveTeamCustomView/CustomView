package com.example.administrator.customview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.customview.LikeStar;
import com.example.administrator.customview.MyView1;
import com.example.administrator.customview.MyViewCircle;
import com.example.administrator.customview.R;

public class HuActivity extends AppCompatActivity {

    private MyView1 myview;
    private Button btn;
    private MyViewCircle myViewCircle;
    private LikeStar mLikeStar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hu);
        //三阶
//        myview = (MyView1) findViewById(R.id.myview);
//        btn = (Button) findViewById(R.id.btn);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                myview.setControlPointTwo(!myview.isControlPointTwo());
//            }
//        });
//
//        //圆变心
//        myViewCircle = (MyViewCircle) findViewById(R.id.myview);
//
//        btn = (Button) findViewById(R.id.btn);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                myViewCircle.setRuning(true);
//            }
//        });


//点赞效果
        mLikeStar = (LikeStar) findViewById(R.id.likestart);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLikeStar.startRunning();
            }
        });
    }

}
