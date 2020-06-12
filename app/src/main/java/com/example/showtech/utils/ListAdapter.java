package com.example.showtech.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.showtech.R;
import com.example.showtech.items.Electronic;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> implements Filterable {


    private ArrayList<Electronic> items;
    private ArrayList<Electronic> filteredItems;
    private ItemClickListener itemClickListener;
    private ItemComparator itemComparator;


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

        void bind(Electronic item) {
            imageView.setImageResource(item.getImages()[0]);
            name.setText(item.getName());
            String displayedPrice = "$ " + item.getPrice().toString();
            price.setText(displayedPrice);
            description.setText(item.getDescription());
        }
    }

    public ListAdapter(ArrayList<Electronic> items) {
        itemComparator = new ItemComparator();
        this.items = items;
        this.filteredItems = items;
        this.items.sort(itemComparator);
        this.filteredItems.sort(itemComparator);
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
        holder.bind(filteredItems.get(position));
    }

    @Override
    public int getItemCount() {
        return filteredItems.size();
    }

    public Electronic getItem(int id) {
        return filteredItems.get(id);
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    filteredItems = items;
                }
                else {
                    ArrayList<Electronic> filteredList = new ArrayList<>();
                    for (Electronic item : items) {
                        if (item.getName().toLowerCase().contains(charString.toLowerCase()) ||
                                item.getDescription().toLowerCase().contains(charString.toLowerCase()) ||
                                item.getSpecification().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(item);
                        }
                    }
                    filteredList.sort(itemComparator);
                    filteredItems = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredItems;
                return filterResults;
            }
            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredItems = (ArrayList<Electronic>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public void sort() {
        items.sort(itemComparator);
        filteredItems.sort(itemComparator);
        notifyDataSetChanged();
    }
}
