package com.example.showtech.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.showtech.R;
import com.example.showtech.items.Electronic;

import java.util.ArrayList;

public class TopSellingListAdapter extends ListAdapter {


    private ArrayList<Electronic> items;

    public TopSellingListAdapter(ArrayList<Electronic> items) {
        super(items);
    }

    @NonNull
    @Override
    public TopSellingListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.top_selling_items, parent, false);
        return new MyViewHolder(view);
    }
}
