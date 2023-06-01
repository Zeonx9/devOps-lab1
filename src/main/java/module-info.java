module com.example.devopslab1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;


    opens com.example.devopslab1 to javafx.fxml;
    exports com.example.devopslab1;
    exports com.example.devopslab1.view;
    opens com.example.devopslab1.view to javafx.fxml;
    exports com.example.devopslab1.model;
    opens com.example.devopslab1.model to javafx.fxml;
}