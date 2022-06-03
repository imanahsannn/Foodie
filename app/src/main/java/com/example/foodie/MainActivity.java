package com.example.foodie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.CheckBox;
import android.widget.Toast;


import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    // creating variables for our edittext, button and dbhandler
    private EditText nameText, orderText, cuisineText;
    private RatingBar ratingBar;
    private CheckBox distanceBox;
    private Button addResturantBtn;
    private DBHandler dbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // database code:
        

        // viewpager code:
        // references the tabLayout and viewPager
        TabLayout tabLayout = findViewById(R.id.tabs);
        ViewPager2 viewPager2 = findViewById(R.id.viewpager);


        // creates a pageradapter, which allows the view pager to allow swiping on fragments
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        viewPager2.setAdapter(adapter);

        // mediator connects the tab to the fragment
        new TabLayoutMediator(tabLayout, viewPager2,
                new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
              switch (position) {
                  case 0:
                      tab.setText("Today");
                      break;
                  case 1:
                      tab.setText("Calendar");
                      break;
                  default:
                      tab.setText("Add");
                      break;
              }

            }
        }).attach();
    }

}