package com.example.foodie;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link page_1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class page_1 extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // creating variables for our array list, dbhandler, adapter and recycler view.
    private ArrayList<RestaurantModal> restaurantModalArrayList;
    private DBHandler dbHandler;
    private RestaurantRVAdapter restaurantRVAdapter;
    private RecyclerView restaurantRV;

    public page_1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment page_1.
     */
    // TODO: Rename and change types and number of parameters
    public static page_1 newInstance(String param1, String param2) {
        page_1 fragment = new page_1();
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
        View view =  inflater.inflate(R.layout.fragment_page_1, container, false);

        // initializing our all variables
        restaurantModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(getContext());

        // getting restaurant array list from db handler class
        restaurantModalArrayList = dbHandler.readRestaurants();

        // passing array list to adapter class
        restaurantRVAdapter = new RestaurantRVAdapter(restaurantModalArrayList, getContext());
        restaurantRV = (RecyclerView) view.findViewById(R.id.idRVRestaurant);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        restaurantRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        restaurantRV.setAdapter(restaurantRVAdapter);

        return view;
    }

}