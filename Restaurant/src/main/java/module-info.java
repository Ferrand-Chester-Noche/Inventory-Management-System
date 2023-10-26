module com.inventory.restaurant {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.inventory.restaurant to javafx.fxml;
    exports com.inventory.restaurant;
}