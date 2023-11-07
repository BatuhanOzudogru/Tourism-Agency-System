package com.TourismAgencySystem.Model;

public class Room {
    private int id;
    private int hotelId;
    private int roomTypeId;
    private int bed;
    private int tv;
    private int minibar;
    private int roomSize;
    private int seasonStock;

    private int offSeasonStock;


    public Room(int id, int hotelId, int roomTypeId, int bed, int tv, int minibar, int roomSize, int seasonStock, int offSeasonStock) {
        this.id = id;
        this.hotelId = hotelId;
        this.roomTypeId = roomTypeId;
        this.bed = bed;
        this.tv = tv;
        this.minibar = minibar;
        this.roomSize = roomSize;
        this.seasonStock = seasonStock;
        this.offSeasonStock=offSeasonStock;

    }
    public Room(){

    }

    public int getOffSeasonStock() {
        return offSeasonStock;
    }

    public void setOffSeasonStock(int offSeasonStock) {
        this.offSeasonStock = offSeasonStock;
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

    public int getSeasonStock() {
        return seasonStock;
    }

    public void setSeasonStock(int seasonStock) {
        this.seasonStock = seasonStock;
    }


}
