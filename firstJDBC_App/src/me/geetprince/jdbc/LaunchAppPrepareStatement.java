
package me.geetprince.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class LaunchAppPrepareStatement {

    public static void main(String[] args) {

        Connection connect = null;
        PreparedStatement prepareStatement = null;
        Scanner s = new Scanner(System.in);

        try {
            connect = jdbcUtil.getConnection();

            String query = "INSERT INTO studentInfo (id, sname, sage, scity) VALUES (?, ?, ?, ?)";

            // Create PreparedStatement
            prepareStatement = connect.prepareStatement(query);

            System.out.println("Please enter the following details to be stored in DB");

            System.out.println("Enter your id:");
            int id = s.nextInt();

            System.out.println("Enter your name:");
            String name = s.next();

            System.out.println("Enter your age:");
            int age = s.nextInt();

            System.out.println("Enter your city:");
            String city = s.next();

            // Set values for placeholders
            prepareStatement.setInt(1, id);
            prepareStatement.setString(2, name);
            prepareStatement.setInt(3, age);
            prepareStatement.setString(4, city);

            // Execute INSERT query
            int rowsAffected = prepareStatement.executeUpdate();

            if (rowsAffected == 0) {
                System.out.println("No rows affected");
            } else {
                System.out.println(rowsAffected + " row(s) affected");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (prepareStatement != null) {
                    prepareStatement.close();
                }

                jdbcUtil.closeConnection(connect, null);

                s.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
