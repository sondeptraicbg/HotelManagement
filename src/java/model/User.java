/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author laptop
 */
public class User {
    private long guestID;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private String email;
    private String password;
    private String address;

    public User() {
    }

    public User(long GuestID, String FirstName, String LastName, String DateOfBirth, String Gender, String Email, String Password, String Address) {
        this.guestID = GuestID;
        this.firstName = FirstName;
        this.lastName = LastName;
        this.dateOfBirth = DateOfBirth;
        this.gender = Gender;
        this.email = Email;
        this.password = Password;
        this.address = Address;
    }

    public long getGuestID() {
        return guestID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public void setGuestID(long GuestID) {
        this.guestID = GuestID;
    }

    public void setFirstName(String FirstName) {
        this.firstName = FirstName;
    }

    public void setLastName(String LastName) {
        this.lastName = LastName;
    }

    public void setDateOfBirth(String DateOfBirth) {
        this.dateOfBirth = DateOfBirth;
    }

    public void setGender(String Gender) {
        this.gender = Gender;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }

    public void setPassword(String Password) {
        this.password = Password;
    }

    public void setAddress(String Address) {
        this.address = Address;
    }

    @Override
    public String toString() {
        return "User{" + "GuestID=" + guestID + ", FirstName=" + firstName + ", LastName=" + lastName + ", DateOfBirth=" + dateOfBirth + ", Gender=" + gender + ", Email=" + email + ", Password=" + password + ", Address=" + address + '}';
    }
    
}
