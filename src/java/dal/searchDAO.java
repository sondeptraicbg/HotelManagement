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
import model.Hotel;
import model.Room;
import model.Service;

/**
 *
 * @author laptop
 */
public class searchDAO extends DBContext{
    
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
    
    public static void main(String[] args) {
        searchDAO d = new searchDAO();
        String[] ll = {"VIP", "Standard"};
        List<Room> lr = d.getAllRoomByHotelCodeCheckBox(ll);
        System.out.println(lr.get(0));
        
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
    
    public List<Room> getAllRoomByHotelCodeCheckBox(String[] id) {

        List list = new ArrayList<>();
        String sql = "select * from Room where 1=1 ";
        
        if(id!=null){
            sql += "and";
            for (String id1 : id) {
                sql += (" RoomType like '%" + id1 + "%' or");
            }
            if(sql.endsWith("or"))
                sql = sql.substring(0, sql.length()-2);
        }

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

                Hotel h = getHotelByHotelCode(rs.getInt("HotelCode"));
                r.setHotel(h);
                list.add(r);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
    
    public List<Room> getAllRoomByMaxPrice(int max) {

        List list = new ArrayList<>();
        String sql = "select * from Room where RoomPrice < ?";

        try {
            PreparedStatement pt = connection.prepareStatement(sql);
            pt.setInt(1, max);
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

                Hotel h = getHotelByHotelCode(rs.getInt("HotelCode"));
                r.setHotel(h);
                list.add(r);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
    
    public List<Room> getHotRom() {

        List list = new ArrayList<>();
        String sql = "select top 4 count (RoomID) as number, RoomID  from Booking group by RoomID order by number desc";

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

                Hotel h = getHotelByHotelCode(rs.getInt("HotelCode"));
                r.setHotel(h);
                list.add(r);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
    
    public List<Room> getAllRoomByMaxPriceAndCity(int max, int id) {

        List list = new ArrayList<>();
        String sql = "select * from Room where RoomPrice < ? and HotelCode = ?";

        try {
            PreparedStatement pt = connection.prepareStatement(sql);
            pt.setInt(1, max);
            pt.setInt(2, id);
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

                Hotel h = getHotelByHotelCode(rs.getInt("HotelCode"));
                r.setHotel(h);
                list.add(r);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
    
    public List<Room> getAllRoomByIntervalPriceAndCity(int min, int max, int id) {

        List list = new ArrayList<>();
        String sql = "select * from Room where RoomPrice between ? and ? and HotelCode = ?";

        try {
            PreparedStatement pt = connection.prepareStatement(sql);
            pt.setInt(1, min);
            pt.setInt(2, max);
            pt.setInt(3, id);
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

                Hotel h = getHotelByHotelCode(rs.getInt("HotelCode"));
                r.setHotel(h);
                list.add(r);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
    public List<Room> getAllRoomByType(String type, int id) {

        List list = new ArrayList<>();
        String sql = "select * from Room where RoomType like ? and HotelCode = ?";

        try {
            PreparedStatement pt = connection.prepareStatement(sql);
            pt.setString(1, type + "%");
            pt.setInt(2, id);
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

                Hotel h = getHotelByHotelCode(rs.getInt("HotelCode"));
                r.setHotel(h);
                list.add(r);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
    
    public List<Room> getAllRoomByMaxPriceInHotel(int max, int id) {

        List list = new ArrayList<>();
        String sql = "select * from Room where RoomPrice < ? and HotelCode = ?";

        try {
            PreparedStatement pt = connection.prepareStatement(sql);
            pt.setInt(1, max);
            pt.setInt(2, id);
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

                Hotel h = getHotelByHotelCode(rs.getInt("HotelCode"));
                r.setHotel(h);
                list.add(r);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
    
    public List<Room> getAllRoomByMaxInteval(int min, int max) {

        List list = new ArrayList<>();
        String sql = "select * from Room where RoomPrice between ? and ?";

        try {
            PreparedStatement pt = connection.prepareStatement(sql);
            pt.setInt(1, min);
            pt.setInt(2, max);
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

                Hotel h = getHotelByHotelCode(rs.getInt("HotelCode"));
                r.setHotel(h);
                list.add(r);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
    
    public List<Room> getAllRoomByMaxIntevalInHotel(int min, int max, int hotelID) {

        List list = new ArrayList<>();
        String sql = "select * from Room where (RoomPrice between ? and ?) and HotelCode = ?";

        try {
            PreparedStatement pt = connection.prepareStatement(sql);
            pt.setInt(1, min);
            pt.setInt(2, max);
            pt.setInt(3, max);
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

                Hotel h = getHotelByHotelCode(rs.getInt("HotelCode"));
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
    
    public List<Room> getAllRoomArrange(String arrange) {

        List list = new ArrayList<>();
        String sql;
        
        if(arrange.equals("low")){
            sql = "select * from Room order by RoomPrice";
        }else{
            sql = "select * from Room order by RoomPrice desc";
        }

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
    
    public List<Room> getAllRoomArrangeInHotel(String arrange, int id) {

        List list = new ArrayList<>();
        String sql;
        
        if(arrange.equals("low")){
            sql = "select * from Room where HotelCode=? order by RoomPrice";
        }else{
            sql = "select * from Room where HotelCode=? order by RoomPrice desc";
        }

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
                Hotel h = getHotelByHotelCode(rs.getInt("HotelCode"));
                r.setHotel(h);
                list.add(r);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
    
}
