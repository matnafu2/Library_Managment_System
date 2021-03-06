package app;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class BookManager {
    private SimpleIntegerProperty id;
    private SimpleStringProperty callno;
    private SimpleStringProperty name;
    private SimpleStringProperty Author;
    private SimpleStringProperty Publisher;
    private SimpleIntegerProperty quantity;
    private SimpleIntegerProperty issued;
    private  LocalDate date;
    public BookManager(int id, String callno, String name, String Author, String publisher, int quantity, int issued) {
        this.id = new SimpleIntegerProperty(id);
        this.callno = new SimpleStringProperty(callno);
        this.name = new SimpleStringProperty(name);
        this.Author = new SimpleStringProperty(Author);
        Publisher = new SimpleStringProperty(publisher);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.issued = new SimpleIntegerProperty(issued);
        date = LocalDate.now();
    }

    public SimpleIntegerProperty quantityProperty() {
        return quantity;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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

    public String getCallno() {
        return callno.get();
    }

    public SimpleStringProperty callnoProperty() {
        return callno;
    }

    public void setCallno(String callno) {
        this.callno.set(callno);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getAuthor() {
        return Author.get();
    }

    public SimpleStringProperty authorProperty() {
        return Author;
    }

    public void setAuthor(String author) {
        this.Author.set(author);
    }

    public String getPublisher() {
        return Publisher.get();
    }

    public SimpleStringProperty publisherProperty() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        this.Publisher.set(publisher);
    }

    public int getQuantity() {
        return quantity.get();
    }

    public void setQuantity(int quantity) {
        this.quantity.set(quantity);
    }

    public int getIssued() {
        return issued.get();
    }

    public SimpleIntegerProperty issuedProperty() {
        return issued;
    }

    public void setIssued(int issued) {
        this.issued.set(issued);
    }
}
