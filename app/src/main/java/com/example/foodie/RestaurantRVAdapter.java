package com.example.foodie;

import android.content.Context;
import android.content.Intent;
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
        holder.restaurantRating.setText(String.valueOf(modal.getRestaurantRating()));
        //ADD IMAGE HOLDER IF NEEDED

        // below line is to add on click listener for our recycler view item.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // on below line we are calling an intent.
                Intent i = new Intent(context, ViewRestaurantActivity.class);

                // below we are passing all our values.
                i.putExtra("name", modal.getRestaurantName());
                i.putExtra("order", modal.getRestaurantOrder());
                i.putExtra("rating", modal.getRestaurantRating());
                i.putExtra("distance", modal.getRestaurantDistance());
                i.putExtra("cuisine", modal.getRestaurantCuisine());

                // starting our activity.
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return restaurantModalArrayList.size();
    }

    public void setFilter(ArrayList<RestaurantModal> newList){
        restaurantModalArrayList = new ArrayList<>();
        restaurantModalArrayList.addAll(newList);
        notifyDataSetChanged();
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