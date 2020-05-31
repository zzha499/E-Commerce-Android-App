package com.example.showtech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.showtech.items.Electronic;
import com.example.showtech.utils.DataProvider;
import com.example.showtech.utils.ListAdapter;

import java.util.ArrayList;
import java.util.Objects;

public class ListActivity extends AppCompatActivity  implements Activity{

    static class ViewHolder {
        RecyclerView list_of_items;
        TextView title;

    }

    private ViewHolder vh;
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Electronic> items;
    private DataProvider dataProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Objects.requireNonNull(getSupportActionBar()).hide();

        vh = new ViewHolder();
        vh.list_of_items = (RecyclerView) findViewById(R.id.list_of_items);
        vh.title = (TextView) findViewById(R.id.category_title);

        Intent intent = getIntent();
        String category = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        vh.title.setText(category);

        vh.list_of_items.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        vh.list_of_items.setLayoutManager(layoutManager);
        vh.list_of_items.setItemAnimator(new DefaultItemAnimator());

        dataProvider = new DataProvider(this);
        items = dataProvider.provideData(category);
        adapter = new ListAdapter(items);
        vh.list_of_items.setAdapter(adapter);

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
