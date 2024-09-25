package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class prtinfo
 */
@WebServlet("/prtinfo")
public class prtinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public prtinfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
		var name = request.getParameter("name");
		String number = request.getParameter("number");
		String gender = "none";
		
		if (number.charAt(0) == '1' || number.charAt(0) == '3') {
			gender = "male";
		} 
		
		else if (number.charAt(0) == '2' || number.charAt(0) == '4') {
			gender = "female";
		}
		
		out.println("<html>");
		out.print("<h1>Success!</h1>");
		out.print("Name : " + name + "<br>"); 
		out.print("Gender : " + gender + "<br>");
		out.println("</html>");
	}
}
