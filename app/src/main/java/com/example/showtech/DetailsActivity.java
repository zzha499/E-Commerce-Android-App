package com.example.showtech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.showtech.utils.ImageSliderAdapter;

import java.util.Objects;

public class DetailsActivity extends AppCompatActivity{

    static class ViewHolder {
        ViewPager viewPager;
        TextView title, name, price, description;
    }

    private Electronic item;
    private ViewHolder vh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Objects.requireNonNull(getSupportActionBar()).hide();

        vh = new ViewHolder();
        vh.title = (TextView) findViewById(R.id.item_title);
        vh.viewPager = (ViewPager) findViewById(R.id.item_images);
        vh.name = (TextView) findViewById(R.id.name);
        vh.price = (TextView) findViewById(R.id.price);
        vh.description = (TextView) findViewById(R.id.description);

        Intent intent = getIntent();
        item = (Electronic) intent.getSerializableExtra(ListActivity.EXTRA_ITEM);
        String title = item.getName();
        vh.title.setText(title);

        ImageSliderAdapter adapter = new ImageSliderAdapter(this, item);
        vh.viewPager.setAdapter(adapter);

        vh.name.setText(item.getName());
        String price = "$ " + item.getPrice().toString();
        vh.price.setText(price);
        vh.description.setText(item.getDescription());

    }

    public void back(View view) {
        finish();
    }

}
