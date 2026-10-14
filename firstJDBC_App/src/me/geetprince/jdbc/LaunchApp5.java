package me.geetprince.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LaunchApp5 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		String url="jdbc:mysql://127.0.0.1:3306/jdbcLearning";
		String name="root";
		String pass="825218";
		Connection connect = DriverManager.getConnection(url, name, pass);
		
		Statement statement = connect.createStatement();
		
		String sql="update studentInfo set scity='Bihar sharif' where id=1";
		
		boolean status=statement.execute(sql);
		
		
		
		
		if(status) {
			//select
			 ResultSet rs=statement.getResultSet();
			 while(rs.next()) {
				 System.out.println( rs.getInt("id")+" "+ rs.getString("sname")+" "+rs.getInt("sage")+" "+rs.getString("scity"));
			 }
		}
		
		
		
		else {
			//nsert, update,delete
			int rowsAffected=statement.getUpdateCount() ;
			
			
			if(rowsAffected==0) {
				System.out.println("No rows affected");
			}
			
			else {
				System.out.println(rowsAffected+" rows Affected");
			}
		}
		
		
		
		
		statement.close();
		connect.close(); 
		
	}

}
