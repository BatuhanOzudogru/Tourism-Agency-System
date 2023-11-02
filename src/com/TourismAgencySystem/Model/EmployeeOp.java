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
    public static ArrayList<RoomPrice> getRoomPriceListByHotelId(int hotelId) {
        ArrayList<RoomPrice> roomPriceList = new ArrayList<>();
        String query = "SELECT * FROM room_price WHERE hotel_id = " + hotelId;
        RoomPrice obj;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                obj = new RoomPrice();
                obj.setId(rs.getInt("id"));
                obj.setHotelId(rs.getInt("hotel_id"));
                obj.setPeriodId(rs.getInt("period_id"));
                obj.setRoomTypeId(rs.getInt("room_type"));
                obj.setAccommodationId(rs.getInt("accommodation_id"));
                obj.setAdultPrice(rs.getInt("adult_price"));
                obj.setChildPrice(rs.getInt("child_price"));
                roomPriceList.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roomPriceList;
    }
    public static boolean addHotelDetails(String name, String city, String district, String star, String address, String hotel_email, String hotel_phone,
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
    public static boolean addRoomDetails(int hotel_id, int room_type_id, int stock, int bed, int room_size, int tv, int minibar) {
        String query = "INSERT INTO room (hotel_id, room_type_id,stock,bed,room_size,tv,minibar) VALUES (?,?,?,?,?,?,?)";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, hotel_id);
            pr.setInt(2, room_type_id);
            pr.setInt(3, stock);
            pr.setInt(4, bed);
            pr.setInt(5, room_size);
            pr.setInt(6, tv);
            pr.setInt(7, minibar);

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
    public static RoomType getFetchRoomType(String roomType) {
        RoomType obj = null;
        String query = "SELECT * FROM room_type WHERE room_name = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, roomType);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new RoomType();
                obj.setId(rs.getInt("id"));
                obj.setRoomName(rs.getString("room_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }
    public static PeriodType getFetchPeriodIdByName (String periodName) {
        PeriodType obj = null;
        String query = "SELECT * FROM period_type WHERE period_name = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, periodName);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new PeriodType();
                obj.setId(rs.getInt("id"));
                obj.setPeriodName(rs.getString("period_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }
    public static AccommodationType getFetchAccoIdByName (String accoName) {
        AccommodationType obj = null;
        String query = "SELECT * FROM accommodation_type WHERE accommodation_name = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, accoName);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new AccommodationType();
                obj.setId(rs.getInt("id"));
                obj.setAccoName(rs.getString("accommodation_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }
    public static PeriodType getFetchPeriodNameById (int periodId) {
        PeriodType obj = null;
        String query = "SELECT * FROM period_type WHERE id = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, periodId);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new PeriodType();
                obj.setId(rs.getInt("id"));
                obj.setPeriodName(rs.getString("period_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }
    public static RoomType getFetchRoomNameById (int roomId) {
        RoomType obj = null;
        String query = "SELECT * FROM room_type WHERE id = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, roomId);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new RoomType();
                obj.setId(rs.getInt("id"));
                obj.setRoomName(rs.getString("room_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }
    public static AccommodationType getFetchAccoNameById (int accoId) {
        AccommodationType obj = null;
        String query = "SELECT * FROM accommodation_type WHERE id = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, accoId);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new AccommodationType();
                obj.setId(rs.getInt("id"));
                obj.setAccoName(rs.getString("accommodation_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }
    public static boolean addHotelPeriodDetails(Date season_start, Date season_end, Date offseason_start, Date offseason_end) {
        String query = "INSERT INTO hotel_period (season_start,season_end,offseason_start,offseason_end) VALUES (?,?,?,?)";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setDate(1, (java.sql.Date) season_start);
            pr.setDate(2, (java.sql.Date) season_end);
            pr.setDate(3, (java.sql.Date) offseason_start);
            pr.setDate(4, (java.sql.Date) offseason_end);

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
    public static boolean addPriceDetails(int hotel_id, int period_id, int room_type, int accommodation_id, int adult_price, int child_price){
        String query = "INSERT INTO room_price (hotel_id, period_id, room_type, accommodation_id, adult_price, child_price) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, hotel_id);
            pr.setInt(2, period_id);
            pr.setInt(3, room_type);
            pr.setInt(4, accommodation_id);
            pr.setInt(5, adult_price);
            pr.setInt(6, child_price);
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
    public static boolean updateRoomDetails(int hotel_id, int room_type_id, int stock, int bed, int size, int tv, int minibar) {
        String query = "UPDATE room SET stock=?,bed=?,room_size=?,tv=?,minibar=? WHERE hotel_id=? AND room_type_id=?";

        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setInt(1, stock);
            ps.setInt(2, bed);
            ps.setInt(3, size);
            ps.setInt(4, tv);
            ps.setInt(5, minibar);
            ps.setInt(6, hotel_id);
            ps.setInt(7, room_type_id);

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

    public static ArrayList<Room> getRoomDetailsByHotelId(int hotelId, int roomTypeId) {
        ArrayList<Room> roomDetailsList = new ArrayList<>();

        Room obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM room WHERE hotel_id = " + hotelId + " AND room_type_id = " + roomTypeId);
            while (rs.next()) {
                int id = rs.getInt("id");
                int hotel_id = rs.getInt("hotel_id");
                int room_type_id = rs.getInt("room_type_id");
                int bed = rs.getInt("bed");
                int tv = rs.getInt("tv");
                int minibar = rs.getInt("minibar");
                int room_size = rs.getInt("room_size");
                int stock = rs.getInt("stock");

                obj = new Room(id, hotel_id, room_type_id, bed, tv, minibar, room_size, stock);
                roomDetailsList.add(obj);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roomDetailsList;
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
    public static boolean deleteHotelDetails(int id) {
        String query = "DELETE FROM hotel WHERE id = ?";
        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setInt(1, id);

            return ps.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    public static boolean deleteHotelPeriodDetails(int id) {
        String query = "DELETE FROM hotel_period WHERE id = ?";
        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setInt(1, id);

            return ps.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    public static String searchHotelQuery(String nameCityDistrict, String star) {
        String query = "SELECT * FROM hotel WHERE (hotel_name LIKE '%" + nameCityDistrict + "%' OR city = '" + nameCityDistrict + "' OR district = '" + nameCityDistrict + "')";

        if (!star.isEmpty()) {
            query += " AND star='{{star}}'";
            query = query.replace("{{star}}", star);
        }
        return query;
    }

    public static ArrayList<Hotel> searchHotelList(String query) {
        ArrayList<Hotel> hotelList = new ArrayList<>();

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
                obj.setAddress(rs.getString("address"));
                obj.setEmail(rs.getString("hotel_email"));
                obj.setPhoneNumber(rs.getString("hotel_phone"));
                obj.setParking(rs.getString("parking"));
                obj.setWifi(rs.getString("wifi"));
                obj.setPool(rs.getString("pool"));
                obj.setGym(rs.getString("gym"));
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
}
