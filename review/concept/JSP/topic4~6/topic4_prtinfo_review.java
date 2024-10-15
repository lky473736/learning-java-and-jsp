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
public class topic4_prtinfo_review extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public topic4_prtinfo_review() {
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

/*
 * 이 페이지는 findGender에서부터 sendRedirect를 통하여 넘어온 페이지이다. 페이지와 페이지 사이에서는 정보 교환이 되지 않는다. 하지만 브라우저의 작은 메모리에 정보를 저장하여 공유하는 방법이 있을 수 있다. 
 */