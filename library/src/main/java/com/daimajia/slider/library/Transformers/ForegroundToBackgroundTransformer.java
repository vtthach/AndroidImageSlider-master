package com.daimajia.slider.library.Transformers;

import android.view.View;

import static android.support.v4.view.ViewCompat.setPivotX;
import static android.support.v4.view.ViewCompat.setPivotY;
import static android.support.v4.view.ViewCompat.setScaleX;
import static android.support.v4.view.ViewCompat.setScaleY;
import static android.support.v4.view.ViewCompat.setTranslationX;


public class ForegroundToBackgroundTransformer extends BaseTransformer {

	@Override
	protected void onTransform(View view, float position) {
		final float height = view.getHeight();
		final float width = view.getWidth();
		final float scale = min(position > 0 ? 1f : Math.abs(1f + position), 0.5f);

		setScaleX(view,scale);
        setScaleY(view,scale);
        setPivotX(view,width * 0.5f);
        setPivotY(view,height * 0.5f);
        setTranslationX(view,position > 0 ? width * position : -width * position * 0.25f);
	}

	private static final float min(float val, float min) {
		return val < min ? min : val;
	}

}
