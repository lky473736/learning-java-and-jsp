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

@WebServlet("/prac_12")
public class prac_12 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public prac_12() {
        super();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		session.setAttribute("animal", "daramji");
		session.setAttribute("human", "lky");
		session.setAttribute("hello", "hi");
		
		out.print("session : " + (String)session.getAttribute("animal"));
		out.print("<br>");
		
		long time = session.getCreationTime();
		out.print("Session Creation Time: " + new Date(time));
		out.print("<br>");
		
		int maxInterval = session.getMaxInactiveInterval();
		out.print("현재 세션에서 최대유효 시간 (초) : " + maxInterval);
		out.print("<br>");
		
		session.setMaxInactiveInterval(60); // 60초
		out.print("바뀐 세션 유지 시간 : " + Integer.toString(session.getMaxInactiveInterval()));
		out.print("<br>");

		session.removeAttribute("hello");
		String helloValue = (String) session.getAttribute("hello"); // null이 반환될 수 있음
		out.print("hello 없앰 : " + helloValue);
		out.print("<br>");

		session.invalidate(); // 전부 없앰
		Enumeration<String> sessionNames = session.getAttributeNames();
		out.print(sessionNames);
		
		if (request.isRequestedSessionIdValid()) { // 세션이 유효한가?
			out.print("세션이 있습니다.");
		}
		
		else {
			out.print("세션이 없습니다.");
		}
}
}
