package me.geetprince.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcUtil {
	static 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException
	{

		
		String url="jdbc:mysql://127.0.0.1:3306/jdbcLearning";
		String name="root";
		String pass="825218";
		return DriverManager.getConnection(url, name, pass); 
		
	}
	public static void  closeConnection(Connection connect,Statement statement ) throws SQLException {
		statement.close();
		connect.close();
		
	}
}
 