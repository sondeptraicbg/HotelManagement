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
import model.Comment;
import model.Hotel;
import model.Room;
import model.Service;
import model.User;

/**
 *
 * @author laptop
 */
public class userDAO extends DBContext {

    public List<String> getTypes() {
        String sql = "select distinct RoomType from Room";
        List<String> list = new ArrayList<>();
        try {
            PreparedStatement pt = connection.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();

            while (rs.next()) {

                list.add(rs.getString("RoomType"));

            }
        } catch (SQLException e) {
            System.out.println("cant");
        }

        return list;
    }
    
    public boolean isCommented(long id, int HotelCode){
        String sql = "select GuestID from Comment where HotelCode = 30001";
        
        try {
            PreparedStatement pt = connection.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                long realID = rs.getLong("GuestID");
                if(id == realID)
                    return true;
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return false;

    }

    public void update(User c) {

        String sql = "update Guest\n"
                + "set FirstName = ?, LastName = ?, DateOfBirth = ?, Gender = ?, Email = ?, Password = ?, Address = ?\n"
                + "where RoomID = ?";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, c.getFirstName());
            ps.setString(2, c.getLastName());
            ps.setString(3, c.getDateOfBirth());
            ps.setString(4, c.getGender());
            ps.setString(5, c.getEmail());
            ps.setString(6, c.getPassword());
            ps.setString(7, c.getAddress());
            ps.setLong(8, c.getGuestID());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("cant");
        }

    }
    
    public void insertComment(Comment c) {

        String sql = "insert into Comment values (?, ?, ?)";
        try {

            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setInt(1, c.getHotel().getHotelCode());
            ps.setLong(1, c.getUser().getGuestID());
            ps.setString(1, c.getComment());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("cant");
        }

    }

    public List<Hotel> getAllHotelByCity(String city) {

        List list = new ArrayList<>();
        String sql = "select * from Hotel where HotelName like ?";

        try {
            PreparedStatement pt = connection.prepareStatement(sql);
            pt.setString(1, "%%" + city + "%%");
            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                int HotelCode = rs.getInt("HotelCode");
                String HotelName = rs.getString("HotelName");
                String Location = rs.getString("Location");
                int NumRooms = rs.getInt("NumRooms");
                String City = rs.getString("City");
                long Phone = rs.getLong("Phone");
                float StarRating = rs.getFloat("StarRating");
                String HotelImg = rs.getString("Img");
                String Map = rs.getString("Map");

                Hotel hl = new Hotel(HotelCode, HotelName, Location, NumRooms, City, Phone, StarRating, HotelImg, Map);
                list.add(hl);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;

    }

    public List<Hotel> getAllHotel() {

        List list = new ArrayList<>();
        String sql = "select * from Hotel";

        try {
            PreparedStatement pt = connection.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                int HotelCode = rs.getInt("HotelCode");
                String HotelName = rs.getString("HotelName");
                String Location = rs.getString("Location");
                int NumRooms = rs.getInt("NumRooms");
                String City = rs.getString("City");
                long Phone = rs.getLong("Phone");
                float StarRating = rs.getFloat("StarRating");
                String HotelImg = rs.getString("Img");
                String Map = rs.getString("Map");

                Hotel hl = new Hotel(HotelCode, HotelName, Location, NumRooms, City, Phone, StarRating, HotelImg, Map);
                list.add(hl);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;

    }

    public User getUserByID(long id, String password) {
        String sql = "select * from Guest where GuestID=? and Password=?";

        try {

            PreparedStatement st = connection.prepareStatement(sql);

            st.setLong(1, id);
            st.setString(2, password);

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

    public User getUserByOnlyID(long id) {
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

    public List<Room> getAllRoomByHotelCode(int id) {

        List list = new ArrayList<>();
        String sql = "select * from Room\n where HotelCode = ?";

        try {
            PreparedStatement pt = connection.prepareStatement(sql);
            pt.setInt(1, id);
            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                Room r = new Room();
                r.setRoomID(rs.getInt("RoomID"));
                r.setRoomType(rs.getString("RoomType"));
                r.setHotelCode(rs.getInt("HotelCode"));
                r.setRoomPrice(rs.getInt("RoomPrice"));
                r.setRoomImg(rs.getString("RoomImg"));
                r.setRoomDesc(rs.getString("RoomDesc"));
                r.setArea(rs.getInt("Area"));
                r.setBed(rs.getString("Bed"));
                r.setDirect(rs.getString("Direct"));
                r.setAvailable(rs.getInt("Available"));

                Hotel h = getHotelByHotelCode(id);
                r.setHotel(h);
                list.add(r);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }

    public Hotel getHotelByHotelCode(int code) {

        String sql = "select * from Hotel where HotelCode=?";

        try {

            PreparedStatement st = connection.prepareStatement(sql);

            st.setInt(1, code);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int HotelCode = rs.getInt("HotelCode");
                String HotelName = rs.getString("HotelName");
                String Location = rs.getString("Location");
                int NumRooms = rs.getInt("NumRooms");
                String City = rs.getString("City");
                long Phone = rs.getLong("Phone");
                float StarRating = rs.getFloat("StarRating");
                String HotelImg = rs.getString("Img");
                String Map = rs.getString("Map");

                Hotel h = new Hotel(HotelCode, HotelName, Location, NumRooms, City, Phone, StarRating, HotelImg, Map);

                return h;

            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;

    }

    public Room getRoomByCode(int code) {

        String sql = "select * from Room where RoomID = ?";

        try {

            PreparedStatement st = connection.prepareStatement(sql);

            st.setInt(1, code);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Room r = new Room();
                r.setRoomID(rs.getInt("RoomID"));
                r.setRoomType(rs.getString("RoomType"));
                r.setHotelCode(rs.getInt("HotelCode"));
                r.setRoomPrice(rs.getInt("RoomPrice"));
                r.setRoomImg(rs.getString("RoomImg"));
                r.setRoomDesc(rs.getString("RoomDesc"));
                r.setArea(rs.getInt("Area"));
                r.setBed(rs.getString("Bed"));
                r.setDirect(rs.getString("Direct"));
                r.setAvailable(rs.getInt("Available"));

                Hotel h = getHotelByHotelCode(rs.getInt("HotelCode"));
                r.setHotel(h);
                return r;

            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;

    }

    public List<Service> getAllService() {

        List list = new ArrayList<>();
        String sql = "select * from Service";

        try {
            PreparedStatement pt = connection.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                int serviceCode = rs.getInt("serviceCode");
                String hotelCode = rs.getString("hotelCode");
                String serviceName = rs.getString("serviceName");
                float starRating = rs.getFloat("starRating");
                String serviceImg = rs.getString("serviceImg");
                String serviceDes = rs.getString("serviceDes");

                Service s = new Service(serviceCode, hotelCode, serviceName, starRating, serviceImg, serviceDes);
                list.add(s);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;

    }

    public List<Service> getAllServiceTop() {

        List list = new ArrayList<>();
        String sql = "select top 2 * from Service\n"
                + "order by StarRating desc";

        try {
            PreparedStatement pt = connection.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                int serviceCode = rs.getInt("serviceCode");
                String hotelCode = rs.getString("hotelCode");
                String serviceName = rs.getString("serviceName");
                float starRating = rs.getFloat("starRating");
                String serviceImg = rs.getString("serviceImg");
                String serviceDes = rs.getString("serviceDes");

                Service s = new Service(serviceCode, hotelCode, serviceName, starRating, serviceImg, serviceDes);
                list.add(s);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;

    }

    public List<Room> getAllRoom() {

        List list = new ArrayList<>();
        String sql = "select * from Room";

        try {
            PreparedStatement pt = connection.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                Room r = new Room();
                r.setRoomID(rs.getInt("RoomID"));
                r.setRoomType(rs.getString("RoomType"));
                r.setHotelCode(rs.getInt("HotelCode"));
                r.setRoomPrice(rs.getInt("RoomPrice"));
                r.setRoomImg(rs.getString("RoomImg"));
                r.setRoomDesc(rs.getString("RoomDesc"));
                r.setArea(rs.getInt("Area"));
                r.setBed(rs.getString("Bed"));
                r.setDirect(rs.getString("Direct"));
                r.setAvailable(rs.getInt("Available"));
                Hotel h = getHotelByHotelCode(rs.getInt("HotelCode"));
                r.setHotel(h);
                list.add(r);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
    
    public List<Comment> getAllCommentByHotel(int id) {

        List list = new ArrayList<>();
        String sql = "select * from Comment where HotelCode = ?";

        try {
            PreparedStatement pt = connection.prepareStatement(sql);
            pt.setInt(1, id);
            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                Hotel h = getHotelByHotelCode(id);
                User u = getUserByOnlyID(rs.getLong("GuestID"));
                String comment = rs.getString("Comment");
                Comment c = new Comment(u, h, comment);
                list.add(c);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }


    public List<Room> getAllRoomTOP() {

        List list = new ArrayList<>();
        String sql = "select * from Room\n"
                + "where RoomID in\n"
                + "(select RoomID from (select top 4 count (RoomID) as number, RoomID  from Booking group by RoomID order by number desc) as tempTb)";

        try {
            PreparedStatement pt = connection.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                Room r = new Room();
                r.setRoomID(rs.getInt("RoomID"));
                r.setRoomType(rs.getString("RoomType"));
                r.setHotelCode(rs.getInt("HotelCode"));
                r.setRoomPrice(rs.getInt("RoomPrice"));
                r.setRoomImg(rs.getString("RoomImg"));
                r.setRoomDesc(rs.getString("RoomDesc"));
                r.setArea(rs.getInt("Area"));
                r.setBed(rs.getString("Bed"));
                r.setDirect(rs.getString("Direct"));
                r.setAvailable(rs.getInt("Available"));
                Hotel h = getHotelByHotelCode(rs.getInt("HotelCode"));
                r.setHotel(h);
                list.add(r);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
    
    public String forgotPassword(long id){
        String sql = "select Password from Guest where GuestID = ?";
        String ps;
        try {
            PreparedStatement pt = connection.prepareStatement(sql);
            pt.setLong(1, id);
            ResultSet rs = pt.executeQuery();

            if (rs.next()) {
                ps = rs.getString("Password");
                return ps.substring(0, 3);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return "";
    }
    
    public static void main(String[] args) {
        userDAO ud = new userDAO();
        List<Room> l = ud.getAllRoomTOP();
        System.out.println(l.get(0));
    }

}
