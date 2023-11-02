package com.TourismAgencySystem.Model;

public class RoomType {
    private int id;
    private String roomName;

    public RoomType(int id, String roomName) {
        this.id = id;
        this.roomName = roomName;
    }
    public RoomType(){

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}
