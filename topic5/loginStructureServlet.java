package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class login
 */
@WebServlet("/loginStructureServlet")
public class loginStructureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginStructureServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
		
        Cookie[] cookies = request.getCookies();
        HttpSession session = request.getSession(); 
        String name = null; 
        int token = 0;
        
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("username")) {
                    name = c.getValue();
                }
            }
        }

        out.print("<body>");
        out.print("<h2>Login</h2>");
        out.print("<form action=\"/cookie/practiceSession\" method=\"GET\">");
        out.print("<label for=\"username\">Username:</label>");
        out.print("<input type=\"text\" id=\"username\" name=\"username\" value="+name+"><br><br>");
        out.print("<label for=\"password\">Password:</label>");
        out.print("<input type=\"password\" id=\"password\" name=\"password\" required><br><br>");
        out.print("<input type=\"submit\" value=\"Login\">");
        out.print("</form>");
        out.print("</body>");
       
		// response.sendRedirect(request.getContextPath() + "/practiceSession");
}
}
