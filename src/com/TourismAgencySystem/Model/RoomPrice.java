package com.TourismAgencySystem.Model;

public class RoomPrice {
    private int id;
    private int hotelId;
    private int periodId;
    private int roomTypeId;
    private int accommodationId;
    private int adultPrice;
    private int childPrice;

    public RoomPrice(int id, int hotelId, int periodId, int roomTypeId, int accommodationId, int adultPrice, int childPrice) {
        this.id = id;
        this.hotelId = hotelId;
        this.periodId = periodId;
        this.roomTypeId = roomTypeId;
        this.accommodationId = accommodationId;
        this.adultPrice = adultPrice;
        this.childPrice = childPrice;
    }
    public RoomPrice(){

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

    public int getPeriodId() {
        return periodId;
    }

    public void setPeriodId(int periodId) {
        this.periodId = periodId;
    }

    public int getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(int roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public int getAccommodationId() {
        return accommodationId;
    }

    public void setAccommodationId(int accommodationId) {
        this.accommodationId = accommodationId;
    }

    public int getAdultPrice() {
        return adultPrice;
    }

    public void setAdultPrice(int adultPrice) {
        this.adultPrice = adultPrice;
    }

    public int getChildPrice() {
        return childPrice;
    }

    public void setChildPrice(int childPrice) {
        this.childPrice = childPrice;
    }
}