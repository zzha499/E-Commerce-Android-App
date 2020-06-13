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
import com.example.showtech.Electronic;

import java.io.Serializable;
import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> implements Filterable, Serializable {


    private static ArrayList<Electronic> items;
    private ArrayList<Electronic> filteredItems;
    private ItemClickListener itemClickListener;
    private ItemComparator itemComparator;
    private boolean topSellingList;


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
            name.setText(item.getName());
            if (item.getElectronicType() == ElectronicType.UNKNOWN) {
                imageView.setVisibility(View.GONE);
                price.setVisibility(View.GONE);
                description.setText(R.string.suggestions);
            }
            else{
                imageView.setImageResource(item.getImages()[0]);
                String displayedPrice = "$ " + item.getPrice().toString();
                price.setText(displayedPrice);
                description.setText(item.getDescription());
                price.setVisibility(View.VISIBLE);
                imageView.setVisibility(View.VISIBLE);
            }
        }
    }

    public ListAdapter(ArrayList<Electronic> items) {
        itemComparator = new ItemComparator();
        ListAdapter.items = items;
        this.filteredItems = items;
        ListAdapter.items.sort(itemComparator);
        this.filteredItems.sort(itemComparator);
    }

    @NonNull
    @Override
    public ListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (parent.getContentDescription().equals("Top Selling")) {
            topSellingList = true;
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
        if (topSellingList) {
            return 5;
        }
        else {
            return filteredItems.size();
        }
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
                    String[] charStrings = charString.split(" ");
                    ArrayList<Electronic> filteredList = new ArrayList<>();
                    for (Electronic item : items) {
                        if (containTerms(item, charStrings)) {
                            filteredList.add(item);
                        }
                    }
                    if (filteredList.isEmpty()) {
                        filteredList.add(new Electronic(ElectronicType.UNKNOWN));
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

    public static ArrayList<Electronic> getItems() {
        return items;
    }

    public void sort() {
        items.sort(itemComparator);
        filteredItems.sort(itemComparator);
        notifyDataSetChanged();
    }

    private boolean containTerms(Electronic item, String[] terms) {
        for (String term : terms) {
            if (term.contains("category:")) {
                String category = term.split(":")[1];
                if (!item.getElectronicType().name().toLowerCase().equals(category.toLowerCase())) {
                    return false;
                }

            } else {
                if (!(item.getName().toLowerCase().contains(term.toLowerCase()) ||
                        item.getDescription().toLowerCase().contains(term.toLowerCase()) ||
                        item.getSpecification().toLowerCase().contains(term.toLowerCase()))) {
                    return false;
                }
            }
        }
        return true;
    }
}
