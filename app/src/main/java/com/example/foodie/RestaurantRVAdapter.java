package com.example.foodie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class RestaurantRVAdapter extends RecyclerView.Adapter<RestaurantRVAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<RestaurantModal> restaurantModalArrayList;
    private Context context;

    // constructor
    public RestaurantRVAdapter(ArrayList<RestaurantModal> restaurantModalArrayList, Context context) {
        this.restaurantModalArrayList = restaurantModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflating our layout file for recycler view items
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // setting data to our views of recycler view item
        RestaurantModal modal = restaurantModalArrayList.get(position);
        holder.restaurantNameTV.setText(modal.getRestaurantName());
        holder.restaurantRating.setText(modal.getRestaurantRating());
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return restaurantModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView restaurantNameTV, restaurantRating;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            restaurantNameTV = itemView.findViewById(R.id.nameTVpg1);
            restaurantRating = itemView.findViewById(R.id.ratingTVpg1);
        }
    }
}
