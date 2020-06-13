package com.example.showtech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.Objects;

public class DetailsActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener{



    static class ViewHolder {
        TextView title, name, price, description;
        SliderLayout imageSlider;
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
        vh.name = (TextView) findViewById(R.id.name);
        vh.price = (TextView) findViewById(R.id.price);
        vh.description = (TextView) findViewById(R.id.description);
        vh.imageSlider = (SliderLayout) findViewById(R.id.slider);

        Intent intent = getIntent();
        item = (Electronic) intent.getSerializableExtra(ListActivity.EXTRA_ITEM);
        String title = item.getName();
        vh.title.setText(title);

        for(int imageID : item.getImages()){
            TextSliderView textSliderView = new TextSliderView(this);
            textSliderView
                    .description(title)
                    .image(imageID)
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop)
                    .setOnSliderClickListener(this);

            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",title);

            vh.imageSlider.addSlider(textSliderView);
        }
        vh.imageSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        vh.imageSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        vh.imageSlider.setCustomAnimation(new DescriptionAnimation());
        vh.imageSlider.setDuration(4000);

        vh.name.setText(item.getName());
        String price = "$ " + item.getPrice().toString();
        vh.price.setText(price);
        vh.description.setText(item.getDescription());

    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(this,slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();
    }

    public void back(View view) {
        finish();
    }

}
