package com.example.administrator.customview.application;

import android.app.Activity;
import android.util.DisplayMetrics;

/**
 * Created by FLOWER on 2017/12/21.
 */

public class MeasureUtil {
    public static int[] getScreenSize(Activity activity) {
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return new int[] { metrics.widthPixels, metrics.heightPixels };
    }
}
