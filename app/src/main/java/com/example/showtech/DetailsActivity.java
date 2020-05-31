package com.example.showtech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.showtech.items.Electronic;

public class DetailsActivity extends AppCompatActivity implements Activity{

    @Override
    public void back(View view) {
        finish();
    }

    @Override
    public ListActivity search(String searchInput) {
        return null;
    }

    @Override
    public void quitApplication() {

    }

    class ViewHolder {
        ViewPager imageSlider;
    }

    private Electronic item;
    private ViewHolder vh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        vh = new ViewHolder();
        vh.imageSlider = findViewById(R.id.image_slider);
    }


//    public void loadImages() {
//        for (Image image : item.getImages()) {
//            ImageView imageView = new ImageView(this);
//            vh.imageSlider.addView(imageView);
//        }
//
//
//    }

}
