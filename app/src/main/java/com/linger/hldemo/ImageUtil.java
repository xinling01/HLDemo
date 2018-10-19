package com.linger.hldemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;

/**
 * Created by linger on 2018/10/16.
 */

public class ImageUtil {
    public static Bitmap getReverseBitmapById(int resId, Context context){
        //压缩图片到指定宽高防止OOM
        Bitmap sourceBitmap = scaleImg(context,resId, 600, 800);
        Matrix matrix=new Matrix();
        matrix.setScale(1,-1);
        //翻转后的图片
        Bitmap inverseBitmap=Bitmap.createBitmap(sourceBitmap,0,sourceBitmap.getHeight()/2,sourceBitmap.getWidth(),sourceBitmap.getHeight()/3,matrix,false);
       //新创建了一个bitmap
        Bitmap groupbBitmap=Bitmap.createBitmap(sourceBitmap.getWidth(),sourceBitmap.getHeight()+sourceBitmap.getHeight()/3+50,sourceBitmap.getConfig());
        Canvas gCanvas=new Canvas(groupbBitmap);
        gCanvas.drawBitmap(sourceBitmap,0,0,null);
        gCanvas.drawBitmap(inverseBitmap,0,sourceBitmap.getHeight()+100,null);

        Paint paint=new Paint();
        Shader.TileMode tileMode=Shader.TileMode.CLAMP;
        LinearGradient shader=new LinearGradient(0,sourceBitmap.getHeight()+100,0,
		groupbBitmap.getHeight(), Color.BLACK,Color.TRANSPARENT,tileMode);
        paint.setShader(shader);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        gCanvas.drawRect(0,sourceBitmap.getHeight()+150,sourceBitmap.getWidth(),groupbBitmap.getHeight(),paint);
        return groupbBitmap;
    }
    protected static Bitmap scaleImg(Context context,int resId, int newWidth, int newHeight) {
        // 图片源
        Bitmap bm = BitmapFactory.decodeResource(context.getResources(), resId);
        // 获得图片的宽高
        int width = bm.getWidth();
        int height = bm.getHeight();
        // 设置想要的大小
        int newWidth1 = newWidth;
        int newHeight1 = newHeight;
        // 计算缩放比例
        float scaleWidth = ((float) newWidth1) / width;
        float scaleHeight = ((float) newHeight1) / height;
        // 取得想要缩放的matrix参数
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        // 得到新的图片
        Bitmap newbm = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, true);
        //返回新图片
        return newbm;
    }


}
