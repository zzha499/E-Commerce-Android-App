package com.example.showtech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.showtech.utils.ListAdapter;

import java.util.ArrayList;
import java.util.Objects;

/**
 * This is the list view of items in a category/search
 */
public class ListActivity extends AppCompatActivity  implements ListAdapter.ItemClickListener {

    // Key for intent extras
    public static final String EXTRA_ITEM = "com.example.showtech.ITEM";

    // ViewHolder for layouts
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

        // Assign each layout variable using layout ids
        vh = new ViewHolder();
        vh.list_of_items = (RecyclerView) findViewById(R.id.list_of_items);
        vh.title = (TextView) findViewById(R.id.category_title);
        vh.searchView = (SearchView) findViewById(R.id.search);
        search(vh.searchView);

        // Set title using intent extra
        Intent intent = getIntent();
        category = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        vh.title.setText(category);

        // Initialize the RecyclerView for the list of items to be displayed
        vh.list_of_items.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        vh.list_of_items.setLayoutManager(layoutManager);
        vh.list_of_items.setItemAnimator(new DefaultItemAnimator());

        // Get item from the static ListAdaptor and set up new ListAdaptor
        items = ListAdapter.getItems();
        adapter = new ListAdapter(items);

        // Filter the category
        adapter.getFilter().filter("category:" + category);
        adapter.setClickListener(this);
        vh.list_of_items.setAdapter(adapter);

    }

    /**
     * This method is called when the user clicks on a item in the list
     * A new DetailsActivity is started using a new intent with the item object as serializable extra
     * @param view The CardView(Item) user clicks on
     * @param position The position of the CardView(Item) in the RecyclerView
     */
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

    /**
     * This method is used to setup the SearchView
     * @param searchView The SearchView to be setup
     */
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

    // This method is overridden to make sure the Top Picks section on the main screen updates itself
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {
            MainActivity.getAdapter().sort();
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * This method is called when the user clicks on the back button
     * Ends the current activity and return to the previous activity
     * @param view The Back button
     */
    public void back(View view) {
        MainActivity.getAdapter().sort();
        finish();
    }

}
