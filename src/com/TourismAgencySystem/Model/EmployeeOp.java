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


    public static ArrayList<HotelPeriod> getHotelPeriodList() {
        ArrayList<HotelPeriod> hotelPeriodList = new ArrayList<>();
        String query = "SELECT * FROM hotel_period";
        HotelPeriod obj;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                obj = new HotelPeriod();
                obj.setId(rs.getInt("id"));
                obj.setSeasonStart(rs.getDate("season_start"));
                obj.setSeasonEnd(rs.getDate("season_end"));
                obj.setOffSeasonStart(rs.getDate("offseason_start"));
                obj.setOffSeasonEnd(rs.getDate("offseason_end"));

                hotelPeriodList.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotelPeriodList;
    }

    public static ArrayList<RoomSales> getRoomSalesList() {
        ArrayList<RoomSales> hotelRoomSalesList = new ArrayList<>();
        String query = "SELECT * FROM room_sales";
        RoomSales obj;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                obj = new RoomSales();
                obj.setId(rs.getInt("id"));
                obj.setHotelId(rs.getInt("hotel_id"));
                obj.setHotelName(rs.getString("hotel_name"));
                obj.setCity(rs.getString("city"));
                obj.setDistrict(rs.getString("district"));
                obj.setStar(rs.getString("star"));
                obj.setPeriod(rs.getString("period"));
                obj.setStartDate(rs.getDate("start_date"));
                obj.setEndDate(rs.getDate("end_date"));
                obj.setRoomType(rs.getString("room_type"));
                obj.setStock(rs.getInt("stock"));

                hotelRoomSalesList.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotelRoomSalesList;
    }
    public static ArrayList<Reservation> getResList() {
        ArrayList<Reservation> resList = new ArrayList<>();
        String query = "SELECT * FROM reservation";
        Reservation obj;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                obj = new Reservation();
                obj.setId(rs.getInt("id"));
                obj.setHotelId(rs.getInt("hotel_id"));
                obj.setHotelName(rs.getString("hotel_name"));
                obj.setCity(rs.getString("city"));
                obj.setGuestCount(rs.getInt("guest_count"));
                obj.setCheckinDate(rs.getDate("checkin_date"));
                obj.setCheckoutDate(rs.getDate("checkout_date"));
                obj.setDuration(rs.getInt("duration"));
                obj.setTotalPrice(rs.getInt("price"));
                resList.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resList;
    }
    public static ArrayList<Guest> getGuestList() {
        ArrayList<Guest> guestList = new ArrayList<>();
        String query = "SELECT * FROM guest";
        Guest obj;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                obj = new Guest();
                obj.setId(rs.getInt("id"));
                obj.setReservationId(rs.getInt("reservation_id"));
                obj.setFullName(rs.getString("guest_fullname"));
                obj.setNationalId(rs.getString("national_id"));
                obj.setPhone(rs.getString("guest_phone"));
                obj.setEmail(rs.getString("guest_email"));

                guestList.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return guestList;
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

    public static boolean addRoomDetails(int hotel_id, int room_type_id, int seasonStock,int offSeasonStock, int bed, int room_size, int tv, int minibar) {
        String query = "INSERT INTO room (hotel_id, room_type_id,season_stock,offseason_stock,bed,room_size,tv,minibar) VALUES (?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, hotel_id);
            pr.setInt(2, room_type_id);
            pr.setInt(3, seasonStock);
            pr.setInt(4, offSeasonStock);
            pr.setInt(5, bed);
            pr.setInt(6, room_size);
            pr.setInt(7, tv);
            pr.setInt(8, minibar);

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

    public static PeriodType getFetchPeriodIdByName(String periodName) {
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

    public static AccommodationType getFetchAccoIdByName(String accoName) {
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

    public static PeriodType getFetchPeriodNameById(int periodId) {
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

    public static RoomType getFetchRoomNameById(int roomId) {
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

    public static RoomType getFetchRoomIdByName(String roomName) {
        RoomType obj = null;
        String query = "SELECT * FROM room_type WHERE room_name = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, roomName);
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

    public static ArrayList<RoomPrice> getAccoIdByHotel(int hotelId, int roomTypeId, int periodId) {
        ArrayList<RoomPrice> accoIdList = new ArrayList<>();

        RoomPrice obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM room_price WHERE hotel_id = " + hotelId + " AND room_type = " + roomTypeId + " AND period_id = " + periodId);
            while (rs.next()) {
                int id = rs.getInt("id");
                int hotel_id = rs.getInt("hotel_id");
                int room_type_id = rs.getInt("room_type");
                int accoId = rs.getInt("accommodation_id");
                int adultPrice = rs.getInt("adult_price");
                int childPrice = rs.getInt("child_price");


                obj = new RoomPrice(id, hotel_id, periodId, room_type_id, accoId, adultPrice, childPrice);
                accoIdList.add(obj);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accoIdList;
    }

    public static RoomPrice getAccoPrice(int hotelId, int roomTypeId, int periodId, int accomId) {
        RoomPrice obj = null;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM room_price WHERE hotel_id = " + hotelId + " AND room_type = " + roomTypeId + " AND period_id = " + periodId + " AND accommodation_id = " + accomId);
            while (rs.next()) {
                int id = rs.getInt("id");
                int hotel_id = rs.getInt("hotel_id");
                int room_type_id = rs.getInt("room_type");
                int accoId = rs.getInt("accommodation_id");
                int adultPrice = rs.getInt("adult_price");
                int childPrice = rs.getInt("child_price");


                obj = new RoomPrice(id, hotel_id, periodId, room_type_id, accoId, adultPrice, childPrice);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }


    public static AccommodationType getFetchAccoNameById(int accoId) {
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

    public static boolean addPriceDetails(int hotel_id, int period_id, int room_type, int accommodation_id, int adult_price, int child_price) {
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

    public static boolean addRoomSalesDetails(int hotel_id, String hotel_name, String city, String district, String star, String period, Date start_date, Date end_date, String room_type, int stock) {
        String query = "INSERT INTO room_sales (hotel_id,hotel_name,city,district,star,period,start_date,end_date,room_type,stock) VALUES (?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, hotel_id);
            pr.setString(2, hotel_name);
            pr.setString(3, city);
            pr.setString(4, district);
            pr.setString(5, star);
            pr.setString(6, period);
            pr.setDate(7, (java.sql.Date) start_date);
            pr.setDate(8, (java.sql.Date) end_date);
            pr.setString(9, room_type);
            pr.setInt(10, stock);


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

    public static boolean addReservationDetails(int hotelId,String hotelName, String city, int guestCount, Date checkinDate, Date checkoutDate, int duration, int totalPrice) {
        String query = "INSERT INTO reservation (hotel_id,hotel_name,city,guest_count,checkin_date,checkout_date,duration,price) VALUES (?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, hotelId);
            pr.setString(2, hotelName);
            pr.setString(3, city);
            pr.setInt(4, guestCount);
            pr.setDate(5, (java.sql.Date) checkinDate);
            pr.setDate(6, (java.sql.Date) checkoutDate);
            pr.setInt(7, duration);
            pr.setInt(8, totalPrice);


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

    public static boolean addGuestDetails(int reservationId, String fullName, String nationalityId, String phone, String email) {
        String query = "INSERT INTO guest (reservation_id, guest_fullname, national_id, guest_phone, guest_email) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, reservationId);
            pr.setString(2, fullName);
            pr.setString(3, nationalityId);
            pr.setString(4, phone);
            pr.setString(5, email);


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

    public static boolean updateRoomDetails(int hotel_id, int room_type_id, int seasonStock,int offSeasonStock, int bed, int size, int tv, int minibar) {
        String query = "UPDATE room SET season_stock=?,offseason_stock=?,bed=?,room_size=?,tv=?,minibar=? WHERE hotel_id=? AND room_type_id=?";

        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setInt(1, seasonStock);
            ps.setInt(2, offSeasonStock);
            ps.setInt(3, bed);
            ps.setInt(4, size);
            ps.setInt(5, tv);
            ps.setInt(6, minibar);
            ps.setInt(7, hotel_id);
            ps.setInt(8, room_type_id);

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

    public static boolean updateRoomPrice(int id, int hotel_id, int period_id, int room_type_id, int acco_id, int adult_price, int child_price) {
        String query = "UPDATE room_price SET hotel_id=?,period_id=?,room_type=?,accommodation_id=?,adult_price=?,child_price=? WHERE id=?";

        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setInt(1, hotel_id);
            ps.setInt(2, period_id);
            ps.setInt(3, room_type_id);
            ps.setInt(4, acco_id);
            ps.setInt(5, adult_price);
            ps.setInt(6, child_price);
            ps.setInt(7, id);

            return ps.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean updateStock(int id, int stock) {
        String query = "UPDATE room_sales SET stock=? WHERE id=?";

        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setInt(1, stock);
            ps.setInt(2, id);

            return ps.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean updateRoomSales(int id, int hotel_id, String hotel_name, String city, String district, String star, String period, Date start_date, Date end_date, String room_type, int stock) {
        String query = "UPDATE room_sales SET hotel_id=?,hotel_name=?,city=?,district=?,star=?,period=?,start_date=?,end_date=?,room_type=?, stock=? WHERE id=?";

        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setInt(1, hotel_id);
            ps.setString(2, hotel_name);
            ps.setString(3, city);
            ps.setString(4, district);
            ps.setString(5, star);
            ps.setString(6, period);
            ps.setDate(7, (java.sql.Date) start_date);
            ps.setDate(8, (java.sql.Date) end_date);
            ps.setString(9, room_type);
            ps.setInt(10, stock);
            ps.setInt(11, id);

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
    public static Hotel getHotelNameByHotelId(int hotelId) {

        Hotel obj=null;

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

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
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
                int seasonStock = rs.getInt("season_stock");
                int offSeasonStock = rs.getInt("offseason_stock");

                obj = new Room(id, hotel_id, room_type_id, bed, tv, minibar, room_size, seasonStock,offSeasonStock);
                roomDetailsList.add(obj);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roomDetailsList;
    }
    public static RoomSales getRoomSalesDetailsByHotelId(int hotelId, String roomTypeName) {

        RoomSales obj=null;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM room_sales WHERE hotel_id = " + hotelId + " AND room_type = " + roomTypeName);
            while (rs.next()) {
                int id = rs.getInt("id");
                int hotel_id = rs.getInt("hotel_id");
                String hotelName = rs.getString("hotel_name");
                String hotelCity = rs.getString("city");
                String hotelDistrict = rs.getString("district");
                String hotelStar = rs.getString("star");
                String hotelPeriod = rs.getString("period");
                String roomType = rs.getString("room_type");
                int stock = rs.getInt("stock");
                Date startDate= rs.getDate("start_date");
                Date endDate = rs.getDate("end_date");


                obj = new RoomSales(id, hotel_id,hotelName,hotelCity,hotelDistrict,hotelStar,hotelPeriod,startDate,endDate,roomType,stock);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static Room getGuestRoomDetailsByHotelId(int hotelId, int roomTypeId) {


        Room obj = null;

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
                int seasonStock = rs.getInt("season_stock");
                int offSeasonStock = rs.getInt("offseason_stock");

                obj = new Room(id, hotel_id, room_type_id, bed, tv, minibar, room_size, seasonStock,offSeasonStock);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
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

    public static HotelPeriod getHotelPeriodDateByHotelId(int hotelId) {
        HotelPeriod obj = null;

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


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }

    //    public static ArrayList<HotelPeriod> getSeasonDateHotelId(int hotelId) {
//        ArrayList<HotelPeriod> hotelPeriodList = new ArrayList<>();
//        HotelPeriod obj;
//
//        try {
//            Statement st = DBConnector.getInstance().createStatement();
//            ResultSet rs = st.executeQuery("SELECT * FROM hotel_period WHERE id = " + hotelId);
//
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                Date seasonStart = rs.getDate("season_start");
//                Date seasonEnd = rs.getDate("season_end");
//                Date offSeasonStart = rs.getDate("offseason_start");
//                Date offSeasonEnd = rs.getDate("offseason_end");
//
//                obj = new HotelPeriod(id, seasonStart, seasonEnd, offSeasonStart, offSeasonEnd);
//                hotelPeriodList.add(obj);
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return hotelPeriodList;
//    }
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

    public static boolean deleteRoomPriceDetails(int id) {
        String query = "DELETE FROM room_price WHERE id = ?";
        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setInt(1, id);

            return ps.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean deleteResDetails(int id) {
        String query = "DELETE FROM reservation WHERE id = ?";
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

    public static String searchRoomSalesQuery(String input, String star, Date checkIn, Date checkOut) {
        String query = "SELECT * FROM room_sales";

        if (!input.isEmpty() || !star.isEmpty() || checkIn != null || checkOut != null){
            query += " WHERE 1=1";

            if (!input.isEmpty()) {
                query += " AND (hotel_name LIKE '%" + input + "%' OR city = '" + input + "')";
            }

            if (!star.isEmpty()) {
                query += " AND star = '" + star + "'";
            }

            if (checkIn != null) {
                query += " AND start_date = '" + checkIn + "'";
            }

            if (checkOut != null) {
                query += " AND end_date = '" + checkOut + "'";
            }
        }
        return query;
    }

    public static ArrayList<RoomSales> searchRoomSalesList(String query) {
        ArrayList<RoomSales> roomSalesList = new ArrayList<>();

        RoomSales obj;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                obj = new RoomSales();
                obj.setId(rs.getInt("id"));
                obj.setHotelId(rs.getInt("hotel_id"));
                obj.setHotelName(rs.getString("hotel_name"));
                obj.setCity(rs.getString("city"));
                obj.setDistrict(rs.getString("district"));
                obj.setStar(rs.getString("star"));
                obj.setPeriod(rs.getString("period"));
                obj.setStartDate(rs.getDate("start_date"));
                obj.setEndDate(rs.getDate("end_date"));
                obj.setRoomType(rs.getString("room_type"));
                obj.setStock(rs.getInt("stock"));

                roomSalesList.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roomSalesList;
    }
    public static String searchResQuery(String input, Date checkIn, Date checkOut, int minPrice, int maxPrice) {
        String query = "SELECT * FROM reservation ";


        if (!input.isEmpty() || checkIn != null || checkOut != null || minPrice > 0 || maxPrice > 0){
            query += "WHERE 1=1";

            if (!input.isEmpty()) {
                query += " AND (hotel_name LIKE '%" + input + "%' OR city = '" + input + "')";
            }

            if (checkIn != null) {
                query += " AND checkin_date = '" + checkIn + "'";
            }

            if (checkOut != null) {
                query += " AND checkout_date = '" + checkOut + "'";
            }

            if (minPrice >= 0) {
                query += " AND price >= " + minPrice;
            }

            if (maxPrice >= 0) {
                query += " AND price <= " + maxPrice;
            }

        }




        return query;
    }

    public static ArrayList<Reservation> searchResList(String query) {
        ArrayList<Reservation> resList = new ArrayList<>();

        Reservation obj;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                obj = new Reservation();
                obj.setId(rs.getInt("id"));
                obj.setHotelId(rs.getInt("hotel_id"));
                obj.setHotelName(rs.getString("hotel_name"));
                obj.setCity(rs.getString("city"));
                obj.setGuestCount(rs.getInt("guest_count"));
                obj.setCheckinDate(rs.getDate("checkin_date"));
                obj.setCheckoutDate(rs.getDate("checkout_date"));
                obj.setDuration(rs.getInt("duration"));
                obj.setTotalPrice(rs.getInt("price"));

                resList.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resList;
    }

    public static String searchGuestQuery(int reservationId, String fullName, String nationalId) {
        String query = "SELECT * FROM guest";


        if (reservationId > 0 || !fullName.isEmpty() || !nationalId.isEmpty()){
            query += " WHERE 1 = 1";

            if (reservationId > 0) {
                query += " AND reservation_id = '" + reservationId + "'";
            }

            if (!fullName.isEmpty()) {
                query += " AND guest_fullname = '" + fullName + "'";
            }

            if (!nationalId.isEmpty()) {
                query += " AND national_id = '" + nationalId + "'";
            }

        }

        return query;
    }

    public static ArrayList<Guest> searchGuestList(String query) {
        ArrayList<Guest> guestList = new ArrayList<>();

        Guest obj;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                obj = new Guest();
                obj.setId(rs.getInt("id"));
                obj.setReservationId(rs.getInt("reservation_id"));
                obj.setFullName(rs.getString("guest_fullname"));
                obj.setNationalId(rs.getString("national_id"));
                obj.setPhone(rs.getString("guest_phone"));
                obj.setEmail(rs.getString("guest_email"));


                guestList.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return guestList;
    }
}
