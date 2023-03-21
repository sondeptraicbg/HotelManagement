/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author laptop
 */
public class Cart {

    private List<Booking> booking;

    public List<Booking> getBooking() {
        return booking;
    }

    public void setBooking(List<Booking> booking) {
        this.booking = booking;
    }

    public Cart(List<Booking> booking) {
        this.booking = booking;
    }

    public Cart() {
        booking = new ArrayList();
    }

    private Booking getBookingByID(int id) {
        for (Booking b : booking) {
            if (b.getRoom().getRoomID() == id) {
                return b;
            }
        }
        return null;
    }
    
    public int getQuantityById(int id){
        return getBookingByID(id).getQuantity();
    }

    public void addBooking(Booking b) {
        if (getBookingByID(b.getRoom().getRoomID()) != null) {
            Booking b1 = getBookingByID(b.getRoom().getRoomID());
            b1.setQuantity(b.getQuantity() + b1.getQuantity());
        } else {
            booking.add(b);
        }
    }

    public void removeBooking(int id) {
        if (getBookingByID(id) != null) {
            booking.remove(getBookingByID(id));
        }
    }

    public int getTotalMoney() {
        int t = 0;
        for (Booking b : booking) {
            t += b.getRoom().getRoomPrice() * b.getQuantity();
        }
        return t;
    }

    private Room getRoomByID(int id, List<Room> list) {
        for (Room r : list) {
            if (r.getRoomID() == id) {
                return r;
            }
        }
        return null;
    }

    public Cart(String txt, List<Room> list) {
        booking = new ArrayList<>();

        try {
            if (txt.length() != 0) {
                String[] s = txt.split("/");
                for (String i : s) {
                    String[] n = i.split(":");
                    int id = Integer.parseInt(n[0]);
                    int quantity = Integer.parseInt(n[1]);
                    Room r = getRoomByID(id, list);
                    Booking b = new Booking();
                    b.setRoom(r);
                    b.setQuantity(quantity);
                    addBooking(b);
                }
            }
        }catch(NumberFormatException e){
            System.out.println(e);
        }

    }

}
