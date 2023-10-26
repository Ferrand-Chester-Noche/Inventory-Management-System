package com.inventory.restaurant.entities;

public enum Category_ingredient {
    CONDIMENT,BEVERAGE,MEAT,FISH,FRUIT,VEGETABLES,SAUCE,PASTA,RICE,BAGS,TSHIRT;

    public static Category_ingredient getByCatName(String name)
    {
        for(Category_ingredient cat : values())
        {
            if(cat.toString().equals(name)) {
                return cat;
            }
        }
        throw  new IllegalArgumentException("Error");
    }
}
