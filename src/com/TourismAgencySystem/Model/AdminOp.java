package com.TourismAgencySystem.Model;

import com.TourismAgencySystem.Helper.DBConnector;
import com.TourismAgencySystem.Helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AdminOp {

    public static ArrayList<User> getList() {
        ArrayList<User> userList = new ArrayList<>();
        String query = "SELECT * FROM user";
        User obj;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                obj = new User();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setUsername(rs.getString("username"));
                obj.setPassword(rs.getString("password"));
                obj.setType(rs.getString("type"));
                userList.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
    public static boolean add(String name, String username, String password, String type) {
        String query = "INSERT INTO user(name,username,password,type) VALUES (?,?,?,?)";
        User findUser = getFetch(username);
        if (findUser != null) {
            Helper.showMessage("This username has been added before. Please enter a different username");
            return false;
        }

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, name);
            pr.setString(2, username);
            pr.setString(3, password);
            pr.setString(4, type);
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
    public static User getFetch(String username) {
        User obj = null;
        String query = "SELECT * FROM user WHERE username = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, username);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new User();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setUsername(rs.getString("username"));
                obj.setPassword(rs.getString("password"));
                obj.setType(rs.getString("type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }
    public static boolean delete(int id) {
        String query = "DELETE FROM user WHERE id = ?";
        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setInt(1, id);

            return ps.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    public static boolean update(int id, String name, String username, String password, String type) {
        String query = "UPDATE user SET name=?,username=?,password=?,type=? WHERE id=?";
        User findUser = getFetch(username);
        if (findUser != null && findUser.getId() != id) {
            Helper.showMessage("This username has been added before. Please enter a different username");
            return false;
        }
        try {
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.setString(4, type);
            ps.setInt(5, id);
            return ps.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    public static ArrayList<User> searchUserList(String query) {
        ArrayList<User> userList = new ArrayList<>();

        User obj;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                obj = new User();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setUsername(rs.getString("username"));
                obj.setPassword(rs.getString("password"));
                obj.setType(rs.getString("type"));
                userList.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public static String searchQuery(String name, String username, String type) {
        String query = "SELECT * FROM user WHERE username LIKE '%"+username+"%' AND name LIKE '%"+name+"%'";
        if (!type.isEmpty()) {
            query += " AND type='{{type}}'";
            query = query.replace("{{type}}", type);
        }
        return query;
    }


}
