package app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ViewBookController implements Initializable {

    @FXML
    private TableView<BookManager> tableView;

    @FXML
    private TableColumn<BookManager, Integer> Id;

    @FXML
    private TableColumn<BookManager, String> callno;

    @FXML
    private TableColumn<BookManager, String> name;

    @FXML
    private TableColumn<BookManager, String> Author;

    @FXML
    private TableColumn<BookManager, String> publisher;

    @FXML
    private TableColumn<BookManager, Integer> quantity;

    @FXML
    private TableColumn<BookManager, Integer> issued;

    @FXML
    private TableColumn<BookManager, LocalDate> date;

    @FXML
    private Button backButton;


      @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Id.setCellValueFactory(new PropertyValueFactory<BookManager, Integer>("Id"));
        name.setCellValueFactory(new PropertyValueFactory<BookManager, String>("name"));
        callno.setCellValueFactory(new PropertyValueFactory<BookManager, String>("callno"));
        publisher.setCellValueFactory(new PropertyValueFactory<BookManager, String>("publisher"));
        Author.setCellValueFactory(new PropertyValueFactory<BookManager, String>("Author"));
        quantity.setCellValueFactory(new PropertyValueFactory<BookManager, Integer>("quantity"));
        issued.setCellValueFactory(new PropertyValueFactory<BookManager, Integer>("issued"));
        date.setCellValueFactory(new PropertyValueFactory<BookManager, LocalDate>("date"));

        tableView.setItems(getBook());

    }

    ObservableList<BookManager> libList;

    public ObservableList<BookManager> getBook() {
        libList = FXCollections.observableArrayList();
       ArrayList<Book> lib = FileLoader.loadBooks("src/books.ser");
        for (Book l : lib){
            libList.add(new BookManager(1, l.getCallNo(), l.getTitle(), l.getAuthor(), l.getPublisher(), l.getQuantity(), l.getIssued()));
        }

        return libList;
    }

    @FXML
    void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LibrarianSection.fxml"));
        Scene scene = new Scene(root, 600, 600);
        Stage stage = (Stage) tableView.getScene().getWindow();
        stage.setScene(scene);

    }

}
