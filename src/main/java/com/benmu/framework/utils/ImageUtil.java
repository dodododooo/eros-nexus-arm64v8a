package com.benmu.framework.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Carry on 2017/8/21.
 */

public class ImageUtil {

    /**
     * get a bitmap by path
     */
    public static Bitmap getBitmap(String path, Context context) {

        Uri uri = Uri.fromFile(new File(path));
        InputStream in = null;
        try {
            ContentResolver mContentResolver = context.getContentResolver();
            in = mContentResolver.openInputStream(uri);

            //Decode image size
            BitmapFactory.Options o = new BitmapFactory.Options();
            o.inJustDecodeBounds = true;

            BitmapFactory.decodeStream(in, null, o);
            in.close();

            int scale = 1;
            int IMAGE_MAX_SIZE = 1024;
            if (o.outHeight > IMAGE_MAX_SIZE || o.outWidth > IMAGE_MAX_SIZE) {
                scale = (int) Math.pow(2, (int) Math.round(Math.log(IMAGE_MAX_SIZE / (double)
                        Math.max(o.outHeight, o.outWidth)) / Math.log(0.5)));
            }

            BitmapFactory.Options o2 = new BitmapFactory.Options();
            o2.inSampleSize = scale;
            in = mContentResolver.openInputStream(uri);
            Bitmap b = BitmapFactory.decodeStream(in, null, o2);
            in.close();

            return b;
        } catch (FileNotFoundException e) {
            Log.i("BaseImageManager", path + " not found");
        } catch (IOException e) {
            Log.i("BaseImageManager", "file " + path + " not found");
        }
        return null;
    }

    /**
     * zoom image by targetWidth and targetHeight
     */
    public static Bitmap zoomImage(Bitmap bitmap, float targetWidth, float targetHeight) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();

        if (width > 0 && height > 0) {
            float widthScale = targetWidth / width;
            float heightScale = targetHeight / height;
            Matrix matrix = new Matrix();
            matrix.postScale(widthScale, heightScale);
            Bitmap getBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height,
                    matrix,
                    true);
            return getBitmap;

        }
        return null;
    }


    /**
     * ??????????????????????????????????????????
     *
     * @param bitmap   ????????????
     * @param newWidth ????????????????????????,??????0,???????????????????????????????????????????????????828,??????828???????????????
     */
    public static String zoomImage(Context context, Bitmap bitmap, int newWidth, int
            biggestWidth, String filename) {

        int width = bitmap.getWidth();
        int height = bitmap.getHeight();

        if (newWidth <= 0) {//Js ??????0 ?????????????????????
            if (width > biggestWidth) {
                newWidth = biggestWidth;
            } else {
                newWidth = width;
            }
        }
        float scaleWidth = ((float) newWidth) / width;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleWidth);
        Bitmap newBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);

        return saveBitmap(newBitmap, filename, context);
    }


    /**
     * ??????bitmap
     *
     * @param bmp     ????????????
     * @param path    ????????????
     * @param context ?????????
     * @return ?????????????????????
     */
    public static String saveBitmap(Bitmap bmp, String path, Context context) {
        File dest = new File(path);
        try {
            dest.createNewFile();
        } catch (IOException e) {
            Log.e("BaseImageManager", "??????????????????Bitmap???Sd????????????????????????");
        }
        FileOutputStream fOut = null;
        try {
            fOut = new FileOutputStream(dest);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        bmp.compress(Bitmap.CompressFormat.JPEG, 80, fOut);
        try {
            fOut.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dest.getAbsolutePath();
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {


        Bitmap bitmap = Bitmap.createBitmap(

                drawable.getIntrinsicWidth(),

                drawable.getIntrinsicHeight(),

                drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
                        : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmap;

    }

}
