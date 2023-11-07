package com.TourismAgencySystem.Model;

import java.util.Date;

public class Reservation {
    private int id;
    private int hotelId;
    private String hotelName;
    private String roomType;
    private String periodName;
    private String city;
    private int guestCount;
    private Date checkinDate;
    private Date checkoutDate;
    private int totalPrice;
    private int duration;

    public Reservation(int id, int hotelId,String hotelName,String roomType,String periodName, String city, int guestCount, Date checkinDate, Date checkoutDate,int duration, int totalPrice) {
        this.id = id;
        this.hotelId = hotelId;
        this.hotelName=hotelName;
        this.roomType=roomType;
        this.periodName=periodName;
        this.city = city;
        this.guestCount = guestCount;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.totalPrice = totalPrice;
        this.duration=duration;
    }

    public Reservation() {
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getPeriodName() {
        return periodName;
    }

    public void setPeriodName(String periodName) {
        this.periodName = periodName;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getGuestCount() {
        return guestCount;
    }

    public void setGuestCount(int guestCount) {
        this.guestCount = guestCount;
    }

    public Date getCheckinDate() {
        return checkinDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setCheckinDate(Date checkinDate) {
        this.checkinDate = checkinDate;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
