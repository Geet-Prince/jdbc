package me.geetprince.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Launchapp10000 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/jdbcLearning";
        String user = "root";
        String password = "825218";

        String sql = "SELECT * FROM studentsInfo WHERE id = 2";

        try (Connection con =
                     DriverManager.getConnection(url, user, password);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, 4);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    System.out.println(rs.getInt("id"));
                    System.out.println(rs.getString("name"));
                    System.out.println(rs.getInt("age"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}