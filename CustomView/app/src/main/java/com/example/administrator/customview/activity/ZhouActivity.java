package com.example.administrator.customview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.customview.R;
import com.example.administrator.customview.weight_zpc.BlogMoveWave;

public class ZhouActivity extends AppCompatActivity {

//    private BlogMovePath mBlogMove;
    /**
     * rest
     */
//    private Button mRest;
    private BlogMoveWave blogMovewave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhou);
//        initView();
        blogMovewave = (BlogMoveWave) findViewById(R.id.wave);
        blogMovewave.startAnim();
    }

   /* private void initView() {
        mBlogMove = (BlogMovePath) findViewById(R.id.blogMove);
        mRest = (Button) findViewById(R.id.rest);
        mRest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.rest:
                mBlogMove.reset();
                break;
        }
    }*/
}
