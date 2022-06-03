package com.example.foodie;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "resturantdb";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "resturants";

    // below variable is for our id column.
    private static final String ID_COL = "id";

    // below variable is for our resturant name column
    private static final String NAME_COL = "name";

    // below variable id for our food order column.
    private static final String ORDER_COL = "order";

    // below variable for our rating column.
    private static final String RATING_COL = "rating";

    // below variable is for our distance  column.
    private static final String DISTANCE_COL = "distance";

    // below variable is for our cuisine column.
    private static final String CUISINE_COL = "cuisine";


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
                + ORDER_COL + "TEXT,"
                + RATING_COL + " INTEGER,"
                + DISTANCE_COL + " INTEGER,"
                + CUISINE_COL + " TEXT)";

        // calling an exec sql method to execute above sql query
        db.execSQL(query);
    }

    // add new restaurant to our sqlite database.
    public void addNewRestaurant(String name, String order, int rating, int distance, String cuisine) {

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

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // check if the table exists already
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}

