package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class jsp
 */
@WebServlet("/topic4_outprint_review")
public class topic4_outprint_review extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jsp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html"); // 36, 38번줄 사용하기 싫으면 33번줄 추가하면 됨 (html 문서임이 인식되게끔)
		
		PrintWriter out = response.getWriter();
		// out.print("<html><title></title><body>");
		out.print("hello<br>world"); // 36, 38번줄 혹은 33번줄을 사용하지 않으면 옆을 텍스트로 인식해서 <br>태그가 보이지만 사용하면 html 문서임을 인식하여 줄바꿈이 정상적으로 된다
		// out.print("</body></html>");
		
		// 그래서 일일히 태그를 다 달아주고 html 구조를 만들어줘야 html파일로 인식된다 -> 귀찮으니깐 JSP를 만듦
	}

}
