package com.daimajia.slider.library.Transformers;

import android.view.View;

import static android.support.v4.view.ViewCompat.setTranslationX;


public class StackTransformer extends BaseTransformer {

	@Override
	protected void onTransform(View view, float position) {
		setTranslationX(view,position < 0 ? 0f : -view.getWidth() * position);
	}

}
