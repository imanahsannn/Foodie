package com.example.foodie;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ViewRestaurantActivity extends AppCompatActivity {

    // creating variables for our edittext, rating bar, checkbox, button and dbhandler
    private TextView nameTV, orderTV, cuisineTV;
    private TextView name2;
    private RatingBar ratingBar;
    private CheckBox distanceBox1, distanceBox2, distanceBox3;
    private Button deleteRestaurantBtn;
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

        // adding on click listener to our update course button.
        deleteRestaurantBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // inside this method we are calling an update course
                // method and passing all our edit text values.
                dbHandler.deleteRestaurant(name);

                // displaying a toast message that our course has been updated.
                Toast.makeText(ViewRestaurantActivity.this, "Restaurant Deleted..", Toast.LENGTH_SHORT).show();

                // launching our main activity.
                Intent i = new Intent(ViewRestaurantActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View view =  inflater.inflate(R.layout.activity_view_restaurant, container, false);

//        // initializing all our variables.
//        nameTV =  findViewById(R.id.nameETdetail);
//        orderTV = findViewById(R.id.orderETdetail);
//        ratingBar = findViewById(R.id.MyRatingdetail);
//        distanceBox1 = findViewById(R.id.option1CBdetail);
//        distanceBox2 = findViewById(R.id.option2CBdetail);
//        distanceBox3 = findViewById(R.id.option3CBdetail);
//        cuisineTV = findViewById(R.id.cuisineETdetail);
//
//
//        // initialing our dbhandler class.
//        dbHandler = new DBHandler(ViewRestaurantActivity.this);
//
//        // getting data which we passed in our adapter class.
//        name = getIntent().getStringExtra("name");
//        order = getIntent().getStringExtra("order");
//        rating = getIntent().getIntExtra("rating", 0);
//        distance = getIntent().getStringExtra("distance");
//        cuisine = getIntent().getStringExtra("cuisine");
//
//
//        // setting data to edit text of our update activity.
//        nameTV.setText(name);
//        orderTV.setText(order);
//        ratingBar.setRating(rating);
//        if (distance.contains("10-30")){
//            distanceBox1.setChecked(false);
//            distanceBox2.setChecked(true);
//            distanceBox3.setChecked(false);
//        }
//        else if (distance.contains("10")){
//            distanceBox1.setChecked(true);
//            distanceBox2.setChecked(false);
//            distanceBox3.setChecked(false);
//        } else {
//            distanceBox1.setChecked(false);
//            distanceBox2.setChecked(false);
//            distanceBox3.setChecked(true);
//        }
//        cuisineTV.setText(cuisine);
//
//        // adding on click listener to our update course button.
//        deleteRestaurantBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                // inside this method we are calling an update course
//                // method and passing all our edit text values.
//                dbHandler.deleteRestaurant(name);
//
//                // displaying a toast message that our course has been updated.
//                Toast.makeText(ViewRestaurantActivity.this, "Restaurant Deleted..", Toast.LENGTH_SHORT).show();
//
//                // launching our main activity.
//                Intent i = new Intent(ViewRestaurantActivity.this, MainActivity.class);
//                startActivity(i);
//            }
//        });
//
//        return view;
//    }
}

