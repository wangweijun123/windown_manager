package com.example.wangweijun.text_process2;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.widget.TextView;

public class SvgActivity extends Activity {

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_svg);


        TextView tv = findViewById(R.id.content);

        Bitmap bitmap = getBitmap(getApplicationContext(), R.drawable.ic_search);

        handleBitmap(bitmap, 0);

        // test
    }

    private static Bitmap getBitmap(Context context, int vectorDrawableId) {
        Bitmap bitmap=null;
        if (Build.VERSION.SDK_INT>Build.VERSION_CODES.LOLLIPOP){
            Drawable vectorDrawable = context.getDrawable(vectorDrawableId);
            bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(),
                    vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            vectorDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            vectorDrawable.draw(canvas);
        }else {
            bitmap = BitmapFactory.decodeResource(context.getResources(), vectorDrawableId);
        }
        return bitmap;
    }


    private void testhandleBitmap() {
        Drawable drawable = getResources().getDrawable(R.drawable.ic_search);
        if (drawable instanceof VectorDrawable) {
//            Bitmap bitmap = ((VectorDrawable) drawable).get
//            handleBitmap(bitmap, -1);
        }

        BitmapDrawable bd;
    }

    private Drawable handleBitmap(Bitmap myBitmap, int color) {
        int [] allpixels = new int [myBitmap.getHeight() * myBitmap.getWidth()];

        myBitmap.getPixels(allpixels, 0, myBitmap.getWidth(), 0, 0,
                myBitmap.getWidth(), myBitmap.getHeight());
//        Color.WHITE
        for(int i = 0; i < allpixels.length; i++) {
            System.out.println("pix : " + allpixels[i]);
//            if(allpixels[i] == Color.BLACK){
//                allpixels[i] = color;
//            }
        }

//        myBitmap.setPixels(allpixels,0,myBitmap.getWidth(),0, 0,
//                myBitmap.getWidth(),myBitmap.getHeight());
//
//        return new BitmapDrawable(myBitmap);
        return null;

    }
}
