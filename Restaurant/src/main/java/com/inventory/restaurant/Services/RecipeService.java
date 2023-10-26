package com.inventory.restaurant.Services;

import com.inventory.restaurant.entities.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecipeService {
    private List<Recipe> recipeList;

    public RecipeService()
    {
        recipeList = Initialize();
    }

    public  List<Recipe> Initialize()
    {
        recipeList = new ArrayList<>();
        recipeList.add(new Recipe("-------   APPETIZERS   ------"));
        recipeList.add(new Recipe("Grilled Onigiri", Category_food.APPETIZERS, List.of(
                new Ingredient("Rice", Category_ingredient.RICE, "", 600, Unit.g, "Rice"))));
        recipeList.add(new Recipe("Edamame",Category_food.APPETIZERS,List.of(
                new Ingredient("edamame",Category_ingredient.VEGETABLES,"",450,Unit.g,"edamame"),
                new Ingredient("Salt",Category_ingredient.CONDIMENT,"",4,Unit.g,"Salt"),
                new Ingredient("Garlic",Category_ingredient.VEGETABLES,"",5,Unit.g,"Garlic"),
                new Ingredient("Sesame Oil", Category_ingredient.CONDIMENT,"",7,Unit.g,"Olive oil"))));
        recipeList.add(new Recipe("Hiyayakko",Category_food.APPETIZERS,List.of(
                new Ingredient("Tofu",Category_ingredient.MEAT,"",85,Unit.g,"Japanese Cold"),
                new Ingredient("katsuobushi",Category_ingredient.CONDIMENT,"",10,Unit.g,"(dried bonito flakes)"),
                new Ingredient("Green onions",Category_ingredient.VEGETABLES,"",15,Unit.g,"green onions"),
                new Ingredient("Grated ginger", Category_ingredient.CONDIMENT,"",3,Unit.g,"Grated Ginger"))));

        recipeList.add(new Recipe("-------   MAIN COURSE   -------"));
        recipeList.add(new Recipe("Maguro sushi",Category_food.MAIN_COURSE,List.of(
                new Ingredient("Tuna fillet",Category_ingredient.FISH,"",125,Unit.g,"tuna"),
                new Ingredient("Rice",Category_ingredient.RICE,"",150,Unit.g,"Rice"),
                new Ingredient("water",Category_ingredient.BEVERAGE,"",180,Unit.ml,"water"),
                new Ingredient("Vinegar", Category_ingredient.CONDIMENT,"",12,Unit.ml,"Vinegar"),
                new Ingredient("Salt",Category_ingredient.CONDIMENT,"",3,Unit.g,"Salt"),
                new Ingredient("Sugar",Category_ingredient.CONDIMENT,"",7,Unit.g,"Sugar"),
                new Ingredient("Wasabi paste",Category_ingredient.CONDIMENT,"",2,Unit.g,"Wasabi"))));
        recipeList.add(new Recipe("Shake sushi",Category_food.MAIN_COURSE,List.of(
                new Ingredient("Salmon fillet",Category_ingredient.FISH,"",125,Unit.g,"salmon"),
                new Ingredient("Rice",Category_ingredient.RICE,"",150,Unit.g,"Rice"),
                new Ingredient("water",Category_ingredient.BEVERAGE,"",180,Unit.ml,"water"),
                new Ingredient("Vinegar", Category_ingredient.CONDIMENT,"",12,Unit.ml,"Vinegar"),
                new Ingredient("Salt",Category_ingredient.CONDIMENT,"",3,Unit.g,"Salt"),
                new Ingredient("Sugar",Category_ingredient.CONDIMENT,"",7,Unit.g,"Sugar"),
                new Ingredient("Wasabi paste",Category_ingredient.CONDIMENT,"",2,Unit.g,"Wasabi"))));
        recipeList.add(new Recipe("Hamachi sushi",Category_food.MAIN_COURSE,List.of(
                new Ingredient("Hamachi fillet",Category_ingredient.FISH,"",125,Unit.g,"hamachi"),
                new Ingredient("Rice",Category_ingredient.RICE,"",150,Unit.g,"Rice"),
                new Ingredient("water",Category_ingredient.BEVERAGE,"",180,Unit.ml,"water"),
                new Ingredient("Vinegar", Category_ingredient.CONDIMENT,"",12,Unit.ml,"Vinegar"),
                new Ingredient("Salt",Category_ingredient.CONDIMENT,"",3,Unit.g,"Salt"),
                new Ingredient("Sugar",Category_ingredient.CONDIMENT,"",7,Unit.g,"Sugar"))));
        recipeList.add(new Recipe("Saba sushi",Category_food.MAIN_COURSE,List.of(
                new Ingredient("Saba fillet",Category_ingredient.FISH,"",125,Unit.g,"saba"),
                new Ingredient("Rice",Category_ingredient.RICE,"",150,Unit.g,"Rice"),
                new Ingredient("water",Category_ingredient.BEVERAGE,"",180,Unit.ml,"water"),
                new Ingredient("Vinegar", Category_ingredient.CONDIMENT,"",12,Unit.ml,"Vinegar"),
                new Ingredient("Salt",Category_ingredient.CONDIMENT,"",3,Unit.g,"Salt"),
                new Ingredient("Sugar",Category_ingredient.CONDIMENT,"",7,Unit.g,"Sugar"))));

        recipeList.add(new Recipe("-------   SIDE DISHES   -------"));
        recipeList.add(new Recipe("Spicy Bean Sprout Salad",Category_food.SIDE_DISHES,List.of(
                new Ingredient("Bean sprouts",Category_ingredient.VEGETABLES,"",340,Unit.g,"bean sprout"),
                new Ingredient("Sesame seeds",Category_ingredient.FRUIT,"",15,Unit.g,"sesame seeds"),
                new Ingredient("Sesame oil",Category_ingredient.CONDIMENT,"",30,Unit.g,"sesame oil"),
                new Ingredient("Soy sauce", Category_ingredient.SAUCE,"",7,Unit.g,"soy sauce"),
                new Ingredient("Shichimi togarashi",Category_ingredient.CONDIMENT,"",7,Unit.g,"Japanese 7 spice"),
                new Ingredient("Salt",Category_ingredient.CONDIMENT,"",2,Unit.g,"Salt"))));
        recipeList.add(new Recipe("Tamagoyaki",Category_food.SIDE_DISHES,List.of(
                new Ingredient("Eggs",Category_ingredient.MEAT,"",7,Unit.g,"eggs"),
                new Ingredient("vegetable oil",Category_ingredient.CONDIMENT,"",30,Unit.g,"vegetable oil"))));
        recipeList.add(new Recipe("-------   DESSERTS   -------"));
        recipeList.add(new Recipe("Strawberry Shiratama Dango",Category_food.SIDE_DISHES,List.of(
                new Ingredient("Tofu",Category_ingredient.MEAT,"",50,Unit.g,"tofu"),
                new Ingredient("Strawberries",Category_ingredient.MEAT,"",50,Unit.g,"strawberry"),
                new Ingredient("Shiratamako",Category_ingredient.MEAT,"",50,Unit.g,"shiratamako"),
                new Ingredient("Water",Category_ingredient.BEVERAGE,"",7,Unit.g,"water"))));
        recipeList.add(new Recipe("Daigaku Imo",Category_food.SIDE_DISHES,List.of(
                new Ingredient("Japanese Sweet Potato",Category_ingredient.VEGETABLES,"",300,Unit.g,"potato"),
                new Ingredient("Cooking oil",Category_ingredient.CONDIMENT,"",30,Unit.g,"cooking oil"),
                new Ingredient("Sugar",Category_ingredient.CONDIMENT,"",30,Unit.g,"sugar"),
                new Ingredient("Soy sauce",Category_ingredient.SAUCE,"",2,Unit.g,"soy sauce"),
                new Ingredient("Sesame seed",Category_ingredient.BEVERAGE,"",10,Unit.g,"sesame seed"))));

        recipeList.add(new Recipe("-------   Beverages   -------"));
        recipeList.add(new Recipe("soju",Category_food.BEVERAGES,List.of(
                new Ingredient("soju",Category_ingredient.BEVERAGE,"",1,Unit.bottle,"soju"))));
        recipeList.add(new Recipe("Matcha Green Tea",Category_food.BEVERAGES,List.of(
                new Ingredient("Matcha",Category_ingredient.CONDIMENT,"",5,Unit.g,"matcha"),
                new Ingredient("Boiling water",Category_ingredient.BEVERAGE,"",60,Unit.g,"water"))));
        recipeList.add(new Recipe("Canned Soda",Category_food.BEVERAGES,List.of(
                new Ingredient("pepsi",Category_ingredient.BEVERAGE,"",1,Unit.bottle,"soda"))));

        recipeList.add(new Recipe("-------   T-shirts   -------"));
        recipeList.add(new Recipe("ImOnARoll",Category_food.TSHIRTS,List.of(
                new Ingredient("t-shirt",Category_ingredient.TSHIRT,"",1,Unit.piece,"shirt"))));

        recipeList.add(new Recipe("-------   Bags   -------"));
        recipeList.add(new Recipe("Fin tastic taste",Category_food.BAGS,List.of(
                new Ingredient("fin tastic taste",Category_ingredient.BAGS,"",1,Unit.piece,"tote bag"))));
        recipeList.add(new Recipe("SushiRaw mance",Category_food.BAGS,List.of(
                new Ingredient("sushiraw mance",Category_ingredient.BAGS,"",1,Unit.piece,"tote bag"))));

        return recipeList;
    }

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

}
