package com.inventory.restaurant;

import com.inventory.restaurant.Services.IngredientService;
import com.inventory.restaurant.entities.Category_ingredient;
import com.inventory.restaurant.entities.Ingredient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

public class ViewIngredient implements Initializable {

    @FXML
    private ListView<Ingredient> Listview;

    @FXML
    private AnchorPane ap;

    @FXML
    private ChoiceBox<String> cb;

    @FXML
    private ImageView image;

    @FXML
    private Label name;

    @FXML
    private Label stock;

    @FXML
    private Label description;
    public ObservableList<Ingredient> getListIngredient(List<Ingredient> list)
    {
        ObservableList<Ingredient> items = FXCollections.observableArrayList();
        items.addAll(list);
        return items;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            ObservableList<Ingredient> items = getListIngredient(IngredientService.getIngredientFromCsv());
            Listview.setItems(items);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        List<String> list = new ArrayList<>();
        for(Category_ingredient cat : Category_ingredient.values())
        {
            list.add(cat.toString());
        }

        ObservableList<String> obList = FXCollections.observableList(list);
        cb.getItems().clear();
        cb.setItems(obList);
        cb.setOnAction((event)->{
            String category = cb.getSelectionModel().getSelectedItem();
            try {
                ObservableList<Ingredient> items = getListIngredient(IngredientService.getIngredientsByCategory(Category_ingredient.getByCatName(category)));
                Listview.setItems(items);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println(category);
        });
        Listview.setOnMouseClicked((event)->{
            Ingredient Ingredient = Listview.getSelectionModel().getSelectedItem();
            System.out.println();
            name.setText(Ingredient.getName()+" : "+ Ingredient.getBrand());
            stock.setText(String.valueOf(Ingredient.getQuantity())+" " +Ingredient.getUnit());
            description.setText(Ingredient.getDescription());

            String image_name = "/Pictures/Ingredients/"+Ingredient.getName().toLowerCase()+".jpg";

            Image img= new Image(Objects.requireNonNull(getClass().getResource(image_name)).toString());
            image.setFitHeight(150);
            image.setFitWidth(200);
            image.setImage(img);
        });
    }
    @FXML
    void deleteIngredient(MouseEvent event) throws IOException {
        if(Listview.getSelectionModel().getSelectedItem()!=null)
        {
            Ingredient ingredient = Listview.getSelectionModel().getSelectedItem();
            List<Ingredient> list=IngredientService.getIngredientFromCsv();
            list.remove(ingredient);
            IngredientService.writeDataLineByLine(list);
            Listview.setItems(getListIngredient(list));
            image.setImage(null);
            name.setText("");
            stock.setText("");
        }


    }
}
