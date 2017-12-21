package com.example.administrator.customview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.administrator.customview.R;
import com.example.administrator.customview.weight_zpc.bezier.BezierActivity;
import com.example.administrator.customview.weight_zpc.BlogMovePath;

public class ZhouActivity extends AppCompatActivity implements View.OnClickListener {

    private BlogMovePath mBlogMove;
    /**
     * rest
     */
    private Button mRest;
    /**
     * next
     */
    private Button mNext;
//    private BlogMoveWave blogMovewave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhou);
        initView();
        /*blogMovewave = (BlogMoveWave) findViewById(R.id.wave);
        blogMovewave.startAnim();*/
    }

    private void initView() {
        mBlogMove = (BlogMovePath) findViewById(R.id.blogMove);
        mRest = (Button) findViewById(R.id.rest);
        mRest.setOnClickListener(this);
        mNext = (Button) findViewById(R.id.next);
        mNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.rest:
                mBlogMove.reset();
                break;
            case R.id.next:
                Intent intent = new Intent(ZhouActivity.this, BezierActivity.class);
                startActivity(intent);
                break;
        }
    }
}
