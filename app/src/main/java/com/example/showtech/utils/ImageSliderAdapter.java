package com.example.showtech.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.showtech.Electronic;

public class ImageSliderAdapter extends PagerAdapter {

    private Context context;
    private int[] sliderImagesId;

    public ImageSliderAdapter(Context context, Electronic item) {
        this.context = context;
        this.sliderImagesId = item.getImages();
    }

    @NonNull
    @Override
    public Object instantiateItem(ViewGroup container, int i) {
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setImageResource(sliderImagesId[i]);
        ((ViewPager) container).addView(imageView, 0);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int i, Object obj) {
        ((ViewPager) container).removeView((ImageView) obj);
    }


    @Override
    public int getCount() {
        return sliderImagesId.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((ImageView) object);
    }
}
