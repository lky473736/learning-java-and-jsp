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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/prac_17")
public class prac_17 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public prac_17() {
        super();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		ServletContext context = getServletContext(); // 서블릿컨텍스트 가져오기
		
		context.setAttribute("name", "lky");
		
		// 그냥 session이랑 똑같음
		String name = (String)context.getAttribute("name");
		out.print("hello " + name);
		
		/*
		 * 
		    // servlet context 객체 생성
			ServletContext application = request.getServletContext();
			application.setAttribute ("id", "kim"); // 이거 session이랑 똑같음
			String uid = (String)application.getAttribute("id");
			out.print(uid + "<br>");
		 */
}
}
