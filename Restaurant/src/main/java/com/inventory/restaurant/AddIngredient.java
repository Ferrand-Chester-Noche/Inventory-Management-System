package com.inventory.restaurant;

import com.inventory.restaurant.Services.IngredientService;
import com.inventory.restaurant.entities.Category_ingredient;
import com.inventory.restaurant.entities.Ingredient;
import com.inventory.restaurant.entities.Unit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class AddIngredient implements Initializable {

    @FXML
    private TextField brand;

    @FXML
    private ComboBox<Category_ingredient> category;

    @FXML
    private TextArea description;

    @FXML
    private TextField name;

    @FXML
    private Spinner<Integer> quantity;

    @FXML
    private ComboBox<Unit> unit;

    @FXML
    void confirm(MouseEvent event) throws IOException {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(name.getText());
        ingredient.setCategory(category.getSelectionModel().getSelectedItem());
        ingredient.setBrand(brand.getText());
        ingredient.setQuantity(quantity.getValue());
        ingredient.setDescription(description.getText());
        ingredient.setUnit(unit.getSelectionModel().getSelectedItem());
        ingredient.setSku(IngredientService.sku(ingredient));

        IngredientService.addLine(ingredient);
        name.setText("");
        category.getSelectionModel().clearSelection();
        brand.setText("");
        quantity.getValueFactory().setValue(0);
        description.setText("");
        unit.getSelectionModel().clearSelection();



    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100000, 1);
        quantity.setValueFactory(valueFactory);
        List<Category_ingredient> lcategory = new ArrayList<>(Arrays.asList(Category_ingredient.values()));
        ObservableList<Category_ingredient> obListcat = FXCollections.observableList(lcategory);
        category.setItems(obListcat);

        List<Unit> unitList = new ArrayList<>(Arrays.asList(Unit.values()));
        ObservableList<Unit> obListUnit = FXCollections.observableList(unitList);
        unit.setItems(obListUnit);

    }
}
