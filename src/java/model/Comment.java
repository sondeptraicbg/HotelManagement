/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author laptop
 */
public class Comment {
    private User user;
    private Hotel hotel;
    private String comment;

    public Comment() {
    }

    public Comment(User user, Hotel hotel, String comment) {
        this.user = user;
        this.hotel = hotel;
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public String getComment() {
        return comment;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Comment{" + "user=" + user + ", hotel=" + hotel + ", comment=" + comment + '}';
    }
    
}
