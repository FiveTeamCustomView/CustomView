package com.example.administrator.customview.weight_zpc;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * Created by DELL on 2017/12/18.
 */

public class BlogMoveWave extends View {

    private Path path;
    private Paint paint;

    private int mItemWaveLength = 400;
    private int dx;
    public BlogMoveWave(Context context) {
        super(context);
    }

    public BlogMoveWave(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        path = new Path();
        paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        path.reset();
        int originY = 300;
        int halfWaveLen = mItemWaveLength/2;
        path.moveTo(-mItemWaveLength+dx,originY);
        for (int i = -mItemWaveLength;i<getWidth()+mItemWaveLength;i+=mItemWaveLength){
            path.rQuadTo(halfWaveLen/2,-100,halfWaveLen,0);
            path.rQuadTo(halfWaveLen/2,100,halfWaveLen,0);
        }
        path.lineTo(getWidth(),getHeight());
        path.lineTo(0,getHeight());
        path.close();
        canvas.drawPath(path,paint);
    }
    public void startAnim(){
        ValueAnimator animator = ValueAnimator.ofInt(0, mItemWaveLength);
        animator.setDuration(2000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                dx= (int) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        animator.start();
    }
}
