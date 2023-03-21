/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author laptop
 */
public class MonthlyVolume {
    private int month;
    private int volume;

    public MonthlyVolume() {
    }

    public MonthlyVolume(int month, int volume) {
        this.month = month;
        this.volume = volume;
    }

    public int getMonth() {
        return month;
    }
    
    public String getMonthString() {
        return "Month" + month;
    }

    public int getVolume() {
        return volume;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "MonthlyVolume{" + "month=" + month + ", volume=" + volume + '}';
    }
    
}
