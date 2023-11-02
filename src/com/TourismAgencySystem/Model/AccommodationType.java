package com.TourismAgencySystem.Model;

public class AccommodationType {
    private int id;
    private String accoName;

    public AccommodationType(int id, String accoName) {
        this.id = id;
        this.accoName = accoName;
    }
    public AccommodationType(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccoName() {
        return accoName;
    }

    public void setAccoName(String accoName) {
        this.accoName = accoName;
    }
}
