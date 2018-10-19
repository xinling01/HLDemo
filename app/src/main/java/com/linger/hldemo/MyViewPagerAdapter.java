package com.linger.hldemo;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by linger on 2018/10/16.
 */

public class MyViewPagerAdapter extends PagerAdapter {
    private List<ImageView> imageViews;
    public MyViewPagerAdapter(List<ImageView> imageViews) {
        this.imageViews=imageViews;
    }

    @Override
    public int getCount() {
        return imageViews==null?0:imageViews.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
    //添加显示控件

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView=imageViews.get(position);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(imageViews.get(position));
    }
}
