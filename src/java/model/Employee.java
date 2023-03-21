/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author laptop
 */
public class Employee {
    private int EmployeeID;
    private int HotelCode;
    private String FirstName;
    private String LastName;
    private String Gender;
    private String DateOfBirth;
    private String Email;
    private int Salary;
    private String Role;
    private String Password;
    private long Phone;
    private String RoleDesc;
    private String status;

    public Employee() {
    }

    public Employee(int EmployeeID, int HotelCode, String FirstName, String LastName, String Gender, String DateOfBirth, String Email, int Salary, String Role, String Password, long Phone, String RoleDesc) {
        this.EmployeeID = EmployeeID;
        this.HotelCode = HotelCode;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Gender = Gender;
        this.DateOfBirth = DateOfBirth;
        this.Email = Email;
        this.Salary = Salary;
        this.Role = Role;
        this.Password = Password;
        this.Phone = Phone;
        this.RoleDesc = RoleDesc;
    }

    public Employee(int EmployeeID, int HotelCode, String FirstName, String LastName, String Gender, String DateOfBirth, String Email, int Salary, String Role, String Password, long Phone, String RoleDesc, String status) {
        this.EmployeeID = EmployeeID;
        this.HotelCode = HotelCode;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Gender = Gender;
        this.DateOfBirth = DateOfBirth;
        this.Email = Email;
        this.Salary = Salary;
        this.Role = Role;
        this.Password = Password;
        this.Phone = Phone;
        this.RoleDesc = RoleDesc;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public int getEmployeeID() {
        return EmployeeID;
    }

    public int getHotelCode() {
        return HotelCode;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getGender() {
        return Gender;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public String getEmail() {
        return Email;
    }

    public int getSalary() {
        return Salary;
    }

    public String getRole() {
        return Role;
    }

    public String getPassword() {
        return Password;
    }

    public long getPhone() {
        return Phone;
    }

    public String getRoleDesc() {
        return RoleDesc;
    }

    public void setEmployeeID(int EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public void setHotelCode(int HotelCode) {
        this.HotelCode = HotelCode;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public void setDateOfBirth(String DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setSalary(int Salary) {
        this.Salary = Salary;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setPhone(long Phone) {
        this.Phone = Phone;
    }

    public void setRoleDesc(String RoleDesc) {
        this.RoleDesc = RoleDesc;
    }

    @Override
    public String toString() {
        return "Employee{" + "EmployeeID=" + EmployeeID + ", HotelCode=" + HotelCode + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Gender=" + Gender + ", DateOfBirth=" + DateOfBirth + ", Email=" + Email + ", Salary=" + Salary + ", Role=" + Role + ", Password=" + Password + ", Phone=" + Phone + ", RoleDesc=" + RoleDesc + '}';
    }
    
}
