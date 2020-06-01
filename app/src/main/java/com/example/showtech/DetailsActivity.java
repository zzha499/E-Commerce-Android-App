package com.example.showtech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.showtech.items.Electronic;

import java.util.Objects;

public class DetailsActivity extends AppCompatActivity implements Activity{

    class ViewHolder {
        ImageView image;
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
        vh.image = (ImageView) findViewById(R.id.item_image);
        vh.name = (TextView) findViewById(R.id.name);
        vh.price = (TextView) findViewById(R.id.price);
        vh.description = (TextView) findViewById(R.id.description);

        Intent intent = getIntent();
        item = (Electronic) intent.getSerializableExtra(ListActivity.ITEM);
        String title = item.getName();
        vh.title.setText(title);
        vh.image.setImageResource(item.getImages().get(0));
        vh.name.setText(item.getName());
        String price = "$ " + item.getPrice().toString();
        vh.price.setText(price);
        vh.description.setText(item.getDescription());

    }

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


}
