package com.TourismAgencySystem.Model;

public class Room {
    private int id;
    private int hotelId;
    private int roomTypeId;
    private int bed;
    private int tv;
    private int minibar;
    private int roomSize;
    private int stock;


    public Room(int id, int hotelId, int roomTypeId, int bed, int tv, int minibar, int roomSize, int stock) {
        this.id = id;
        this.hotelId = hotelId;
        this.roomTypeId = roomTypeId;
        this.bed = bed;
        this.tv = tv;
        this.minibar = minibar;
        this.roomSize = roomSize;
        this.stock = stock;

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

    public int getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(int roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public int getBed() {
        return bed;
    }

    public void setBed(int bed) {
        this.bed = bed;
    }

    public int getTv() {
        return tv;
    }

    public void setTv(int tv) {
        this.tv = tv;
    }

    public int getMinibar() {
        return minibar;
    }

    public void setMinibar(int minibar) {
        this.minibar = minibar;
    }

    public int getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(int roomSize) {
        this.roomSize = roomSize;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


}
