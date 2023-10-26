package com.inventory.restaurant;

import com.inventory.restaurant.Services.IngredientService;
import com.inventory.restaurant.Services.RecipeService;
import com.inventory.restaurant.entities.Category_food;
import com.inventory.restaurant.entities.Ingredient;
import com.inventory.restaurant.entities.Recipe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class RecipeController implements Initializable {
    @FXML
    private Label Recipe_name;
    @FXML
    private AnchorPane ap;
    @FXML
    private AnchorPane full_pane;
    @FXML
    private ListView<Recipe> recipe;
    @FXML
    private Label recipe_ingredients;

    @FXML
    private ImageView image;

    private Recipe selected_recipe;
    private boolean notSufficient;

    @FXML
    private Button preparebtn;

    public ObservableList<Recipe> getListRecipe()
    {
        ObservableList<Recipe> items = FXCollections.observableArrayList();
        items.addAll(new RecipeService().getRecipeList());
        return items;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        notSufficient=false;
        recipe.setItems(getListRecipe());
        recipe.setOnMouseClicked((event)->{

            selected_recipe = recipe.getSelectionModel().getSelectedItem();
            if(selected_recipe.getName().contains("-"))
            {
                System.out.println("not a recipe");
            }
            else
            {
                Recipe_name.setText(selected_recipe.getName());
                String full_text = "";
                for (Ingredient ingredient : selected_recipe.getIngredientList()) {
                    full_text += "\u2022" + ingredient.getQuantity();
                    full_text += ingredient.getUnit() + " " + ingredient.getName() + '\n';
                }
                recipe_ingredients.setText(full_text);
                String image_name = "/Pictures/Recipe/"+selected_recipe.getName().toLowerCase()+".jpg";
                System.out.println(image_name);
                Image img= new Image(Objects.requireNonNull(getClass().getResource(image_name)).toString());
                image.setFitHeight(150);
                image.setFitWidth(200);
                image.setImage(img);
            }
        });
        preparebtn.setOnMouseClicked((event -> {
            String text="";
            for (Ingredient ingredient : selected_recipe.getIngredientList())
            {
                Ingredient stock ;
                try {
                    stock = IngredientService.CheckSufficientIngredientsByName(ingredient);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if(stock==null)
                {
                    notSufficient=true;
                    break;
                }
            }
            for (Ingredient ingredient : selected_recipe.getIngredientList())
            {
                Ingredient stock ;
                try {
                    stock = IngredientService.CheckSufficientIngredientsByName(ingredient);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if(!notSufficient)
                {
                    try {
                        IngredientService.Prepare(stock,ingredient);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    text += "Recipe prepared successfully \n Remaining ingredients: \n "+stock.getName()+" : " + stock.getQuantity() + stock.getUnit();

                }
            }
            if(notSufficient)
            {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setTitle("Insufficient storage");
                error.setHeaderText("Not enough ingredients in stock for this recipe");
                error.show();
            }
            else
            {
                Alert done = new Alert(Alert.AlertType.CONFIRMATION);
                done.setTitle("Recipe prepared");
                done.setHeaderText(text);
                done.show();
            }
            notSufficient=false;
        }));

    }

}
