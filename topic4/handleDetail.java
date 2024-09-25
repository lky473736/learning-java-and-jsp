package com.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Servlet implementation class handleDetail
 */
@WebServlet("/handleDetail")
public class handleDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public handleDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
    	
		out.println("<html>");
		out.print("<h1>success!</h1>");
		out.print("name : " + request.getParameter("name") + "<br>"); 
		out.print("nickname : " + request.getParameter("nickname")+ "<br>");
		out.print("grade : " + request.getParameter("grade") + "<br>"); 
		out.print("sex : " + request.getParameter("sex")+ "<br>");
		String[] subjects = request.getParameterValues("subject");
		if (subjects != null) { 
		    out.print("subject : ");
		    for (String subject : subjects) {
		        out.print(subject + " ");
		    }
		    out.print("<br>");
		} 
		
		else  {
		    out.print("subject : None<br>");
		}

		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
