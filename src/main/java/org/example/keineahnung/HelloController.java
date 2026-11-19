package org.example.keineahnung;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController
{
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick()
    {
        welcomeText.setText("Welcome to JavaFX Application!");
    }


    public void filterAlleMedien(ActionEvent actionEvent)
    {

    }

    public void filterBücher(ActionEvent actionEvent)
    {
    }

    public void filterSpiele(ActionEvent actionEvent)
    {
    }

    public void filterFileme(ActionEvent actionEvent)
    {
    }
}