/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author laptop
 */
public class Service {

    private int serviceCode;
    private String hotelCode;
    private String serviceName;
    private float starRating;
    private String serviceImg;
    private String serviceDes;

    public Service() {
    }

    public Service(int serviceCode, String hotelCode, String serviceName, float starRating, String serviceImg, String serviceDes) {
        this.serviceCode = serviceCode;
        this.hotelCode = hotelCode;
        this.serviceName = serviceName;
        this.starRating = starRating;
        this.serviceImg = serviceImg;
        this.serviceDes = serviceDes;
    }

    public int getServiceCode() {
        return serviceCode;
    }

    public String getHotelCode() {
        return hotelCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public float getStarRating() {
        return starRating;
    }

    public String getServiceImg() {
        return serviceImg;
    }

    public String getServiceDes() {
        return serviceDes;
    }

    public void setServiceCode(int serviceCode) {
        this.serviceCode = serviceCode;
    }

    public void setHotelCode(String hotelCode) {
        this.hotelCode = hotelCode;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setStarRating(float starRating) {
        this.starRating = starRating;
    }

    public void setServiceImg(String serviceImg) {
        this.serviceImg = serviceImg;
    }

    public void setServiceDes(String serviceDes) {
        this.serviceDes = serviceDes;
    }

    @Override
    public String toString() {
        return "Service{" + "serviceCode=" + serviceCode + ", hotelCode=" + hotelCode + ", serviceName=" + serviceName + ", starRating=" + starRating + ", serviceImg=" + serviceImg + ", serviceDes=" + serviceDes + '}';
    }
    
    
}
