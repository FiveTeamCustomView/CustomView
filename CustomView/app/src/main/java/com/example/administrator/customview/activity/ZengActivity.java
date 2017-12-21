package com.example.administrator.customview.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.customview.MyView.ListAdapter;
import com.example.administrator.customview.MyView.ObservableScrollView;
import com.example.administrator.customview.R;

import java.util.ArrayList;
import java.util.List;

public class ZengActivity extends AppCompatActivity implements ObservableScrollView.ScrollViewListener, ObservableScrollView.OnScrollListener {

    private ObservableScrollView scrollView;

    private ImageView imageView;
    private LinearLayout top;
    private LinearLayout top_include;
    private TextView textView;
    private List<String> list;
    private int imageHeight;
    private RecyclerView rv;
    private LinearLayout mLl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zeng);
        scrollView = (ObservableScrollView) findViewById(R.id.scrollview);
        imageView = (ImageView) findViewById(R.id.imageview);
        textView = (TextView) findViewById(R.id.textview);
        rv = (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mLl = (LinearLayout) findViewById(R.id.ll);
        top = (LinearLayout) findViewById(R.id.top);
        top_include = (LinearLayout) findViewById(R.id.top_include);

        initListeners();
        initData();

        scrollView.setOnScrollListener(this);

        mLl.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                onScroll(scrollView.getScrollY());
            }
        });
    }

    private void initListeners() {
        // 获取顶部图片高度后，设置滚动监听
        ViewTreeObserver vto = imageView.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                imageView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                imageHeight = imageView.getHeight();

                scrollView.setScrollViewListener(ZengActivity.this);
            }
        });
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add("这是第" + (i+1) + "条数据");
        }

        ListAdapter listAdapter = new ListAdapter(list, this);
        rv.setAdapter(listAdapter);
    }

    @Override
    public void onScrollChanged(ObservableScrollView scrollView, int x, int y,
                                int oldx, int oldy) {
        if (y <= 0) {
            textView.setBackgroundColor(Color.argb((int) 0, 227, 29, 26));//AGB由相关工具获得，或者美工提供
        } else if (y > 0 && y <= imageHeight) {
            float scale = (float) y / imageHeight;
            float alpha = (255 * scale);
            // 只是layout背景透明(仿知乎滑动效果)
            textView.setBackgroundColor(Color.argb((int) alpha, 227, 29, 26));
        } else {
            textView.setBackgroundColor(Color.argb((int) 255, 227, 29, 26));
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onScroll(int scrollY) {
/*        int layoutTop = Math.max(scrollY, top.getTop());
        top_include.layout(0, layoutTop , top_include.getWidth(), layoutTop + top_include.getHeight());*/

        if(scrollY > imageView.getHeight() - top.getHeight()){
            top_include.setVisibility(View.VISIBLE);
        }else{
            top_include.setVisibility(View.GONE);
        }
    }
}
