package com.daimajia.slider.library.Transformers;

import android.view.View;

import static android.support.v4.view.ViewCompat.setAlpha;
import static android.support.v4.view.ViewCompat.setPivotX;
import static android.support.v4.view.ViewCompat.setPivotY;
import static android.support.v4.view.ViewCompat.setScaleX;
import static android.support.v4.view.ViewCompat.setScaleY;
import static android.support.v4.view.ViewCompat.setTranslationX;


public class ZoomOutTransformer extends BaseTransformer {

    @Override
    protected void onTransform(View view, float position) {
        final float scale = 1f + Math.abs(position);
        setScaleX(view,scale);
        setScaleY(view,scale);
        setPivotX(view,view.getWidth() * 0.5f);
        setPivotY(view,view.getWidth() * 0.5f);
        setAlpha(view,position < -1f || position > 1f ? 0f : 1f - (scale - 1f));
        if(position < -0.9){
            //-0.9 to prevent a small bug
            setTranslationX(view,view.getWidth() * position);
        }
    }

}