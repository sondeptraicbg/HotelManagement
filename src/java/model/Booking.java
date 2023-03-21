/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author laptop
 */
public class Booking {
    
    private long bookingID;
    private int hotelCode;
    private long guestID;
    private String bookingDate;
    private String bookingTime;
    private String arrivalDate;
    private int numPeople;
    private String specialReq;
    private Room room;
    private int quantity;
    private String type;
    private String endDate;
    private String guestName;
    

    public Booking() {
    }

    public Booking(long bookingID, int hotelCode, long guestID, String bookingDate, String bookingTime, String arrivalDate, int numPeople, String specialReq, Room room, int quantity) {
        this.bookingID = bookingID;
        this.hotelCode = hotelCode;
        this.guestID = guestID;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.arrivalDate = arrivalDate;
        this.numPeople = numPeople;
        this.specialReq = specialReq;
        this.room = room;
        this.quantity = quantity;
    }

    public Booking(long bookingID, int hotelCode, String guestName, String bookingDate, String bookingTime, String arrivalDate, int numPeople, String specialReq, Room room, int quantity, String type, String endDate) {
        this.bookingID = bookingID;
        this.hotelCode = hotelCode;
        this.guestName = guestName;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.arrivalDate = arrivalDate;
        this.numPeople = numPeople;
        this.specialReq = specialReq;
        this.room = room;
        this.quantity = quantity;
        this.type = type;
        this.endDate = endDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getType() {
        return type;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getBookingID() {
        return bookingID;
    }

    public int getHotelCode() {
        return hotelCode;
    }

    public long getGuestID() {
        return guestID;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public int getNumPeople() {
        return numPeople;
    }

    public String getSpecialReq() {
        return specialReq;
    }

    public void setBookingID(long bookingID) {
        this.bookingID = bookingID;
    }

    public void setHotelCode(int hotelCode) {
        this.hotelCode = hotelCode;
    }

    public void setGuestID(long guestID) {
        this.guestID = guestID;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setNumPeople(int numPeople) {
        this.numPeople = numPeople;
    }

    public void setSpecialReq(String specialReq) {
        this.specialReq = specialReq;
    }

    @Override
    public String toString() {
        return "Booking{" + "bookingID=" + bookingID + ", hotelCode=" + hotelCode + ", guestID=" + guestID + ", bookingDate=" + bookingDate + ", bookingTime=" + bookingTime + ", arrivalDate=" + arrivalDate + ", numPeople=" + numPeople + ", specialReq=" + specialReq + ", room=" + room + ", quantity=" + quantity + '}';
    }



}
