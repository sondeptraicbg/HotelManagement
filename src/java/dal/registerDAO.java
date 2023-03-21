/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author laptop
 */
public class registerDAO extends DBContext {

    public void registerUser(User u) {
        String sql = "insert into Guest values \n"
                + "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try{
            PreparedStatement pt = connection.prepareStatement(sql);
            
            pt.setLong(1, u.getGuestID());
            pt.setString(2, u.getFirstName());
            pt.setString(3, u.getLastName());
            pt.setString(4, u.getDateOfBirth());
            pt.setLong(5, u.getGuestID());
            pt.setString(6, u.getGender());
            pt.setString(7, u.getEmail());
            pt.setString(8, u.getPassword());
            pt.setString(9, u.getAddress());
            
            pt.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public User getUserByID(long id){
        String sql = "select * from Guest where GuestID=?";

        try {

            PreparedStatement st = connection.prepareStatement(sql);
            
            st.setLong(1, id);
            
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                
                User c = new User();
                c.setGuestID(rs.getLong("GuestID"));
                c.setFirstName(rs.getString("FirstName"));
                c.setLastName(rs.getString("LastName"));
                c.setDateOfBirth(rs.getString("DateOfBirth"));
                c.setGender(rs.getString("Gender"));
                c.setEmail(rs.getString("Email"));
                c.setPassword(rs.getString("Password"));
                c.setAddress(rs.getString("Address"));
                return c;
                
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

}
