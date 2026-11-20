module org.example.keineahnung {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.xml.dom;

    // Das erlaubt JavaFX den Zugriff auf Ihre Controller-Klassen
    opens org.example.keineahnung to javafx.fxml;

    // =========================================================================
    // NEU: Diese Zeile zwingend hinzufügen, damit die TableView Daten lesen darf!
    // =========================================================================
    opens org.example.media to javafx.base, javafx.fxml;

    // Falls Ihr DataManager in org.example liegt, das eventuell auch öffnen:
    opens org.example to javafx.base;

    exports org.example.keineahnung;
}
/*
requires javafx.controls;
        requires javafx.fxml;
        requires jdk.xml.dom;


        opens org.example.keineahnung to javafx.fxml;
        exports org.example.keineahnung;

 */