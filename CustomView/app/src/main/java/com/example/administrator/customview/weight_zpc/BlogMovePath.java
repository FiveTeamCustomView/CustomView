package com.example.administrator.customview.weight_zpc;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * 手指轨迹
 * Created by DELL on 2017/12/18.
 */

public class BlogMovePath extends View {
    private Path path = new Path();
    private float mPrex, mPreY;

    public BlogMovePath(Context context) {
        super(context);
    }

    public BlogMovePath(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                path.moveTo(event.getX(), event.getY());
                mPrex = event.getX();
                mPreY = event.getY();
                return true;
            }
            case MotionEvent.ACTION_MOVE:{
                float endX=(mPrex+event.getX())/2;
                float endY = (mPreY+event.getY())/2;
                path.quadTo(mPrex,mPreY,endX,endY);
                mPrex = endX;
                mPreY =endY;
                invalidate();
            }
            break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(3);

        canvas.drawPath(path,paint);
    }
    public void reset(){
        path.reset();
        postInvalidate();
    }
}
