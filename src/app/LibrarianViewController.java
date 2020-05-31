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
    private TableView<LibrarianViewManager> tableView;

    @FXML
    private TableColumn<LibrarianViewManager, Integer> Id;

    @FXML
    private TableColumn<LibrarianViewManager, String> name;

    @FXML
    private TableColumn<LibrarianViewManager, String> password;

    @FXML
    private TableColumn<LibrarianViewManager, String> email;

    @FXML
    private TableColumn<LibrarianViewManager, String> address;

    @FXML
    private TableColumn<LibrarianViewManager, String> city;

    @FXML
    private TableColumn<LibrarianViewManager, String> contact;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Id.setCellValueFactory(new PropertyValueFactory<LibrarianViewManager, Integer>("Id"));
        name.setCellValueFactory(new PropertyValueFactory<LibrarianViewManager, String>("name"));
        password.setCellValueFactory(new PropertyValueFactory<LibrarianViewManager, String>("password"));
        email.setCellValueFactory(new PropertyValueFactory<LibrarianViewManager, String>("email"));
        address.setCellValueFactory(new PropertyValueFactory<LibrarianViewManager, String>("address"));
        city.setCellValueFactory(new PropertyValueFactory<LibrarianViewManager, String>("city"));
        contact.setCellValueFactory(new PropertyValueFactory<LibrarianViewManager, String>("contact"));

        tableView.setItems(getLibrarian());
    }

    ObservableList<LibrarianViewManager> libList;

    public ObservableList<LibrarianViewManager> getLibrarian() {
        libList = FXCollections.observableArrayList();
        ArrayList<Librarian> lib = FileLoader.loadLibrarianFromFile();
        for (Librarian l : lib) {
            libList.add(new LibrarianViewManager(l.getId(), l.getFirstName(), l.getLastName(), l.getEmail(), l.getAddress(), l.getCity(), l.getContactNum()));
        }
        return libList;
    }
}
