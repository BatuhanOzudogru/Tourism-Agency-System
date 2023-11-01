package com.TourismAgencySystem.Model;

import com.TourismAgencySystem.Helper.DBConnector;
import com.TourismAgencySystem.Helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class EmployeeOp {
    public static ArrayList<Hotel> getList() {
        ArrayList<Hotel> hotelList = new ArrayList<>();
        String query = "SELECT * FROM hotel";
        Hotel obj;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                obj = new Hotel();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("hotel_name"));
                obj.setCity(rs.getString("city"));
                obj.setDistrict(rs.getString("district"));
                obj.setStar(rs.getString("star"));
                obj.setPhoneNumber(rs.getString("hotel_phone"));
                obj.setAddress(rs.getString("address"));
                obj.setEmail(rs.getString("hotel_email"));
                obj.setParking(rs.getString("parking"));
                obj.setWifi(rs.getString("wifi"));
                obj.setGym(rs.getString("gym"));
                obj.setPool(rs.getString("pool"));
                obj.setConcierge(rs.getString("concierge"));
                obj.setSpa(rs.getString("spa"));
                obj.setRoomService(rs.getString("room_service"));
                hotelList.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotelList;
    }
    public static boolean add(String name, String city, String district,String star, String address, String hotel_email, String hotel_phone,
                              String parking, String wifi, String pool, String gym, String concierge, String spa, String room_service) {
        String query = "INSERT INTO hotel(hotel_name,city,district,star,address,hotel_email,hotel_phone,parking,wifi,pool,gym,concierge,spa,room_service) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, name);
            pr.setString(2, city);
            pr.setString(3, district);
            pr.setString(4, star);
            pr.setString(5, address);
            pr.setString(6, hotel_email);
            pr.setString(7, hotel_phone);
            pr.setString(8, parking);
            pr.setString(9, wifi);
            pr.setString(10, pool);
            pr.setString(11, gym);
            pr.setString(12, concierge);
            pr.setString(13, spa);
            pr.setString(14, room_service);
            int response = pr.executeUpdate();
            if (response == -1) {
                Helper.showMessage("error");
            }
            return response != -1;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    public static boolean updateHotelDetails(int id, String name, String city, String district, String star, String address, String hotel_email, String hotel_phone,
                                             String parking, String wifi, String pool, String gym, String concierge, String spa, String room_service) {
        String query = "UPDATE hotel SET hotel_name=?,city=?,district=?,star=?,address=?,hotel_email=?,hotel_phone=?,parking=?,wifi=?,pool=?,gym=?,concierge=?,spa=?,room_service=? WHERE id=?";

        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, city);
            ps.setString(3, district);
            ps.setString(4, star);
            ps.setString(5, address);
            ps.setString(6, hotel_email);
            ps.setString(7, hotel_phone);
            ps.setString(8, parking);
            ps.setString(9, wifi);
            ps.setString(10, pool);
            ps.setString(11, gym);
            ps.setString(12, concierge);
            ps.setString(13, spa);
            ps.setString(14, room_service);
            ps.setInt(15, id);

            return ps.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    public static boolean updateHotelPeriodDetails(int hotel_id, Date season_start, Date season_end, Date offseason_start, Date offseason_end) {
        String query = "UPDATE hotel_period SET season_start=?,season_end=?,offseason_start=?,offseason_end=? WHERE id=?";

        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setDate(1, (java.sql.Date) season_start);
            ps.setDate(2, (java.sql.Date) season_end);
            ps.setDate(3, (java.sql.Date) offseason_start);
            ps.setDate(4, (java.sql.Date) offseason_end);
            ps.setInt(5, hotel_id);

            return ps.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    public static ArrayList<Hotel> getHotelDetailsByHotelId(int hotelId) {
        ArrayList<Hotel> hotelDetailsList = new ArrayList<>();

        Hotel obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM hotel WHERE id = " + hotelId);
            while (rs.next()) {
                int id = rs.getInt("id");
                String hotelName = rs.getString("hotel_name");
                String city = rs.getString("city");
                String district = rs.getString("district");
                String star = rs.getString("star");
                String address = rs.getString("address");
                String hotelEmail = rs.getString("hotel_email");
                String hotelPhone = rs.getString("hotel_phone");
                String parking = rs.getString("parking");
                String wifi = rs.getString("wifi");
                String pool = rs.getString("pool");
                String gym = rs.getString("gym");
                String concierge = rs.getString("concierge");
                String spa = rs.getString("spa");
                String roomService = rs.getString("room_service");

                obj = new Hotel(id, hotelName, city, district, star, address, hotelEmail, hotelPhone, parking, wifi, pool, gym, concierge, spa, roomService);
                hotelDetailsList.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotelDetailsList;
    }
    public static ArrayList<HotelPeriod> getHotelPeriodByHotelId(int hotelId) {
        ArrayList<HotelPeriod> hotelPeriodList = new ArrayList<>();
        HotelPeriod obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM hotel_period WHERE id = " + hotelId);

            while (rs.next()) {
                int id = rs.getInt("id");
                Date seasonStart = rs.getDate("season_start");
                Date seasonEnd = rs.getDate("season_end");
                Date offSeasonStart = rs.getDate("offseason_start");
                Date offSeasonEnd = rs.getDate("offseason_end");

                obj = new HotelPeriod(id, seasonStart, seasonEnd, offSeasonStart, offSeasonEnd);
                hotelPeriodList.add(obj);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotelPeriodList;
    }
}
