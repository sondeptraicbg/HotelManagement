/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author laptop
 */
public class Room {
    private int RoomID;
    private String RoomType;
    private int	HotelCode;
    private int	RoomPrice;
    private String RoomImg;
    private String RoomDesc;
    private Hotel hotel;
    private int Area;
    private String Bed;
    private String Direct;
    private int Available;

    public Room() {
    }

    public Room(int RoomID, String RoomType, int HotelCode, int RoomPrice, String RoomImg, String RoomDesc, Hotel hotel, int Area, String Bed, String Direct, int Available) {
        this.RoomID = RoomID;
        this.RoomType = RoomType;
        this.HotelCode = HotelCode;
        this.RoomPrice = RoomPrice;
        this.RoomImg = RoomImg;
        this.RoomDesc = RoomDesc;
        this.hotel = hotel;
        this.Area = Area;
        this.Bed = Bed;
        this.Direct = Direct;
        this.Available = Available;
    }

    public int getAvailable() {
        return Available;
    }

    public void setAvailable(int Available) {
        this.Available = Available;
    }

    public int getArea() {
        return Area;
    }

    public String getBed() {
        return Bed;
    }

    public String getDirect() {
        return Direct;
    }

    public void setArea(int Area) {
        this.Area = Area;
    }

    public void setBed(String Bed) {
        this.Bed = Bed;
    }

    public void setDirect(String Direct) {
        this.Direct = Direct;
    }

    public int getRoomID() {
        return RoomID;
    }

    public String getRoomType() {
        return RoomType;
    }

    public int getHotelCode() {
        return HotelCode;
    }

    public int getRoomPrice() {
        return RoomPrice;
    }

    public String getRoomImg() {
        return RoomImg;
    }

    public String getRoomDesc() {
        return RoomDesc;
    }

    public void setRoomID(int RoomID) {
        this.RoomID = RoomID;
    }

    public void setRoomType(String RoomType) {
        this.RoomType = RoomType;
    }

    public void setHotelCode(int HotelCode) {
        this.HotelCode = HotelCode;
    }

    public void setRoomPrice(int RoomPrice) {
        this.RoomPrice = RoomPrice;
    }

    public void setRoomImg(String RoomImg) {
        this.RoomImg = RoomImg;
    }

    public void setRoomDesc(String RoomDesc) {
        this.RoomDesc = RoomDesc;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "Room{" + "RoomID=" + RoomID + ", RoomType=" + RoomType + ", HotelCode=" + HotelCode + ", RoomPrice=" + RoomPrice + ", RoomImg=" + RoomImg + ", RoomDesc=" + RoomDesc + ", hotel=" + hotel + ", Area=" + Area + ", Bed=" + Bed + ", Direct=" + Direct + '}';
    }

    
}
