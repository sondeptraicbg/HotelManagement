/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author laptop
 */
public class Bill {
    private long invoiceID;
    private long bookingID;
    private long guestID;
    private int roomCharge;
    private int roomServiceCharge;
    private String paymentDate;
    private String paymentMode;
    private String expireDate;

    public Bill() {
    }

    public Bill(long invoiceID, long bookingID, long guestID, int roomCharge, int roomServiceCharge, String paymentDate, String paymentMode, String expireDate) {
        this.invoiceID = invoiceID;
        this.bookingID = bookingID;
        this.guestID = guestID;
        this.roomCharge = roomCharge;
        this.roomServiceCharge = roomServiceCharge;
        this.paymentDate = paymentDate;
        this.paymentMode = paymentMode;
        this.expireDate = expireDate;
    }

    public long getInvoiceID() {
        return invoiceID;
    }

    public long getBookingID() {
        return bookingID;
    }

    public long getGuestID() {
        return guestID;
    }

    public int getRoomCharge() {
        return roomCharge;
    }

    public int getRoomServiceCharge() {
        return roomServiceCharge;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setInvoiceID(long invoiceID) {
        this.invoiceID = invoiceID;
    }

    public void setBookingID(long bookingID) {
        this.bookingID = bookingID;
    }

    public void setGuestID(long guestID) {
        this.guestID = guestID;
    }

    public void setRoomCharge(int roomCharge) {
        this.roomCharge = roomCharge;
    }

    public void setRoomServiceCharge(int roomServiceCharge) {
        this.roomServiceCharge = roomServiceCharge;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public String toString() {
        return "Bill{" + "invoiceID=" + invoiceID + ", bookingID=" + bookingID + ", guestID=" + guestID + ", roomCharge=" + roomCharge + ", roomServiceCharge=" + roomServiceCharge + ", paymentDate=" + paymentDate + ", paymentMode=" + paymentMode + ", expireDate=" + expireDate + '}';
    }
    
}
