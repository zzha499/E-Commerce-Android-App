package com.example.showtech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.showtech.utils.DataProvider;
import com.example.showtech.utils.ListAdapter;

import java.util.ArrayList;
import java.util.Objects;

/**
 * This is the Main page of the application, consisting of the logo, Top Picks section, and The categories section
 */
public class MainActivity extends AppCompatActivity  implements ListAdapter.ItemClickListener {

    // Key for intent extras
    public static final String EXTRA_MESSAGE = "com.example.showtech.MESSAGE";
    public static final String EXTRA_ITEM = "com.example.showtech.ITEM";

    // ViewHolder for layouts
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

        // Assign each layout variable using layout ids
        vh = new ViewHolder();
        vh.computer = (LinearLayout) findViewById(R.id.computer);
        vh.mobile_phone = (LinearLayout) findViewById(R.id.mobile);
        vh.music = (LinearLayout) findViewById(R.id.music);
        vh.camera = (LinearLayout) findViewById(R.id.camera);
        vh.gaming = (LinearLayout) findViewById(R.id.gaming);
        vh.search = (ImageView) findViewById(R.id.search);

        // Initialize RecyclerView for the Top Picks section
        vh.top_selling = (RecyclerView) findViewById(R.id.top_selling);
        vh.top_selling.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        vh.top_selling.setLayoutManager(layoutManager);
        vh.top_selling.setItemAnimator(new DefaultItemAnimator());

        // Create a dataProvider to create a list of Electronic Objects from the data stored in dataProvider class
        dataProvider = new DataProvider(this);
        items = dataProvider.provideData("all");

        // Create a List Adapter for the RecyclerView in the Top Picks section
        adapter = new ListAdapter(items);
        adapter.setClickListener(this);
        vh.top_selling.setAdapter(adapter);

    }

    /**
     * This method is called when the user selects a category.
     * A new ListActivity is started using a new intent with the category info as extra
     * @param view The LinearLayout user clicks on
     */
    public void selectCategory(View view){
        String message = view.getContentDescription().toString();
        Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ListActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    /**
     * This method is called when the user clicks on a item in the Top Picks section
     * A new DetailsActivity is started using a new intent with the item object as serializable extra
     * @param view The CardView(Item) user clicks on
     * @param position The position of the CardView(Item) in the RecyclerView
     */
    @Override
    public void onItemClick(View view, int position) {
        Electronic item = adapter.getItem(position);
        item.addView();
        Toast.makeText(view.getContext(), item.getName(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra(EXTRA_ITEM, item);
        startActivity(intent);
    }

    /**
     * This method is called when the user clicks on the search icon on the main screen
     * A new SearchActivity is started using a new intent
     * @param view The search icon (ImageView)
     */
    public void search(View view) {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }

    public static ListAdapter getAdapter() {
        return adapter;
    }
}
