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

public class SearchActivity extends AppCompatActivity  implements ListAdapter.ItemClickListener {

    public static final String ITEM = "com.example.showtech.ITEM";

    static class ViewHolder {
        RecyclerView search_results;
        SearchView searchView;
        TextView title;
    }

    private SearchActivity.ViewHolder vh;
    private static ListAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Electronic> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Objects.requireNonNull(getSupportActionBar()).hide();

        vh = new SearchActivity.ViewHolder();
        vh.search_results = (RecyclerView) findViewById(R.id.search_results);
        vh.title = (TextView) findViewById(R.id.search_title);
        vh.searchView = (SearchView) findViewById(R.id.search);
        vh.title.setText(R.string.search);
        search(vh.searchView);


        vh.search_results.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        vh.search_results.setLayoutManager(layoutManager);
        vh.search_results.setItemAnimator(new DefaultItemAnimator());

        items = ListAdapter.getItems();
        adapter = new ListAdapter(items);
        adapter.setClickListener(this);
        vh.search_results.setAdapter(adapter);


    }

    private void search(SearchView searchView) {

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return true;
            }
        });
    }

    @Override
    public void onItemClick(View view, int position) {
        Electronic item = adapter.getItem(position);
        item.addView();
        MainActivity.getAdapter().sort();
        adapter.sort();
        Toast.makeText(view.getContext(), item.getName(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra(ITEM, item);
        startActivity(intent);
    }

    public void back(View view) {
        finish();
    }

}
