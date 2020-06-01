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

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {


    private ArrayList<Electronic> items;
    private ItemClickListener itemClickListener;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageView;
        TextView name;
        TextView price;
        TextView description;
        MyViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.imageView);
            this.name = (TextView) itemView.findViewById(R.id.name);
            this.price = (TextView) itemView.findViewById(R.id.price);
            this.description = (TextView) itemView.findViewById(R.id.description);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (itemClickListener != null) itemClickListener.onItemClick(view, getAdapterPosition());
        }
    }
    public ListAdapter(ArrayList<Electronic> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (parent.getContentDescription().equals("Top Selling")) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.top_selling_items, parent, false);
        }
        else {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_of_items, parent, false);
        }
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ImageView imageView = holder.imageView;
        TextView name = holder.name;
        TextView price = holder.price;
        TextView description = holder.description;

        imageView.setImageResource(items.get(position).getImages().get(0));
        name.setText(items.get(position).getName());
        String displayedPrice = "$ " + items.get(position).getPrice().toString();
        price.setText(displayedPrice);
        description.setText(items.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public Electronic getItem(int id) {
        return items.get(id);
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
