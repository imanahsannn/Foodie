package com.example.foodie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ViewRestaurantActivity extends AppCompatActivity {

    // creating variables for our edittext, rating bar, checkbox, button and dbhandler
    private TextView nameTV, orderTV, cuisineTV;
    private TextView name2;
    private RatingBar ratingBar;
    private CheckBox distanceBox1, distanceBox2, distanceBox3;
    private Button deleteRestaurantBtn, goBackBtn;
    private DBHandler dbHandler;
    String name, order, cuisine, distance;
    float rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_restaurant);

        // initializing all our variables.
        nameTV =  findViewById(R.id.nameETdetail);
        orderTV = findViewById(R.id.orderETdetail);
        ratingBar = findViewById(R.id.MyRatingdetail);
        distanceBox1 = findViewById(R.id.option1CBdetail);
        distanceBox2 = findViewById(R.id.option2CBdetail);
        distanceBox3 = findViewById(R.id.option3CBdetail);
        cuisineTV = findViewById(R.id.cuisineETdetail);
        deleteRestaurantBtn = findViewById(R.id.delete);
        goBackBtn = findViewById(R.id.btnEditCancel);

        // initialing our dbhandler class.
        dbHandler = new DBHandler(ViewRestaurantActivity.this);

        // getting data which we passed in our adapter class.
        name = getIntent().getStringExtra("name");
        order = getIntent().getStringExtra("order");
        rating = getIntent().getFloatExtra("rating", 0);
        distance = getIntent().getStringExtra("distance");
        cuisine = getIntent().getStringExtra("cuisine");


        // setting data to edit text of our update activity.
        nameTV.setText(name);
        orderTV.setText(order);
        ratingBar.setRating(rating);
        if (distance.contains("10-30")){
            distanceBox1.setChecked(false);
            distanceBox2.setChecked(true);
            distanceBox3.setChecked(false);
        }
        else if (distance.contains("10")){
            distanceBox1.setChecked(true);
            distanceBox2.setChecked(false);
            distanceBox3.setChecked(false);
        } else {
            distanceBox1.setChecked(false);
            distanceBox2.setChecked(false);
            distanceBox3.setChecked(true);
        }
        cuisineTV.setText(cuisine);

        // adding on click listener to our delete restaurant button.
        deleteRestaurantBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dbHandler.deleteRestaurant(name);

                // displaying a toast message that our course has been updated.
                Toast.makeText(ViewRestaurantActivity.this, "Restaurant Deleted...", Toast.LENGTH_SHORT).show();

                finish();
            }
        });

        // adding on click listener to our go back  button.
        goBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });


    }

}

