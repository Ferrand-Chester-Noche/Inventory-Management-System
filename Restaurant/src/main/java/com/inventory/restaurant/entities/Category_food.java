package com.inventory.restaurant.entities;

public enum Category_food {
    APPETIZERS("Appetizers"),
    MAIN_COURSE("Main Course"),
    SIDE_DISHES("Side Dishes"),
    DESSERTS("Desserts"),
    BEVERAGES("Beverages"),
    TSHIRTS("T-shirts"),
    BAGS("Bags");

    private String name;
    Category_food(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
