module org.example.keineahnung {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.keineahnung to javafx.fxml;
    exports org.example.keineahnung;
}