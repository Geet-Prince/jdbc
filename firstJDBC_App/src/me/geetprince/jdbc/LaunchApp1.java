package me.geetprince.jdbc;
import java.sql.*;
public class LaunchApp1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Now we have to load and register the driver
		// step 1:
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		// Step 2: Establish the connection to the data base
		String url="jdbc:mysql://127.0.0.1:3306/jdbcLearning"; 
		String user="root";
		String password="825218"; 
		Connection connect = DriverManager.getConnection(url , user, password);
		
		
		//Step 3: Create Statement Objects
		Statement statement = connect.createStatement();
		
		// Step 4: Execute the query 
		String sql = "INSERT INTO studentInfo (id, sname, sage, scity)\n"
		        + "VALUES\n"
		        + "(6, 'Prince Raj', 21, 'Nalanda'),\n"
		        + "(2, 'Rahul', 22, 'Patna'),\n"
		        + "(3, 'Aman', 20, 'Delhi'),\n"
		        + "(4, 'Priya', 21, 'Noida'),\n"
		        + "(5, 'Neha', 22, 'Greater Noida')";
		int row_affected= statement.executeUpdate(sql);
		// step 5: Process the result
		
		if(row_affected==0) {
			System.out.print("Unable to insert the data");
		}
		else {
			System.out.print(row_affected+" Rows affected ");
			
		}
		
		
		
		// Step 6: close all the connections 
		
		statement.close();
		connect.close();
		

	}

}
