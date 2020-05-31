package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

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

    @FXML
    void backBtn(ActionEvent event) {

    }

    @FXML
    void issueBook(ActionEvent event) throws Exception {

    }

}
