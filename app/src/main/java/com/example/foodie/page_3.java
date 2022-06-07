package com.example.foodie;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link page_3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class page_3 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // creating variables for our edittext, rating bar, checkbox, button and dbhandler
    private EditText nameET, orderET, cuisineET;
    private RatingBar ratingBar;
    private CheckBox distanceBox1, distanceBox2, distanceBox3;
    private Button addRestaurantBtn;
    private DBHandler dbHandler;

    public page_3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment page_3.
     */
    // TODO: Rename and change types and number of parameters
    public static page_3 newInstance(String param1, String param2) {
        page_3 fragment = new page_3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    } // end of newInstance

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        // database code:

//        // initalize variables
//        nameET = getView().findViewById(R.id.nameET);
//        orderET = getView().findViewById(R.id.orderET);
//        cuisineET = getView().findViewById(R.id.cuisineET);
//        ratingBar = getView().findViewById(R.id.MyRating);
//        distanceBox1 = getView().findViewById(R.id.option1CB);
//        distanceBox2 = getView().findViewById(R.id.option2CB);
//        distanceBox3 = getView().findViewById(R.id.option3CB);
//        addRestaurantBtn = getView().findViewById(R.id.button);

        // create new dbhandler class and passing context into it
        //dbHandler = new DBHandler(getActivity());

//        // below line is to add on click listener for our add course button.
//        addRestaurantBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                // getting the data from editText fields
//                String inputName = nameET.getText().toString();
//                String inputOrder = orderET.getText().toString();
//                String inputCuisine = cuisineET.getText().toString();
//                int inputRating = ratingBar.getNumStars();
//                boolean inputDistance1 = distanceBox1.isChecked();
//                boolean inputDistance2 = distanceBox2.isChecked();
//                boolean inputDistance3 = distanceBox3.isChecked();
//
//
//                // make sure there is no empty fields
//                if (inputName.isEmpty() && inputOrder.isEmpty() && inputCuisine.isEmpty()) {
//                    Toast.makeText(getActivity(), "Please fill in all fields...", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//
//                // make sure one box is checked for distance
//                if ((inputDistance1 && inputDistance2) || (inputDistance1 && inputDistance3) ||
//                        (inputDistance2 && inputDistance3)) {
//                    Toast.makeText(getActivity(), "Please check one box for distance", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//
//                // adding data to db and find checked box
//                if (inputDistance1) {
//                    dbHandler.addNewRestaurant(inputName, inputOrder, inputRating, "Less than 10km", inputCuisine);
//                } else if (inputDistance2) {
//                    dbHandler.addNewRestaurant(inputName, inputOrder, inputRating, "Between 10km and 30km", inputCuisine);
//                } else {
//                    dbHandler.addNewRestaurant(inputName, inputOrder, inputRating, "More than 30km", inputCuisine);
//                }
//
//                // after adding the data we are displaying a toast message.
//                Toast.makeText(getActivity(), "Restaurant has been added!", Toast.LENGTH_SHORT).show();
//                nameET.setText("");
//                orderET.setText("");
//                ratingBar.setNumStars(0);
//                distanceBox1.setChecked(false);
//                distanceBox2.setChecked(false);
//                distanceBox3.setChecked(false);
//            }
//        });
    } // end of onCreate

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_page_3, container, false);

        // initalize variables
        nameET = view.findViewById(R.id.nameET);
        orderET = view.findViewById(R.id.orderET);
        cuisineET = view.findViewById(R.id.cuisineET);
        ratingBar = view.findViewById(R.id.MyRating);
        distanceBox1 = view.findViewById(R.id.option1CB);
        distanceBox2 = view.findViewById(R.id.option2CB);
        distanceBox3 = view.findViewById(R.id.option3CB);
        addRestaurantBtn = view.findViewById(R.id.button);

        dbHandler = new DBHandler(getContext());

        // below line is to add on click listener for our add course button.
        addRestaurantBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // getting the data from editText fields
                String inputName = nameET.getText().toString();
                String inputOrder = orderET.getText().toString();
                String inputCuisine = cuisineET.getText().toString();
                int inputRating = ratingBar.getNumStars();
                boolean inputDistance1 = distanceBox1.isChecked();
                boolean inputDistance2 = distanceBox2.isChecked();
                boolean inputDistance3 = distanceBox3.isChecked();


                // make sure there is no empty fields
                if (inputName.isEmpty() || inputOrder.isEmpty() || inputCuisine.isEmpty()) {
                    Toast.makeText(getActivity(), "Please fill in all fields...", Toast.LENGTH_SHORT).show();
                    return;
                }

                // make sure one box is checked for distance, no boxes are checked
                if (!inputDistance1 && !inputDistance2 && !inputDistance3) {
                    Toast.makeText(getActivity(), "Please check one box for distance", Toast.LENGTH_SHORT).show();
                    return;
                }

                // make sure one box is checked for distance, multiple boxes are checked
                if ((inputDistance1 && inputDistance2) || (inputDistance1 && inputDistance3) ||
                        (inputDistance2 && inputDistance3)) {
                    Toast.makeText(getActivity(), "Please check only one box for distance", Toast.LENGTH_SHORT).show();
                    return;
                }

                // adding data to db and find checked box
                if (inputDistance1) {
                    dbHandler.addNewRestaurant(inputName, inputOrder, inputRating, "Less than 10km", inputCuisine);
                } else if (inputDistance2) {
                    dbHandler.addNewRestaurant(inputName, inputOrder, inputRating, "Between 10km and 30km", inputCuisine);
                } else {
                    dbHandler.addNewRestaurant(inputName, inputOrder, inputRating, "More than 30km", inputCuisine);
                }

                // after adding the data we are displaying a toast message.
                Toast.makeText(getActivity(), "Restaurant has been added!", Toast.LENGTH_SHORT).show();
                cuisineET.setText("");
                nameET.setText("");
                orderET.setText("");
                ratingBar.setNumStars(0);
                distanceBox1.setChecked(false);
                distanceBox2.setChecked(false);
                distanceBox3.setChecked(false);
            }
        });

        return view;
    } // end of onCreateView
}