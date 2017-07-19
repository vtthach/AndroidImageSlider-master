package com.daimajia.slider.library.Transformers;

import android.view.View;

import static android.support.v4.view.ViewCompat.setAlpha;
import static android.support.v4.view.ViewCompat.setPivotX;
import static android.support.v4.view.ViewCompat.setPivotY;
import static android.support.v4.view.ViewCompat.setRotationY;


public class FlipHorizontalTransformer extends BaseTransformer {

	@Override
	protected void onTransform(View view, float position) {
		final float rotation = 180f * position;
        setAlpha(view,rotation > 90f || rotation < -90f ? 0 : 1);
        setPivotY(view,view.getHeight()*0.5f);
		setPivotX(view,view.getWidth() * 0.5f);
		setRotationY(view,rotation);
	}

}
