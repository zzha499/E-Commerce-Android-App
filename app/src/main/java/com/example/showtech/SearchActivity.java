package com.example.showtech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class SearchActivity extends AppCompatActivity  implements Activity{

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

    class ViewHolder {
    }

    private ViewHolder vh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        vh = new ViewHolder();
    }
}
