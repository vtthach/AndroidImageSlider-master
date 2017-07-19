package com.daimajia.slider.library.Transformers;

import android.view.View;

import static android.support.v4.view.ViewCompat.setAlpha;
import static android.support.v4.view.ViewCompat.setPivotY;
import static android.support.v4.view.ViewCompat.setScaleX;
import static android.support.v4.view.ViewCompat.setScaleY;
import static android.support.v4.view.ViewCompat.setTranslationX;


public class DepthPageTransformer extends BaseTransformer {

    private static final float MIN_SCALE = 0.75f;

    @Override
    protected void onTransform(View view, float position) {
        if (position <= 0f) {
            setTranslationX(view, 0f);
            setScaleX(view, 1f);
            setScaleY(view, 1f);
        } else if (position <= 1f) {
            final float scaleFactor = MIN_SCALE + (1 - MIN_SCALE) * (1 - Math.abs(position));
            setAlpha(view, 1 - position);
            setPivotY(view, 0.5f * view.getHeight());
            setTranslationX(view, view.getWidth() * -position);
            setScaleX(view, scaleFactor);
            setScaleY(view, scaleFactor);
        }
    }

    @Override
    protected boolean isPagingEnabled() {
        return true;
    }

}
