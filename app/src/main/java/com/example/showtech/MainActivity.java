package com.example.showtech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.showtech.items.Electronic;
import com.example.showtech.utils.DataProvider;
import com.example.showtech.utils.ListAdapter;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity  implements Activity, ListAdapter.ItemClickListener {

    public final static String EXTRA_MESSAGE = "com.example.showtech.MESSAGE";
    private static final String ITEM = "com.example.showtech.ITEM";

    static class ViewHolder {
        RecyclerView top_selling;
        LinearLayout computer, mobile_phone, music, camera, gaming;
        ImageView search;

    }

    private ViewHolder vh;
    private static ListAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Electronic> items;
    private DataProvider dataProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();


        vh = new ViewHolder();
        vh.computer = (LinearLayout) findViewById(R.id.computer);
        vh.mobile_phone = (LinearLayout) findViewById(R.id.mobile_phone);
        vh.music = (LinearLayout) findViewById(R.id.music);
        vh.camera = (LinearLayout) findViewById(R.id.camera);
        vh.gaming = (LinearLayout) findViewById(R.id.gaming);
        vh.search = (ImageView) findViewById(R.id.search);

        vh.top_selling = (RecyclerView) findViewById(R.id.top_selling);
        vh.top_selling.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        vh.top_selling.setLayoutManager(layoutManager);
        vh.top_selling.setItemAnimator(new DefaultItemAnimator());

        dataProvider = new DataProvider(this);
        items = dataProvider.provideData("top selling");
        adapter = new ListAdapter(items);
        adapter.setClickListener(this);
        vh.top_selling.setAdapter(adapter);

    }

    public void selectCategory(View view){
        String message = view.getContentDescription().toString();
        Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ListActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    @Override
    public void onItemClick(View view, int position) {
        Electronic item = adapter.getItem(position);
        Toast.makeText(view.getContext(), item.getName(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra(ITEM, item);
        startActivity(intent);
    }

    @Override
    public void back(View view) {
    }

    public void search(View view) {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }

    @Override
    public void quitApplication() {
        getApplication();
    }

}
