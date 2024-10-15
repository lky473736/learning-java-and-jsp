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

@WebServlet("/prac_11")
public class prac_11 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public prac_11() {
        super();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		// 세션 연습
		// 세션을 받아옴
		HttpSession session = request.getSession(); // 세션이 현재 없다 -> 세션을 만듦
		session.setAttribute("daramji", "daramji");
		
		String animal = (String)session.getAttribute("daramji"); // 세션중에서 daramji를 key로 가지고 있는 것
		if (animal == null) {
			out.print("WHERE ARE YOU DARAMJI");
		}
		
		else {
			out.print("WOW THERE IS AN DARAMJI"); 
		}
		
		session.setAttribute("human", "lky");
		Enumeration entities = session.getAttributeNames();
		
		while (entities.hasMoreElements()) {
			String key = (String)entities.nextElement();
			
			if (session.getAttribute(key) != null) {
				out.print ("<h3>" + key + ' ' + (String)session.getAttribute(key) + "</h3><br>");
			}
		}
		
}
}
