package com.test;

import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class sessionAddition
 */
@WebServlet("/servletContext")
public class servletContext extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletContext() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session = request.getSession(); // 세션 만들어주세요
		PrintWriter out = response.getWriter(); // out 객체 선언
		
		session.setAttribute("id", "lim");
		session.setAttribute("animal", "daramji");
		
		out.println((String)session.getAttribute("id") + ' ' + (String)session.getAttribute("animal") + "<br>"); 
		
		/*
		 * Servlet Context : 서블릿을 실행하는 서블릿 컨테이너에 있는 메모리 (저장공간)
		 * 클라이언트가 웹서버에 요청한다 -> 서블릿이 컨테이너에 적재될때 init 메소드가 실행된다
		 * "웹 서버에서 정보공유를 어떻게 할 것인가? 페이지간 정보공유는 어떻게 할 건인가?"
		 * 지금까지 다룬건 페이지 정보공유임. (세션, 쿠키) 그런데 만약 서블릿간에 자원공유는 어떻게 해야하는가 -> 그래서 servlet context로 함
		 * 
		 */
		
		// servlet context 객체 생성
		ServletContext application = request.getServletContext();
		application.setAttribute ("id", "kim"); // 이거 session이랑 똑같음
		String uid = (String)application.getAttribute("id");
		out.print(uid + "<br>");
		
		/*
		 * 데이터를 포함하여 이동한다 -> request 속성으로 데이터를 넣은 후 원하는 페이지로 포워딩해야함 (쿼리스트링)
		 * session이나 cookie, application
		 */
		
		// session과 servlet context 비교 : ./sessionNpagecontext.java
	}
}
