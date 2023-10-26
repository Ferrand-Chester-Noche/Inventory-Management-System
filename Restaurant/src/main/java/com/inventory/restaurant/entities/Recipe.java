package com.inventory.restaurant.entities;

import java.util.List;

public class Recipe {
    private String name;
    private Category_food category_food;
    private List<Ingredient> ingredientList;

    public Recipe(String name)
    {
        this.name=name;
    }
    public Recipe(String name,Category_food category_food, List<Ingredient> ingredientList) {
        this.name = name;
        this.category_food=category_food;
        this.ingredientList = ingredientList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public Category_food getCategory_food() {
        return category_food;
    }

    public void setCategory_food(Category_food category_food) {
        this.category_food = category_food;
    }

    @Override
    public String toString() {
        return name;
    }
}
