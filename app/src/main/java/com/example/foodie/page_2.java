package com.example.foodie;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link page_2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class page_2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    SearchView searchView;
    ArrayAdapter<RestaurantModal> adapter;
    private ArrayList<RestaurantModal> restaurantModalArrayList;
    private DBHandler dbHandler;
    private RestaurantRVAdapter restaurantRVAdapter;
    private RecyclerView restaurantRV;

    public page_2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment page_2.
     */
    // TODO: Rename and change types and number of parameters
    public static page_2 newInstance(String param1, String param2) {
        page_2 fragment = new page_2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_page_2, container, false);

        searchView = view.findViewById(R.id.searchView);

        // initializing our all variables
        restaurantModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(getContext());

        // getting restaurant array list from db handler class
        restaurantModalArrayList = dbHandler.readRestaurants();

        // passing array list to adapter class
        restaurantRVAdapter = new RestaurantRVAdapter(restaurantModalArrayList, getContext());
        restaurantRV = view.findViewById(R.id.idRVRestaurant2);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        restaurantRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        restaurantRV.setAdapter(restaurantRVAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query){
                ArrayList<RestaurantModal> newList = new ArrayList<>();
               for (RestaurantModal restaurant: restaurantModalArrayList) {
                   String name = restaurant.getRestaurantName();
                   if (name.toLowerCase(Locale.ROOT).contains(query.toLowerCase(Locale.ROOT))) {
                       newList.add(restaurant);
                   }
               }
               restaurantRVAdapter.setFilter(newList);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }
        });

        return view;
    }
}