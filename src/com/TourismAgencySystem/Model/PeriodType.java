package com.TourismAgencySystem.Model;

public class PeriodType {
    private int id;
    private String periodName;

    public PeriodType(int id, String periodName) {
        this.id = id;
        this.periodName = periodName;
    }
    public PeriodType(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPeriodName() {
        return periodName;
    }

    public void setPeriodName(String periodName) {
        this.periodName = periodName;
    }
}
