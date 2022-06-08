package com.example.foodie;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    private static final String DB_NAME = "restaurantdb";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "resturants";
    private static final String ID_COL = "id";
    private static final String NAME_COL = "names";
    private static final String ORDER_COL = "orders";
    private static final String RATING_COL = "ratings";
    private static final String DISTANCE_COL = "distance";
    private static final String CUISINE_COL = "cuisines";

    // constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating an sqlite query and setting column names along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + ORDER_COL + " TEXT,"
                + RATING_COL + " INTEGER,"
                + DISTANCE_COL + " TEXT,"
                + CUISINE_COL + " TEXT)";

        // calling an exec sql method to execute above sql query
        db.execSQL(query);
    }

    // add new restaurant to our sqlite database.
    public void addNewRestaurant(String name, String order, int rating, String distance, String cuisine) {

        // creating a variable for our database and calling writable method as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // creating a variable for content values.
        ContentValues values = new ContentValues();

        // passing all values along with its key and value pair.
        values.put(NAME_COL, name);
        values.put(ORDER_COL, order);
        values.put(RATING_COL, rating);
        values.put(DISTANCE_COL, distance);
        values.put(CUISINE_COL, cuisine);

        // passing content values to our table.
        db.insert(TABLE_NAME, null, values);

        // closing our database after adding database.
        db.close();
    }

    public ArrayList<RestaurantModal> readRestaurants() {

        // create db
        SQLiteDatabase db = this.getReadableDatabase();

        // creating a cursor with query to read data from database
        Cursor restaurantCursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<RestaurantModal> restaurantModalArrayList = new ArrayList<>();

        // moving our cursor to first position
        if (restaurantCursor.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                restaurantModalArrayList.add(new RestaurantModal(restaurantCursor.getString(1),
                        restaurantCursor.getString(2),
                        restaurantCursor.getInt(3),
                        restaurantCursor.getString(4),
                        restaurantCursor.getString(5)));
            } while (restaurantCursor.moveToNext());
            // moving our cursor to next.
        }
        restaurantCursor.close();
        return restaurantModalArrayList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // check if the table exists already
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}

