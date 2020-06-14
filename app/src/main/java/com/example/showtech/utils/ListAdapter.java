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

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * A ListAdaptor is created for each RecyclerView in the app
 * The List adapter is responsible for managing/searching the items in the RecyclerView
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> implements Filterable {


    private static ArrayList<Electronic> items;
    private ArrayList<Electronic> filteredItems;
    private ItemClickListener itemClickListener;
    private ItemComparator itemComparator;
    private boolean topPicks;
    private static DecimalFormat df2 = new DecimalFormat("#.##");

    // ViewHolder for layouts
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageView;
        TextView name;
        TextView price;
        TextView description;
        View itemView;
        MyViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.imageView);
            this.name = (TextView) itemView.findViewById(R.id.name);
            this.price = (TextView) itemView.findViewById(R.id.price);
            this.description = (TextView) itemView.findViewById(R.id.description);
            this.itemView = itemView;
            itemView.setOnClickListener(this);
        }

        // Setting the itemClickListener for the RecyclerView
        @Override
        public void onClick(View view) {
            if (itemClickListener != null) itemClickListener.onItemClick(view, getAdapterPosition());
        }

        /**
         * Bing the displayed items in a recyclerView with Electronic objects
         * @param item The Electronic object to be bind
         */
        void bind(Electronic item) {
            name.setText(item.getName());
            if (item.getElectronicType() == ElectronicType.UNKNOWN) {
                itemView.setClickable(false);
                imageView.setVisibility(View.GONE);
                price.setVisibility(View.GONE);
                description.setText(R.string.suggestions);
            }
            else{
                itemView.setClickable(true);
                imageView.setImageResource(item.getImages()[0]);
                String displayedPrice = "$" + df2.format(item.getPrice());
                price.setText(displayedPrice);
                description.setText(item.getDescription());
                price.setVisibility(View.VISIBLE);
                imageView.setVisibility(View.VISIBLE);
            }
        }
    }

    // ListAdapter constructor
    public ListAdapter(ArrayList<Electronic> items) {
        // Setting up new comparator for sorting
        itemComparator = new ItemComparator();
        ListAdapter.items = items;
        this.filteredItems = items;
        ListAdapter.items.sort(itemComparator);
        this.filteredItems.sort(itemComparator);
    }

    /**
     * This method creates a new ViewHolder based on the chosen layout (Top Picks or Item List)
     * @param parent The parent ViewGroup
     * @param viewType The viewType
     * @return The ViewHolder created
     */
    @NonNull
    @Override
    public ListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (parent.getContentDescription().equals("Top Picks")) {
            topPicks = true;
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.top_selling_items, parent, false);
        }
        else {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_of_items, parent, false);
        }
        return new MyViewHolder(view);
    }

    /**
     * This method binds the ViewHolder with a Electronic object in the filteredList
     * @param holder The ViewHolder to be bind
     * @param position The position of the Electronic object in the filteredList
     */
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bind(filteredItems.get(position));
    }

    @Override
    public int getItemCount() {
        // Restrict Top Picks section to only display 5 items
        if (topPicks) {
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

    /**
     * This method is overridden to define the filter for the RecyclerView
     * @return The created filter
     */
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

                    // Filter by category first
                    for (Electronic item : items) {
                        if (!charString.contains("category:") && (charString.toLowerCase().contains(item.getElectronicType().name().toLowerCase()) ||
                                item.getElectronicType().name().toLowerCase().contains(charString.toLowerCase()))) {
                            filteredList.add(item);
                        }
                    }

                    // Filter by item name/description second
                    for (Electronic item : items) {
                        if (containTerms(item, charStrings)) {
                            if (!filteredList.contains(item)) {
                                filteredList.add(item);
                            }
                        }
                    }

                    // Added dummy item for no result message if no items are added
                    if (filteredList.isEmpty()) {
                        filteredList.add(new Electronic(ElectronicType.UNKNOWN));
                    }
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

    /**
     * Sort the list of Electronics in the RecyclerView using the custom comparator
     */
    public void sort() {
        items.sort(itemComparator);
        filteredItems.sort(itemComparator);
        notifyDataSetChanged();
    }

    /**
     * Determine if an Electronic object contain a term
     * @param item The Electronic object
     * @param terms The term to search for
     * @return True if the Electronic does contain the term otherwise false
     */
    private boolean containTerms(Electronic item, String[] terms) {
        for (String term : terms) {
            // compare the category of the electronic first
            if (term.contains("category:")) {
                if (term.split(":").length > 1) {
                    String category = term.split(":")[1];
                    if (!item.getElectronicType().name().toLowerCase().equals(category.toLowerCase())) {
                        return false;
                    }
                }
            }
            else {
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
