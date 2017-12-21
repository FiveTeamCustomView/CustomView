package com.example.administrator.customview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.customview.LikeStar;
import com.example.administrator.customview.R;

public class HuActivity extends AppCompatActivity {

    private Button btn;
    private LikeStar mLikeStar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hu);

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
