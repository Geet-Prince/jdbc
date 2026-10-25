 

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * Servlet implementation class FirstServletApp
 */
@WebServlet("/firstServlet")
public class FirstServletApp extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		 String name=request.getParameter("uname");
		 String city=request.getParameter("ucity");
		 PrintWriter  writer = response.getWriter();
		 
		 writer.println("Hi☠️! "+name+" i know you live in "+city); 
		 
		 writer.close(); 
	}

}
