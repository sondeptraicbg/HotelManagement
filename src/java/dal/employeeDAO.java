/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ContactUs;
import model.Employee;
import model.Hotel;
import model.Room;

/**
 *
 * @author laptop
 */
public class employeeDAO extends DBContext {
    
    public List<ContactUs> getAllContact() {

        List list = new ArrayList<>();
        String sql = "select * from Contact";

        try {
            PreparedStatement pt = connection.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String Name = rs.getString("Name");
                String Email = rs.getString("Email");
                String Content = rs.getString("Content");
                boolean Status = rs.getBoolean("Status");

                ContactUs c = new ContactUs(id, Name, Email, Content, Status, "");
                list.add(c);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;

    }
    
    public ContactUs getAllContactById(int id) {

        String sql = "select * from Contact where ID = ?";

        try {
            PreparedStatement pt = connection.prepareStatement(sql);
            pt.setInt(1, id);
            ResultSet rs = pt.executeQuery();

            if(rs.next()) {
                String Name = rs.getString("Name");
                String Email = rs.getString("Email");
                String Content = rs.getString("Content");
                boolean Status = rs.getBoolean("Status");

                ContactUs c = new ContactUs(id, Name, Email, Content, Status, "");
                return c;
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;

    }
    
    public void update(Room c) {

        String sql = "update Room\n"
                + "set RoomType = ?, RoomPrice = ?, RoomImg = ?, RoomDesc = ?, Area = ?, Bed = ?, Direct = ?, Available = ?\n"
                + "where RoomID = ?";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, c.getRoomType());
            ps.setInt(2, c.getRoomPrice());
            ps.setString(3, c.getRoomImg());
            ps.setString(4, c.getRoomDesc());
            ps.setInt(5, c.getArea());
            ps.setString(6, c.getBed());
            ps.setString(7, c.getDirect());
            ps.setInt(8, c.getAvailable());
            ps.setInt(9, c.getHotelCode());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("cant");
        }

    }
    
    public void setContact(ContactUs c) {

        String sql = "update Contact\n"
                + "set Status=1, Feedbak = ?\n"
                + "where ID = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, c.getFeedback());
            ps.setInt(2, c.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
    
    
    
    public Employee getEmployeeByID(int id, String pw,String role) {
        String sql = "select * from Employees where EmoloyeeID = ? and Password = ? and Role = ?";
        
        try {
            PreparedStatement pt = connection.prepareStatement(sql);
            pt.setInt(1, id);
            pt.setString(2, pw);
            pt.setString(3, role);
            
            ResultSet rs = pt.executeQuery();
            if (rs.next()) {
                int EmployeeID = rs.getInt("EmoloyeeID");
                int HotelCode = rs.getInt("HotelCode");
                String FirstName = rs.getString("FirstName");
                String LastName = rs.getString("LastName");
                String Gender = rs.getString("Gender");
                String DateOfBirth = rs.getString("DateOfBirth");
                String Email = rs.getString("Email");
                int Salary = rs.getInt("Salary");
                String Role = rs.getString("Role");
                String Password = rs.getString("Password");
                long Phone = rs.getLong("Phone");
                String RoleDesc = rs.getString("RoleDesc");
                
                Employee e = new Employee(EmployeeID, HotelCode, FirstName, LastName, Gender, DateOfBirth, Email, Salary, Role, Password, Phone, RoleDesc);
                return e;
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
}
