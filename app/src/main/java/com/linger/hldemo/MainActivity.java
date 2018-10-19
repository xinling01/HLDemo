package com.linger.hldemo;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import static com.linger.hldemo.R.*;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private LinearLayout ll_main;
    private List<ImageView> imageViews;
    private int pagerWidth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        viewPager= (ViewPager) findViewById(id.viewPager);
        ll_main= (LinearLayout) findViewById(id.activity_main);
        initData();
        viewPager.setOffscreenPageLimit(3);
        //Viewpager 页面的大小设置3/5
        pagerWidth= (int) (getResources().getDisplayMetrics().widthPixels*3.0f/5.0f);
        ViewGroup.LayoutParams lp=viewPager.getLayoutParams();
        if(lp==null){
            lp=new ViewGroup.LayoutParams(pagerWidth,ViewGroup.LayoutParams.MATCH_PARENT);
        }else {
            lp.width=pagerWidth;
        }
        viewPager.setLayoutParams(lp);
       viewPager.setPageMargin(-50);
        ll_main.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return viewPager.dispatchTouchEvent(event);
            }
        });
        viewPager.setPageTransformer(true,new ViewPageTransformer());
        viewPager.setAdapter(new MyViewPagerAdapter(imageViews));
    }

    private void initData() {
        imageViews=new ArrayList<>();
        ImageView first=new ImageView(MainActivity.this);
        first.setImageBitmap(ImageUtil.getReverseBitmapById(drawable.bg1,MainActivity.this));
        ImageView second=new ImageView(MainActivity.this);
        second.setImageBitmap(ImageUtil.getReverseBitmapById(drawable.bg2,MainActivity.this));
        ImageView third=new ImageView(MainActivity.this);
        third.setImageBitmap(ImageUtil.getReverseBitmapById(drawable.bg3,MainActivity.this));
        ImageView fourth=new ImageView(MainActivity.this);
        fourth.setImageBitmap(ImageUtil.getReverseBitmapById(drawable.bg4,MainActivity.this));
        imageViews.add(first);
        imageViews.add(second);
        imageViews.add(third);
        imageViews.add(fourth);
    }
}
