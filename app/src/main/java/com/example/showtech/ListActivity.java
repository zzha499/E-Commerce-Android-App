package com.example.showtech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.showtech.utils.ListAdapter;

import java.util.ArrayList;
import java.util.Objects;

public class ListActivity extends AppCompatActivity  implements ListAdapter.ItemClickListener {


    public static final String EXTRA_ITEM = "com.example.showtech.ITEM";


    static class ViewHolder {
        RecyclerView list_of_items;
        SearchView searchView;
        TextView title;

    }

    private ViewHolder vh;
    private static ListAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Electronic> items;
    private String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Objects.requireNonNull(getSupportActionBar()).hide();

        vh = new ViewHolder();
        vh.list_of_items = (RecyclerView) findViewById(R.id.list_of_items);
        vh.title = (TextView) findViewById(R.id.category_title);
        vh.searchView = (SearchView) findViewById(R.id.search);
        search(vh.searchView);

        Intent intent = getIntent();
        category = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        vh.title.setText(category);

        vh.list_of_items.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        vh.list_of_items.setLayoutManager(layoutManager);
        vh.list_of_items.setItemAnimator(new DefaultItemAnimator());

        items = ListAdapter.getItems();
        adapter = new ListAdapter(items);
        adapter.getFilter().filter("category:" + category);
        adapter.setClickListener(this);
        vh.list_of_items.setAdapter(adapter);

    }

    @Override
    public void onItemClick(View view, int position) {
        Electronic item = adapter.getItem(position);
        item.addView();
        MainActivity.getAdapter().sort();
        Toast.makeText(view.getContext(), item.getName(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra(EXTRA_ITEM, item);
        startActivity(intent);
    }

    private void search(SearchView searchView) {

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter("category:" + category + " " + newText);
                return true;
            }
        });
    }

    public void back(View view) {
        finish();
    }

}
