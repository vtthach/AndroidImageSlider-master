package com.daimajia.slider.library.Transformers;

import android.view.View;

import static android.support.v4.view.ViewCompat.setAlpha;
import static android.support.v4.view.ViewCompat.setPivotX;
import static android.support.v4.view.ViewCompat.setPivotY;
import static android.support.v4.view.ViewCompat.setScaleX;
import static android.support.v4.view.ViewCompat.setScaleY;

public class ZoomInTransformer extends BaseTransformer {

	@Override
	protected void onTransform(View view, float position) {
		final float scale = position < 0 ? position + 1f : Math.abs(1f - position);
		setScaleX(view,scale);
        setScaleY(view,scale);
        setPivotX(view,view.getWidth() * 0.5f);
        setPivotY(view,view.getHeight() * 0.5f);
        setAlpha(view,position < -1f || position > 1f ? 0f : 1f - (scale - 1f));
	}

}
