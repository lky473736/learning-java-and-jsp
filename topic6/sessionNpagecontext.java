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
 * Servlet implementation class sessionNpagecontext
 */
@WebServlet("/sessionNpagecontext")
public class sessionNpagecontext extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sessionNpagecontext() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session = request.getSession(); // 세션 만들어주세요
		PrintWriter out = response.getWriter(); // out 객체 선언
		
		String id = (String)session.getAttribute("id"); 
		String animal = (String)session.getAttribute("animal");
		
		out.println ("id : " + id + " / animal : " + animal + "<br>");
		
		ServletContext application = request.getServletContext();
		String userName = (String)application.getAttribute("id");
		
		out.println(userName);
		
		/*
		 * 세션은 원시적으로 서블릿과 서블릿의 정보 공유가 어렵다
		 * 브라우저마다 각자 다른 세션 id를 가지고 있는 것
		 * 하지만 ServletContext는 가능함
		 */
		
	}

}
