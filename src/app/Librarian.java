package app;


import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;
import java.util.Map;

public class Librarian implements Serializable {

    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String city;
    private String contactNum;
    private int id;
    private static int count = 1;

    /**
     * <<<<<<< HEAD:src/app/Librarian.java
     * Construct a librarian using the specified field
     *
     * @param name       name of the librarian
     * @param password   librarian password
     * @param email      librarian email
     * @param address    librarian address
     * @param city       librarian city
     * @param ID         librarian address
     * @param contactNum librarian contact number
     *                   =======
     * @param firstName
     * @param lastName
     * @param email
     * @param address
     * @param city
     * @param contactNum >>>>>>> master:src/Librarian.java
     */
    public Librarian(String firstName, String lastName, String email, String address, String city, String contactNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.city = city;
        this.contactNum = contactNum;
        this.id = count++;
        System.out.println(count);
    }

    public int getId() {
        return id;
    }

    public void setID(int id){
        this.id =  id;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", contactNum='" + contactNum + '\'' +
                '}';
    }
}
