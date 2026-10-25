package me.geetprince.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LaunchApp5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connect=null;
		Statement statement =null;
		try {
			connect =jdbcUtil.getConnection(); 
		
		
		
		
		 statement = connect.createStatement();
		
		String sql="update studentInfo set scity='Bihar sharif bihar' where id=1";
		
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
		
		
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace(); 
		}
		finally {
			try {
				jdbcUtil.closeConnection(connect, statement);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
