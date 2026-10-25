

import jakarta.servlet.ServletException; 
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/Register")
public class Register extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("uname");
		String email=request.getParameter("email");
		String upassword=request.getParameter("password");
		String ucity =request.getParameter("ucity");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url ="jdbc:mysql://127.0.0.1:3306/prince_db";
			String user="root";
			String password="825218";
			Connection connect = DriverManager.getConnection(url, user, password);
			
			String sql = "INSERT INTO personalinfo (uname, email, upassword, ucity) VALUES (?, ?, ?, ?)";
			PreparedStatement pstatmnt = connect.prepareStatement(sql);
			
			
			pstatmnt.setString(1, uname);
			pstatmnt.setString(2, email);
			pstatmnt.setString(3, upassword);
			pstatmnt.setString(4, ucity );
			
			
			int RowAffect=pstatmnt.executeUpdate();
			
			
			PrintWriter pw = response.getWriter();
			
			
			
			if(RowAffect!=0) {
				pw.println("<h1>Registration success <h1/>"); 
			}
			else {
				System.out.println("<h1>Registration unsuccess <h1/>");
			}
			pstatmnt.close();
			connect.close(); 
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
