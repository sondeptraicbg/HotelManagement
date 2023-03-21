/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Booking;
import model.Cart;
import model.ContactUs;
import model.Hotel;
import model.Room;
import model.Service;
import model.User;

/**
 *
 * @author laptop
 */
public class defaultDAO extends DBContext {
    
    public List<Room> getRoomPage(List<Room> lr, int start, int end){
        ArrayList<Room> arr = new ArrayList<>();
        for(int i=start; i<end; i++){
            arr.add(lr.get(i));
        }
        return arr;
    }

    public void addBooking(User u, Cart cart, String bookingDate, String endDate, String spcReq, String paymentMode) {

        LocalDate currentDate = LocalDate.now();
        String date = currentDate.toString();
        String date1 = date.replaceAll("-", "");
        String bookingID = "" + u.getGuestID() / 1000 + date1;

        try {
            List<Booking> listBooking = cart.getBooking();
            for (Booking b : listBooking) {
                Long l = Long.parseLong(bookingID);
                String sql = "insert into Booking values (?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pt = connection.prepareStatement(sql);
                pt.setLong(1, l);
                pt.setInt(2, b.getRoom().getHotelCode());
                pt.setLong(3, u.getGuestID());
                pt.setString(4, bookingDate);
                pt.setString(5, spcReq);
                pt.setInt(6, b.getRoom().getRoomID());
                pt.setInt(7, b.getQuantity());
                pt.setString(8, endDate);
                pt.executeUpdate();
            }

            String sql1 = "insert into Bill values (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pt1 = connection.prepareStatement(sql1);
            Long l1 = Long.parseLong(bookingID);
            pt1.setLong(1, l1);
            pt1.setLong(2, l1);
            pt1.setLong(3, u.getGuestID());
            pt1.setInt(4, cart.getTotalMoney());
            pt1.setString(5, date);
            pt1.setString(6, paymentMode);
            pt1.setString(7, endDate);
            pt1.executeUpdate();

        } catch (NumberFormatException | SQLException e) {
            System.out.println(e);
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

                Hotel h = getHotelByHotelCode(id);
                r.setHotel(h);
                list.add(r);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
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
    
    public List<Service> getAllServiceByHotel(int id) {

        List list = new ArrayList<>();
        String sql = "select * from Service where HotelCode = ?";

        try {
            PreparedStatement pt = connection.prepareStatement(sql);
            pt.setInt(1, id);
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

    public void contactUs(ContactUs c) {
        String sql = "insert into Contact values\n"
                + "(?, ?, ?, ?, 0, null)";
        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, c.getId());
            ps.setString(2, c.getName());
            ps.setString(3, c.getGmail());
            ps.setString(4, c.getContent());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
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

    public static void main(String[] args) {
        defaultDAO d = new defaultDAO();
        List<Room> lh = d.getAllRoomByHotelCode(30001);
        System.out.println(lh.get(0));
    }
}
