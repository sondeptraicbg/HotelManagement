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
import model.Booking;
import model.Employee;
import model.Hotel;
import model.MonthlyType;
import model.MonthlyVolume;
import model.Room;
import model.Service;
import model.User;

/**
 *
 * @author laptop
 */
public class manageDAO extends DBContext {

    public static void main(String[] args) {
        manageDAO d = new manageDAO();
        Employee e = d.getAllEmployeeByID(3000001);
        System.out.println(e);
    }

    public List<Employee> getAllEmployeeByHotel(int id) {

        List list = new ArrayList<>();
        String sql = "select * from Employees where HotelCode = ?";

        try {
            PreparedStatement pt = connection.prepareStatement(sql);
            pt.setInt(1, id);
            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                int EmployeeID = rs.getInt("EmoloyeeID");
                int HotelCode = rs.getInt("HotelCode");
                String FirstName = rs.getString("FirstName");
                String Gender = rs.getString("Gender");
                String DateOfBirth = rs.getString("DateOfBirth");
                String LastName = rs.getString("LastName");
                String Email = rs.getString("Email");
                String RoleDesc = rs.getString("RoleDesc");
                int salary = rs.getInt("Salary");
                String Role = rs.getString("Role");
                String Password = rs.getString("Password");
                long Phone = rs.getLong("Phone");
                String Status = rs.getString("Status");

                Employee c = new Employee(EmployeeID, HotelCode, FirstName, LastName, Gender, DateOfBirth, Email, salary, Role, Password, Phone, RoleDesc, Status);
                list.add(c);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;

    }

    public List<Employee> getAllEmployeeByHotelWithStatus(int id) {

        List list = new ArrayList<>();
        String sql = "select * from Employees where HotelCode = ?";

        try {
            PreparedStatement pt = connection.prepareStatement(sql);
            pt.setInt(1, id);
            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                int EmployeeID = rs.getInt("EmoloyeeID");
                int HotelCode = rs.getInt("HotelCode");
                String FirstName = rs.getString("FirstName");
                String Gender = rs.getString("Gender");
                String DateOfBirth = rs.getString("DateOfBirth");
                String LastName = rs.getString("LastName");
                String Email = rs.getString("Email");
                String RoleDesc = rs.getString("RoleDesc");
                int salary = rs.getInt("Salary");
                String Role = rs.getString("Role");
                String Password = rs.getString("Password");
                long Phone = rs.getLong("Phone");
                String Status = rs.getString("Status");

                Employee c = new Employee(EmployeeID, HotelCode, FirstName, LastName, Gender, DateOfBirth, Email, salary, Role, Password, Phone, RoleDesc, Status);
                list.add(c);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;

    }

    public Employee getAllEmployeeByID(long id) {

        String sql = "select * from Employees where EmoloyeeID = ?";

        try {
            PreparedStatement pt = connection.prepareStatement(sql);
            pt.setLong(1, id);
            ResultSet rs = pt.executeQuery();

            if (rs.next()) {
                int EmployeeID = rs.getInt("EmoloyeeID");
                int HotelCode = rs.getInt("HotelCode");
                String FirstName = rs.getString("FirstName");
                String Gender = rs.getString("Gender");
                String DateOfBirth = rs.getString("DateOfBirth");
                String LastName = rs.getString("LastName");
                String Email = rs.getString("Email");
                String RoleDesc = rs.getString("RoleDesc");
                int salary = rs.getInt("Salary");
                String Role = rs.getString("Role");
                String Password = rs.getString("Password");
                long Phone = rs.getLong("Phone");
                String Status = rs.getString("Status");

                Employee c = new Employee(EmployeeID, HotelCode, FirstName, LastName, Gender, DateOfBirth, Email, salary, Role, Password, Phone, RoleDesc, Status);
                return c;
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;

    }

    public List<Employee> getAllEmployee() {

        List list = new ArrayList<>();
        String sql = "select * from Employees";

        try {
            PreparedStatement pt = connection.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                int EmployeeID = rs.getInt("EmoloyeeID");
                int HotelCode = rs.getInt("HotelCode");
                String FirstName = rs.getString("FirstName");
                String Gender = rs.getString("Gender");
                String DateOfBirth = rs.getString("DateOfBirth");
                String LastName = rs.getString("LastName");
                String Email = rs.getString("Email");
                String RoleDesc = rs.getString("RoleDesc");
                int salary = rs.getInt("Salary");
                String Role = rs.getString("Role");
                String Password = rs.getString("Password");
                long Phone = rs.getLong("Phone");

                Employee c = new Employee(EmployeeID, HotelCode, FirstName, LastName, Gender, DateOfBirth, Email, salary, Role, Password, Phone, RoleDesc);
                list.add(c);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;

    }

    public List<Booking> getAllBooking() {

        List list = new ArrayList<>();
        String sql = "select * from Booking";

        try {
            PreparedStatement pt = connection.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                long bookingID = rs.getLong("BookingID");
                int HotelCode = rs.getInt("HotelCode");
                long guestID = rs.getLong("GuestID");
                String bookingDate = rs.getString("BookingDate");
                String SpecialReq = rs.getString("SpecialReq");
                int RoomID = rs.getInt("RoomID");
                String Type = rs.getString("Type");
                String EndDate = rs.getString("EndDate");
                Room r = getRoomByCode(RoomID);
                User u = getUserByID(guestID);

                Booking c = new Booking(bookingID, HotelCode, u.getFirstName() + " " + u.getLastName(), bookingDate, "", "", 0, SpecialReq, r, 0, Type, EndDate);
                list.add(c);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;

    }

    public List<Booking> getAllBookingByGuestName(String name) {
        
        if(name==null){
            return null;
        }
        
        List list = new ArrayList<>();
        String sql = "select * from Booking";

        try {
            PreparedStatement pt = connection.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                long bookingID = rs.getLong("BookingID");
                int HotelCode = rs.getInt("HotelCode");
                long guestID = rs.getLong("GuestID");
                String bookingDate = rs.getString("BookingDate");
                String SpecialReq = rs.getString("SpecialReq");
                int RoomID = rs.getInt("RoomID");
                String Type = rs.getString("Type");
                String EndDate = rs.getString("EndDate");
                Room r = getRoomByCode(RoomID);

                User u = getUserByID(guestID);
                if (u.getFirstName().contains(name) || u.getLastName().contains(name)) {
                    Booking c = new Booking(bookingID, HotelCode, u.getFirstName() + " " + u.getLastName(), bookingDate, "", "", 0, SpecialReq, r, 0, Type, EndDate);
                    list.add(c);
                }

            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;

    }

    public User getUserByID(long id) {
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

    public List<MonthlyVolume> getBookingByMonth() {
        List list = new ArrayList<>();
        try {

            for (int i = 10; i > 4; i--) {
                String sql = "SELECT COUNT(*) as sum FROM Booking WHERE Month(BookingDate) = ?";
                PreparedStatement pt = connection.prepareStatement(sql);
                pt.setInt(1, i);
                ResultSet rs = pt.executeQuery();
                if (rs.next()) {
                    list.add(new MonthlyVolume(i, rs.getInt("sum")));
                }
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;

    }

    public List<MonthlyVolume> getBookingByMonthWithPrice() {
        List list = new ArrayList<>();
        try {

            for (int i = 20; i < 120; i += 20) {
                String sql = "SELECT COUNT(*) as sum FROM Booking WHERE Month(BookingDate) = 9 and Price between ? and ?";
                PreparedStatement pt = connection.prepareStatement(sql);
                pt.setInt(1, i);
                pt.setInt(2, i + 20);
                ResultSet rs = pt.executeQuery();
                if (rs.next()) {
                    list.add(new MonthlyVolume(i, rs.getInt("sum")));
                }
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;

    }

    public List<MonthlyType> getBookingByMonthWithType(List<String> type) {
        List list = new ArrayList<>();
        try {

            for (String t : type) {
                String sql = "SELECT COUNT(*) as sum FROM Booking WHERE Month(BookingDate) = 9 and Type like ?";
                PreparedStatement pt = connection.prepareStatement(sql);
                pt.setString(1, "%" + t + "%");
                ResultSet rs = pt.executeQuery();
                if (rs.next()) {
                    list.add(new MonthlyType(t, rs.getInt("sum")));
                }
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

                Hotel hl = new Hotel(HotelCode, HotelName, Location, NumRooms, City, Phone, StarRating);
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

                Hotel h = new Hotel(HotelCode, HotelName, Location, NumRooms, City, Phone, StarRating);

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

                return r;

            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;

    }

    public Service getServiceByCode(int code) {

        String sql = "select * from Service where ServiceCode = ?";

        try {

            PreparedStatement st = connection.prepareStatement(sql);

            st.setInt(1, code);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Service r = new Service();
                r.setServiceCode(rs.getInt("ServiceCode"));
                r.setHotelCode(rs.getString("HotelCode"));
                r.setServiceName(rs.getString("ServiceName"));
                r.setStarRating(rs.getInt("StarRating"));
                r.setServiceImg(rs.getString("ServiceImg"));
                r.setServiceDes(rs.getString("ServiceDes"));

                return r;

            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;

    }

    public void insert(Room c) {
        String sql = "insert into Room values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, c.getRoomID());
            ps.setString(2, c.getRoomType());
            ps.setInt(3, c.getHotelCode());
            ps.setInt(4, c.getRoomPrice());
            ps.setString(5, c.getRoomImg());
            ps.setString(6, c.getRoomDesc());
            ps.setInt(7, c.getArea());
            ps.setString(8, c.getBed());
            ps.setString(9, c.getDirect());
            ps.setInt(10, c.getAvailable());
            ps.executeUpdate();
        } catch (SQLException e) {

        }

    }

    public void insertService(Service c) {
        String sql = "insert into Service values (?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, c.getServiceCode());
            ps.setString(2, c.getHotelCode());
            ps.setString(3, c.getServiceName());
            ps.setInt(4, 5);
            ps.setString(5, c.getServiceImg());
            ps.setString(6, c.getServiceDes());

            ps.executeUpdate();
        } catch (SQLException e) {

        }

    }

    public void setStatusForEmployee(String s, long id) {
        String sql = "update Employees set Status = ? where EmoloyeeID = ?";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, s);
            ps.setLong(2, id);

            ps.executeUpdate();
        } catch (SQLException e) {

        }

    }

    public void delete(Room c) {
        String sql = "delete from Room where RoomID = ?";

        try {
            PreparedStatement pt = connection.prepareStatement(sql);

            pt.setInt(1, c.getRoomID());

            pt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

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

    public void updateService(String id, String name, String desc) {

        String sql = "update Service\n"
                + "set ServiceName = ?, ServiceDes = ?\n"
                + "where ServiceCode = ?";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, desc);
            ps.setString(3, id);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("cant");
        }

    }

}
