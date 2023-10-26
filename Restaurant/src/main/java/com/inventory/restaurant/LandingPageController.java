package com.inventory.restaurant;

import com.inventory.restaurant.Services.IngredientService;
import com.inventory.restaurant.entities.Category_ingredient;
import com.inventory.restaurant.entities.Ingredient;
import com.inventory.restaurant.entities.Unit;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class LandingPageController  {


    @FXML
    private AnchorPane ap;


    private void LoadPage(String page){
        Parent root = null;
        ap.getChildren().clear();
        try{
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(page + ".fxml")));
        }catch(IOException ex)
        {
            System.out.println("ERROR TRANSITION "+ex);
        }
        ap.getChildren().add(root);
    }
    @FXML
    void Ingredients(MouseEvent event) {
        LoadPage("Ingredients");
    }

    @FXML
    void Recipe(MouseEvent event) {
        LoadPage("Recipe");
    }

}
