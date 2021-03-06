package app;

import javafx.beans.property.SimpleIntegerProperty;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

public class IssuedBookController implements Initializable {

        @FXML
        private AnchorPane pane;

        @FXML
        private TableView<IssuedBook> tableView;

        @FXML
        private TableColumn<IssuedBook, Integer> Id;

        @FXML
        private TableColumn<IssuedBook, String> callNo;

        @FXML
        private TableColumn<IssuedBook, String> studentID;

        @FXML
        private TableColumn<IssuedBook, String> studentName;

        @FXML
        private TableColumn<IssuedBook, String> studentContact;

        @FXML
        private TableColumn<IssuedBook, String> data;

        @FXML
        private Button backButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)  {
            Id.setCellValueFactory(new PropertyValueFactory<IssuedBook, Integer>("Id"));
            callNo.setCellValueFactory(new PropertyValueFactory<IssuedBook, String>("bookCallNo"));
            studentID.setCellValueFactory(new PropertyValueFactory<IssuedBook, String>("studentId"));
            studentName.setCellValueFactory(new PropertyValueFactory<IssuedBook, String>("studentName"));
            studentContact.setCellValueFactory(new PropertyValueFactory<IssuedBook, String>("studentContact"));
            data.setCellValueFactory(new PropertyValueFactory<IssuedBook, String>("issuedDate"));

          try{ tableView.setItems(getIssuedBook()); } catch (Exception e){e.getMessage();}
    }
    ObservableList<IssuedBook> issuedBook;
    public ObservableList<IssuedBook> getIssuedBook() throws Exception{
        issuedBook = FXCollections.observableArrayList();
         Map<Student, ArrayList<Book>> issued = FileLoader.getIssuedBook();
         Set<Student> key = issued.keySet();
         for(Student s : key){
             for (int i = 0; i < issued.get(s).size(); i++)
                     issuedBook.add(new IssuedBook(1, issued.get(s).get(i).getCallNo(), s.getId(), s.getFirstName() + " " +s.getLastName(), s.getContactNum(), issued.get(s).get(i).getBookIssuedDate()));
         }
         return issuedBook;
    }

    @FXML
    void Back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LibrarianSection.fxml"));
        Scene scene = new Scene(root, 600, 600);
        Stage stage = (Stage) tableView.getScene().getWindow();
        stage.setScene(scene);

    }
}