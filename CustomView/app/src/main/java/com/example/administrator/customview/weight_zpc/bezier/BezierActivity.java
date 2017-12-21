package com.example.administrator.customview.weight_zpc.bezier;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.administrator.customview.R;
import com.example.administrator.customview.weight_zpc.citysele.CitySelectActivity;
import com.example.administrator.customview.weight_zpc.pie.PieActivity;

public class BezierActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * next
     */
    private Button mNext;
    /**
     * toPie
     */
    private Button mPie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bezier);
        initView();
    }

    private void initView() {
        mNext = (Button) findViewById(R.id.next);
        mNext.setOnClickListener(this);
        mPie = (Button) findViewById(R.id.pie);
        mPie.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.next:
                Intent intent = new Intent(BezierActivity.this, CitySelectActivity.class);
                startActivity(intent);
                break;
            case R.id.pie:
                Intent intent2 = new Intent(BezierActivity.this, PieActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
