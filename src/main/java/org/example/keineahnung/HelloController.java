package org.example.keineahnung;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.DataManager;
import org.example.io.Files_IO_KA;
import org.example.media.Book;
import org.example.media.Game;
import org.example.media.Media;
import org.example.media.Movie;

import java.io.IOException;
import java.nio.file.Path;

public class HelloController
{
    DataManager dataManager = DataManager.getInstance();
    Path path = Path.of("src/main/java/org/example/res/data.csv");
    String fillterdClass = String.valueOf(Media.class);
    String filter = "";

    @FXML
    private Label welcomeText;

    @FXML
    private TableView<Media> tableMedia;

    @FXML
    private TableColumn<Media, String> colTitle;
    @FXML
    private TableColumn<Media, String> colType;
    @FXML
    private TableColumn<Media, String> colGenre;
    @FXML
    private TableColumn<Media, Integer> colYear;
    @FXML
    private TableColumn<Media, Double> colRating; // oder String, je nach Datentyp
    @FXML
    private TableColumn<Media, String> colExtra;

    // Das ist die Liste, die direkt mit der Tabelle verknüpft wird
    private final ObservableList<Media> mediaData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Verbindet die Spalten mit den Gettern Ihrer Media-Klassen
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        colYear.setCellValueFactory(new PropertyValueFactory<>("year"));
        colRating.setCellValueFactory(new PropertyValueFactory<>("rating"));
        colExtra.setCellValueFactory(new PropertyValueFactory<>("extraInfo"));

        // Bindet die Datenliste an die Tabelle
        tableMedia.setItems(mediaData);

        // Echtzeit-Suche: Filtert die Tabelle automatisch während Sie tippen!
        txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            aktualisiereTabelle();
        });
    }

    private void aktualisiereTabelle()
    {
        dataManager.filterListByInstance(fillterdClass);
        mediaData.setAll(dataManager.searchByTitle(filter)); // maybe need to add if "" => all into the list

        System.out.print("table got updated\n");
    }

    @FXML
    private TextField txtSearch;

    public HelloController() throws IOException
    {
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }




    public void filterAlleMedien(ActionEvent actionEvent)
    {
        fillterdClass = String.valueOf(Media.class);
        aktualisiereTabelle();
    }

    public void filterBücher(ActionEvent actionEvent)
    {
        fillterdClass = String.valueOf(Book.class);
        aktualisiereTabelle();
    }

    public void filterSpiele(ActionEvent actionEvent)
    {
        fillterdClass = String.valueOf(Game.class);
        aktualisiereTabelle();
    }

    public void filterFilme(ActionEvent actionEvent)
    {
        fillterdClass = String.valueOf(Movie.class);
        aktualisiereTabelle();
    }

    public void save(ActionEvent actionEvent) throws IOException
    {
        Files_IO_KA.writeData(path, dataManager.getMediaList(), false);
    }

    public void load(ActionEvent actionEvent) throws IOException
    {
        dataManager.addList(Files_IO_KA.readData(path));
        aktualisiereTabelle();
    }

    public void searchTitle(ActionEvent actionEvent)
    {
        // todo i want to change it so serch by title and filter
        // todo by does the "same thing" so we could say only movies with "the" int the name
        filter = txtSearch.getText();
        // todo daten anzeigen

        aktualisiereTabelle();
    }

    public void resetSearchTitle(ActionEvent actionEvent)
    {
        filter = "";
        aktualisiereTabelle();
    }
}