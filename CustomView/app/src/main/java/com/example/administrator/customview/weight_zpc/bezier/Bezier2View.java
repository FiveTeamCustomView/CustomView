package com.example.administrator.customview.weight_zpc.bezier;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by DELL on 2017/12/19.
 */

public class Bezier2View extends View{

    private Paint paint;//画笔
    private Path path;//路径
    private Point assistPoint;//控制点
    private Point startPoint;//起点
    private Point endtPoint;//终点

    public Bezier2View(Context context) {
        super(context);
        init();
    }

    public Bezier2View(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    private void init(){
        paint = new Paint();
        path = new Path();
        assistPoint = new Point(200, 200);
        startPoint = new Point(100, 100);
        endtPoint = new Point(400, 100);
        paint.setAntiAlias(true);//抗锯齿
        paint.setDither(true);//防抖动
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.RED);//画笔颜色
        paint.setStrokeWidth(6);//画笔宽度
        paint.setStyle(Paint.Style.STROKE);//画笔类型

        path.reset();
        //起点
        path.moveTo(startPoint.x,startPoint.y);
        //path
        path.quadTo(assistPoint.x,assistPoint.y,endtPoint.x,endtPoint.y);
        //画path
        canvas.drawPath(path,paint);
        //画控制点
        canvas.drawPoint(assistPoint.x,assistPoint.y,paint);
        //画线
        canvas.drawLine(startPoint.x,startPoint.y,assistPoint.x,assistPoint.y,paint);
        canvas.drawLine(endtPoint.x,endtPoint.y,assistPoint.x,assistPoint.y,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_MOVE:
                assistPoint.x= (int) event.getX();
                assistPoint.y = (int) event.getY();
                invalidate();
                break;
        }
        return true;
    }
}
