package com.example.showtech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.showtech.items.Electronic;
import com.example.showtech.utils.DataProvider;
import com.example.showtech.utils.TopSellingListAdapter;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity  implements Activity{

    public final static String EXTRA_MESSAGE = "com.example.showtech.MESSAGE";

    static class ViewHolder {
        RecyclerView top_selling;
        LinearLayout computer, mobile_phone, music, camera, gaming;

    }

    private ViewHolder vh;
    private static RecyclerView.Adapter adapter;
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

        vh.top_selling = (RecyclerView) findViewById(R.id.top_selling);
        vh.top_selling.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        vh.top_selling.setLayoutManager(layoutManager);
        vh.top_selling.setItemAnimator(new DefaultItemAnimator());

        dataProvider = new DataProvider(this);
        items = dataProvider.provideData("top_selling");
        adapter = new TopSellingListAdapter(items);
        vh.top_selling.setAdapter(adapter);



    }

    public void selectCategory(View view){
        Intent intent = new Intent(this, ListActivity.class);
        String message = view.getContentDescription().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    @Override
    public void back(View view) {
    }

    @Override
    public ListActivity search(String searchInput) {
        return null;
    }

    @Override
    public void quitApplication() {
        getApplication();
    }

}
