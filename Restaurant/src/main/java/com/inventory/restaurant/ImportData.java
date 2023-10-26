package com.inventory.restaurant;

import com.inventory.restaurant.Services.IngredientService;
import com.inventory.restaurant.entities.Ingredient;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ImportData implements Initializable {

    @FXML
    private Button confirm;

    @FXML
    private Button importbutton;

    @FXML
    private Spinner<Integer> quantity;

    @FXML
    private TextField sku;

    @FXML
    private TextField txf_file;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100000, 1);
        quantity.setValueFactory(valueFactory);
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("csv Files", "*.csv"));
        Stage stage = new Stage();
        importbutton.setOnMouseClicked((event) -> {
            File selectedFile = fileChooser.showOpenDialog(stage);
            if(selectedFile!=null)
            {
                txf_file.setText(selectedFile.getPath());
                try {
                    IngredientService.importFromCsv(selectedFile.getPath());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        confirm.setOnMouseClicked((event) -> {
          String sku_value =sku.getText();
          if(validateSKU(sku_value))
          {
              Ingredient ingredient ;
              try {
                   ingredient = IngredientService.getIngredientBySku(sku_value);
              } catch (IOException e) {
                  throw new RuntimeException(e);
              }
              if(ingredient!=null)
              {
                  try {
                      List<Ingredient> list=IngredientService.getIngredientFromCsv();
                      list.remove(ingredient);
                      ingredient.AddQuantity(quantity.getValue());
                      list.add(ingredient);
                      IngredientService.writeDataLineByLine(list);
                  } catch (IOException e) {
                      throw new RuntimeException(e);
                  }
              }
              else
              {
                  Alert error = new Alert(Alert.AlertType.ERROR);
                  error.setTitle("product not found");
                  error.setHeaderText("Please verify the entered sku");
                  error.show();
              }
          }
          else
          {
              Alert error = new Alert(Alert.AlertType.ERROR);
              error.setTitle("invalid sku");
              error.setHeaderText("the sku should be of this format : XXXX-YYYY \nX:alphabetic uppercase value[A-Z] \nY: numerical value [0-9]");
              error.show();
          }
        });

    }
    public boolean validateSKU(String sku)
    {
        if(sku.length()!=9)
        {
            return false;
        }
        else
        {
            for (int i = 0; i < 4; i++) {
                if (!Character.isAlphabetic(sku.charAt(i))) {
                    return false;
                }
            }
            if (sku.charAt(4) != '-') {
                return false;
            }
            for (int i = 5; i < 9; i++) {
                if (!Character.isDigit(sku.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

}
