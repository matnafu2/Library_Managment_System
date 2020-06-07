package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReturnBookController {

    @FXML
    private TextField studentId;

    @FXML
    private TextField BookCallNum;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button returnBookBtn;

    @FXML
    private Button backBtn;

    @FXML
    void back(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("LibrarianSection.fxml"));
        Scene scene = new Scene(root, 600, 600);
        Stage stage = (Stage) backBtn.getScene().getWindow();
        stage.setScene(scene);

    }
    @FXML
    void returnBook(ActionEvent event) throws Exception {
        List<Book> listOfBooks = FileLoader.loadBooks("src/books.ser");
        Map<Student, ArrayList<Book>> issuedBook = FileLoader.getIssuedBook();

        Book book = null; // a book to be removed
        boolean found = false;
        for (Book b : listOfBooks) {
            if (b.getCallNo().equalsIgnoreCase(BookCallNum.getText())) {
                found = true;
                b.addQuantity();
                b.subIssuedBook();
                Set<Student> studentSet = issuedBook.keySet();
                for (Student s : studentSet) {
                    if (s.getId().equalsIgnoreCase(studentId.getText())) {
                        issuedBook.get(s).remove(b); break; // to break out of the inner for loop
                    }
                }
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Book Returned Successfully");
                alert.showAndWait();
                break;  //to break out of the outer for loop
            }
        }

        if(!found){
            Alert alert = new Alert(Alert.AlertType.ERROR, "This book can not be returned");
            alert.setHeaderText("Error returning"); alert.showAndWait();
        }

        // Writing the book to a file
        FileOutputStream bk = new FileOutputStream("src/books.ser");
        ObjectOutputStream obj = new ObjectOutputStream(bk);
        obj.writeObject(listOfBooks);
        obj.close();

        // Writing issued Books to a file
        FileOutputStream issBook = new FileOutputStream("src/books.ser");
        ObjectOutputStream outFile = new ObjectOutputStream(issBook);
        outFile.writeObject(listOfBooks);
        outFile.close();
    }
}