package com.TourismAgencySystem.Model;

import java.util.Date;

public class HotelPeriod {
    private int id;
    private Date seasonStart;
    private Date seasonEnd;
    private Date offSeasonStart;
    private Date offSeasonEnd;
    private int a;

    public HotelPeriod(int id, Date seasonStart, Date seasonEnd, Date offSeasonStart, Date offSeasonEnd) {
        this.id = id;
        this.seasonStart = seasonStart;
        this.seasonEnd = seasonEnd;
        this.offSeasonStart = offSeasonStart;
        this.offSeasonEnd = offSeasonEnd;
    }
    public HotelPeriod(){

    }
    public HotelPeriod(int id, Date seasonStart, Date seasonEnd,int a) {
        this.id = id;
        this.seasonStart = seasonStart;
        this.seasonEnd = seasonEnd;

    }
    public HotelPeriod(int id, Date offSeasonStart, Date offSeasonEnd) {
        this.id = id;

        this.offSeasonStart = offSeasonStart;
        this.offSeasonEnd = offSeasonEnd;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getSeasonStart() {
        return seasonStart;
    }

    public void setSeasonStart(Date seasonStart) {
        this.seasonStart = seasonStart;
    }

    public Date getSeasonEnd() {
        return seasonEnd;
    }

    public void setSeasonEnd(Date seasonEnd) {
        this.seasonEnd = seasonEnd;
    }

    public Date getOffSeasonStart() {
        return offSeasonStart;
    }

    public void setOffSeasonStart(Date offSeasonStart) {
        this.offSeasonStart = offSeasonStart;
    }

    public Date getOffSeasonEnd() {
        return offSeasonEnd;
    }

    public void setOffSeasonEnd(Date offSeasonEnd) {
        this.offSeasonEnd = offSeasonEnd;
    }
}