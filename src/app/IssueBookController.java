package app;

import java.io.*;
import java.lang.reflect.Constructor;
import java.time.LocalDate;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @author Mikias
 */
public class IssueBookController {

    @FXML
    private AnchorPane pane;

    @FXML
    private TextField studentId;

    @FXML
    private TextField callNo;

    @FXML
    private TextField studentName;

    @FXML
    private TextField studentContact;

    @FXML
    private Button issueBookBtn;

    @FXML
    private Button back;

    FileLoader loadBook = new FileLoader();

    @FXML
    void backBtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LibrarianSection.fxml"));
        Scene scene = new Scene(root, 600, 600);
        Stage stage = (Stage) pane.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    void issueBook(ActionEvent event) throws Exception {

        if(studentId.getText().isBlank() || studentContact.getText().isBlank()
        || studentName.getText().isBlank() || callNo.getText().isBlank()){
            Alert alert = new Alert(Alert.AlertType.ERROR, "You have to fill out everything");
            alert.showAndWait();;
        }
        else {
            String lastName = " ";
            String[] stName = studentName.getText().split(" ");
            if(stName.length > 1) // this line checks if the students first and last name is entered
                lastName = stName[1];
            Student student = new Student(stName[0], lastName, studentId.getText(), studentContact.getText());

            ArrayList<Book> listOfBook = FileLoader.loadBooks("src/books.ser");

            Map<Student, ArrayList<Book>> borrowedBook = FileLoader.getIssuedBook();
            //subtract the book quantity and add the issued book
            //Map<Student, ArrayList<Book>> borrowedBook = getIssuedBook();
            if (!listOfBook.isEmpty()) {
                FileOutputStream bBook = new FileOutputStream("src/IssuedBook.txt");
                ObjectOutputStream obj = new ObjectOutputStream(bBook);

                FileOutputStream file = new FileOutputStream("src/books.ser");
                ObjectOutputStream outFile = new ObjectOutputStream(file);

                Book b = null;
                boolean found = false;
                for (Book book : listOfBook) {
                    if (book.getCallNo().equalsIgnoreCase(callNo.getText())) {
                        found = true;
                        if (book.getQuantity() > 0) {
                            book.subQuantityBy1();
                            book.addIssuedBook();
                            b = book;
                            if (!borrowedBook.isEmpty()) {
                                if (borrowedBook.containsKey(student))
                                    borrowedBook.get(student).add(b);
                                else {
                                    ArrayList<Book> boo = new ArrayList<>();
                                    boo.add(b);
                                    borrowedBook.put(student, boo);
                                }
                                b.setBookIssuedDate(LocalDate.now()); // set the books issued date
                                obj.writeObject(borrowedBook);
                                outFile.writeObject(listOfBook);
                                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Book issued Successfully");
                                alert.showAndWait();
                                break;
                            } else {
                                ArrayList<Book> bo = new ArrayList<>();
                                bo.add(b);
                                borrowedBook.put(student, bo);
                                b.setBookIssuedDate(LocalDate.now()); // set the books issued date
                                obj.writeObject(borrowedBook);
                                outFile.writeObject(listOfBook);
                                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Book issued Successfully");
                                alert.showAndWait();
                            }
                        } else {
                            Alert alert = new Alert(Alert.AlertType.ERROR, book.getTitle() + " book is not available now. Please check back later");
                            alert.setHeaderText("Book not available");
                            alert.showAndWait();
                            obj.writeObject(borrowedBook);
                            outFile.writeObject(listOfBook);
                            break;
                        }
                    }

                }
                if (!found) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "The book you are looking for is not in stock");
                    alert.showAndWait();
                    outFile.writeObject(listOfBook);
                    obj.writeObject(borrowedBook); // if the book to be withdrawn does not exist, the file will be written back
                }

                obj.close();
                outFile.close();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "There are no books to be issued");
                alert.showAndWait();
            }
        }

    }
}
