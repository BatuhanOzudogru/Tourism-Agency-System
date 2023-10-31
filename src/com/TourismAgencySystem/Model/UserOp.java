package com.TourismAgencySystem.Model;

import com.TourismAgencySystem.Helper.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserOp {
    public static User getFetch(String username,String password) {
        User obj = null;
        String query = "SELECT * FROM user WHERE username = ? AND password = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, username);
            pr.setString(2,password);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                switch (rs.getString("type")){
                    case "admin":
                        obj=new Admin();
                        break;
                    default:
                        obj = new Employee();
                }

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
}
