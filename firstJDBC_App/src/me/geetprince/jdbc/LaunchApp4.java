package me.geetprince.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class LaunchApp4 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://127.0.0.1:3306/jdbcLearning";
		String name="root";
		String pass="825218";
		
		Connection connect = DriverManager.getConnection(url, name, pass);
		
		Statement statement = connect.createStatement();
		
		String sql="Delete from studentInfo where id =6"; 
		
		int rows_affected=statement.executeUpdate(sql);//executeUpdate is used for select statements
		if(rows_affected==0) {
			System.out.println("failed tp delete the record");
		}
		else {
			System.out.println(rows_affected+" row deleted");
			
		}
		
		statement.close();
		connect.close();
		

	}

}
