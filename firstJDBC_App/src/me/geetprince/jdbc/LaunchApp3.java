package me.geetprince.jdbc;
import java.sql.*;

public class LaunchApp3 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://127.0.0.1:3306/jdbcLearning";
		String name="root";
		String password="825218";
		Connection connect=(Connection) DriverManager.getConnection(url,name , password);
		
		Statement statement=connect.createStatement();
		String sql="select * from studentInfo";
		ResultSet rs=statement.executeQuery(sql);
		
		while(rs.next()) {
			System.out.println( rs.getInt(1)+" "+ rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4));
		}
		
		
		rs.close();
		statement.close();
		connect.close();

	}

}
