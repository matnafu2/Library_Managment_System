package app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

public class LibrarianViewController implements Initializable {

    @FXML
    private TableView<Librarian> tableView;

    @FXML
    private TableColumn<Librarian, Integer> Id;

    @FXML
    private TableColumn<Librarian, String> name;

    @FXML
    private TableColumn<Librarian, String> password;

    @FXML
    private TableColumn<Librarian, String> email;

    @FXML
    private TableColumn<Librarian, String> address;

    @FXML
    private TableColumn<Librarian, String> city;

    @FXML
    private TableColumn<Librarian, String> contact;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Id.setCellValueFactory(new PropertyValueFactory<Librarian, Integer>("Id"));
        name.setCellValueFactory(new PropertyValueFactory<Librarian, String>("name"));
        password.setCellValueFactory(new PropertyValueFactory<Librarian, String>("password"));
        email.setCellValueFactory(new PropertyValueFactory<Librarian, String>("email"));
        address.setCellValueFactory(new PropertyValueFactory<Librarian, String>("address"));
        city.setCellValueFactory(new PropertyValueFactory<Librarian, String>("city"));
        contact.setCellValueFactory(new PropertyValueFactory<Librarian, String>("contact"));

        tableView.setItems(getLibrarian());
    }

    public ObservableList<Librarian> getLibrarian(){
        ObservableList<Librarian> libList =  FXCollections.observableArrayList();
        ArrayList<Librarian> lib = FileLoader.loadLibrarianFromFile();
        for(Librarian librarian : lib)
            libList.add(librarian);
        return libList;


    }
}
