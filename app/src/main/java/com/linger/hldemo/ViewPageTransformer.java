package com.linger.hldemo;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by linger on 2018/10/16.
 */

public class ViewPageTransformer implements ViewPager.PageTransformer {
    private static final float min_scale = 0.85f;
    @Override
    public void transformPage(View page, float position) {
        float scaleFactor = Math.max(min_scale, 1 - Math.abs(position));
        float rotate = 20 * Math.abs(position);
        if (position < -1) {
        } else if (position < 0) {
            //    渐变尺寸伸缩动画效果
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
            //    画面转移旋转动画效果
            page.setRotationY(rotate);
        } else if (position >= 0 && position < 1) {
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
            page.setRotationY(-rotate);
        } else if (position >= 1) {
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
            page.setRotationY(-rotate);
        }
    }
}