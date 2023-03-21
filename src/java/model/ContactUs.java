/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author laptop
 */
public class ContactUs {
    private int id;
    private String name;
    private String gmail;
    private String content;
    private boolean isReplied;
    private String feedback;

    public ContactUs() {
    }

    public ContactUs(int id, String name, String gmail, String content, boolean isReplied, String feedback) {
        this.id = id;
        this.name = name;
        this.gmail = gmail;
        this.content = content;
        this.isReplied = isReplied;
        this.feedback = feedback;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGmail() {
        return gmail;
    }

    public String getContent() {
        return content;
    }

    public boolean isIsReplied() {
        return isReplied;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setIsReplied(boolean isReplied) {
        this.isReplied = isReplied;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        return "ContactUs{" + "id=" + id + ", name=" + name + ", gmail=" + gmail + ", content=" + content + ", isReplied=" + isReplied + ", feedback=" + feedback + '}';
    }
    
}
