package com.TourismAgencySystem.Model;

import java.util.Date;

public class RoomSales {
    private int id;
    private int hotelId;
    private String hotelName;
    private String city;
    private String district;
    private String star;
    private String period;
    private Date startDate;
    private Date endDate;
    private String roomType;

    public RoomSales(int id, int hotelId, String hotelName, String city, String district, String star, String period, Date startDate, Date endDate, String roomType) {
        this.id = id;
        this.hotelId = hotelId;
        this.hotelName=hotelName;
        this.city = city;
        this.district = district;
        this.star = star;
        this.period = period;
        this.startDate = startDate;
        this.endDate = endDate;
        this.roomType = roomType;
    }
    public RoomSales(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
}
