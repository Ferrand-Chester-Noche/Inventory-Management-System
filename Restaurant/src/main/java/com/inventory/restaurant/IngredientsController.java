package com.inventory.restaurant;

import com.inventory.restaurant.Services.IngredientService;
import com.inventory.restaurant.entities.Category_ingredient;
import com.inventory.restaurant.entities.Ingredient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class IngredientsController {
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
    void add(MouseEvent event) {
        LoadPage("AddIngredient");
    }

    @FXML
    void view(MouseEvent event) {
        LoadPage("ViewIngredient");
    }
    @FXML
    void importData(MouseEvent event) {
        LoadPage("ImportData");
    }

    @FXML
    void use(MouseEvent event) {

    }

}
