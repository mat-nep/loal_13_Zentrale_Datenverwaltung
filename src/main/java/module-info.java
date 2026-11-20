module org.example.keineahnung {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.xml.dom;


    opens org.example.keineahnung to javafx.fxml;
    exports org.example.keineahnung;
}