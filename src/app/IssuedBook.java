package app;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class IssuedBook {
    private SimpleIntegerProperty id;
    private SimpleStringProperty bookCallNo;
    private SimpleStringProperty studentId;
    private SimpleStringProperty studentName;
    private SimpleStringProperty studentContact;
    private LocalDate issuedDate;

    public IssuedBook(int id, String callNo, String stuId, String stuName, String stuCont, LocalDate issuedDate) {
        this.id = new SimpleIntegerProperty(id);
        this.bookCallNo = new SimpleStringProperty(callNo);
        this.studentId = new SimpleStringProperty(stuId);
        this.studentName = new SimpleStringProperty(stuName);
        this.studentContact = new SimpleStringProperty(stuCont);
        this.issuedDate = issuedDate;
    }

    public void setIssuedDate(LocalDate issuedDate) {
        this.issuedDate = issuedDate;
    }

    public LocalDate getIssuedDate() {
        return issuedDate;
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getBookCallNo() {
        return bookCallNo.get();
    }

    public SimpleStringProperty bookCallNoProperty() {
        return bookCallNo;
    }

    public void setBookCallNo(String bookCallNo) {
        this.bookCallNo.set(bookCallNo);
    }

    public String getStudentId() {
        return studentId.get();
    }

    public SimpleStringProperty studentIdProperty() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId.set(studentId);
    }

    public String getStudentName() {
        return studentName.get();
    }

    public SimpleStringProperty studentNameProperty() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName.set(studentName);
    }

    public String getStudentContact() {
        return studentContact.get();
    }

    public SimpleStringProperty studentContactProperty() {
        return studentContact;
    }

    public void setStudentContact(String studentContact) {
        this.studentContact.set(studentContact);
    }


}
