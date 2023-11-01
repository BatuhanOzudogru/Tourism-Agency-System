package com.TourismAgencySystem.Model;

public class Hotel {
    private int id;
    private String name;
    private String city;
    private String district;
    private String star;
    private String address;
    private String email;
    private String phoneNumber;
    private String parking; // boolean
    private String wifi;
    private String pool;
    private String gym;
    private String concierge;
    private String spa;
    private String roomService;

    public Hotel(int id, String name, String city, String district, String star,
                 String address, String email, String phoneNumber, String parking, String wifi,
                 String pool, String gym, String concierge, String spa, String roomService) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.district = district;
        this.star = star;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.parking = parking;
        this.wifi = wifi;
        this.pool = pool;
        this.gym = gym;
        this.concierge = concierge;
        this.spa = spa;
        this.roomService = roomService;
    }
    public Hotel(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public String getPool() {
        return pool;
    }

    public void setPool(String pool) {
        this.pool = pool;
    }

    public String getGym() {
        return gym;
    }

    public void setGym(String gym) {
        this.gym = gym;
    }

    public String getConcierge() {
        return concierge;
    }

    public void setConcierge(String concierge) {
        this.concierge = concierge;
    }

    public String getSpa() {
        return spa;
    }

    public void setSpa(String spa) {
        this.spa = spa;
    }

    public String getRoomService() {
        return roomService;
    }

    public void setRoomService(String roomService) {
        this.roomService = roomService;
    }

}
