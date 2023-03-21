/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author laptop
 */
public class Hotel {
    private int HotelCode;
    private String HotelName;
    private String Location;
    private int	NumRooms;
    private String City;
    private long Phone;
    private float StarRating;
    private String HotelImg;
    private String Map;

    public Hotel() {
    }

    public Hotel(int HotelCode, String HotelName, String Location, int NumRooms, String City, long Phone, float StarRating, String HotelImg, String Map) {
        this.HotelCode = HotelCode;
        this.HotelName = HotelName;
        this.Location = Location;
        this.NumRooms = NumRooms;
        this.City = City;
        this.Phone = Phone;
        this.StarRating = StarRating;
        this.HotelImg = HotelImg;
        this.Map = Map;
    }
    
    public Hotel(int HotelCode, String HotelName, String Location, int NumRooms, String City, long Phone, float StarRating) {
        this.HotelCode = HotelCode;
        this.HotelName = HotelName;
        this.Location = Location;
        this.NumRooms = NumRooms;
        this.City = City;
        this.Phone = Phone;
        this.StarRating = StarRating;
    }

    public Hotel(int HotelCode, String HotelName, String Location, int NumRooms, String City, long Phone, float StarRating, String HotelImg) {
        this.HotelCode = HotelCode;
        this.HotelName = HotelName;
        this.Location = Location;
        this.NumRooms = NumRooms;
        this.City = City;
        this.Phone = Phone;
        this.StarRating = StarRating;
        this.HotelImg = HotelImg;
    }

    public String getMap() {
        return Map;
    }

    public void setMap(String Map) {
        this.Map = Map;
    }
    
    public String getHotelImg() {
        return HotelImg;
    }

    public void setHotelImg(String HotelImg) {
        this.HotelImg = HotelImg;
    }

    public int getHotelCode() {
        return HotelCode;
    }

    public String getHotelName() {
        return HotelName;
    }

    public String getLocation() {
        return Location;
    }

    public int getNumRooms() {
        return NumRooms;
    }

    public String getCity() {
        return City;
    }

    public long getPhone() {
        return Phone;
    }

    public float getStarRating() {
        return StarRating;
    }

    public void setHotelCode(int HotelCode) {
        this.HotelCode = HotelCode;
    }

    public void setHotelName(String HotelName) {
        this.HotelName = HotelName;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public void setNumRooms(int NumRooms) {
        this.NumRooms = NumRooms;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public void setPhone(long Phone) {
        this.Phone = Phone;
    }

    public void setStarRating(float StarRating) {
        this.StarRating = StarRating;
    }

    @Override
    public String toString() {
        return "Hotel{" + "HotelCode=" + HotelCode + ", HotelName=" + HotelName + ", Location=" + Location + ", NumRooms=" + NumRooms + ", City=" + City + ", Phone=" + Phone + ", StarRating=" + StarRating + '}';
    }
    
}
