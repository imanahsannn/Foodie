package com.example.foodie;

public class RestaurantModal {

    private String restaurantName;
    private String restaurantOrder;
    private int restaurantRating;
    private String restaurantDistance;
    private String restaurantCuisine;
    private int id;

    // creating getter and setter methods
    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantOrder() {
        return restaurantOrder;
    }

    public void setRestaurantOrder(String restaurantOrder) {
        this.restaurantOrder = restaurantOrder;
    }

    public int setRestaurantRating() {
        return restaurantRating;
    }

    public void setRestaurantRating(int restaurantRating) {
        this.restaurantRating = restaurantRating;
    }

    public String getRestaurantDistance() {
        return restaurantDistance;
    }

    public void setRestaurantDistance(String restaurantDistance) {
        this.restaurantDistance = restaurantDistance;
    }

    public String getRestaurantCuisine() {
        return restaurantCuisine;
    }

    public void setRestaurantCuisine(String restaurantCuisine) {
        this.restaurantCuisine = restaurantCuisine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // constructor
    public RestaurantModal(String restaurantName, String restaurantOrder, int restaurantRating,
                           String restaurantDistance, String restaurantCuisine) {
        this.restaurantName = restaurantName;
        this.restaurantOrder = restaurantOrder;
        this.restaurantRating = restaurantRating;
        this.restaurantDistance = restaurantDistance;
        this.restaurantCuisine = restaurantCuisine;
    }
}

