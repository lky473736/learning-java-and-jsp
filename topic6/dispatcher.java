package com.test;

import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class dispatcher
 */
@WebServlet("/dispatcher")
public class dispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dispatcher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter(); // out 객체 선언
		
		/*
		 * 그동안 페이지를 이동할 때 sendRedirect로 함
		 * sendRedirect할 때 정보를 안고 이동하고 싶다면 query string을 사용
		 * query string 사용하지 않고 정보를 옮기고 싶다면 dispatcher 사용
		 */
		
		/*
		 * form에서 id와 pw를 넘겨준다고 가정해보자
		 */
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("getParamFromDispatcher"); 
		// getParamFromDispatcher라는 이름의 서블릿으로 정보 넘겨줌 (데이터를 가지고서 이동할 페이지)
		dispatcher.forward(request, response); // forward를 이용하여 다른 서블릿으로 넘겨줄 수 있음
	}

}
