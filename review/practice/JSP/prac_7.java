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

@WebServlet("/prac_7")
public class prac_7 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public prac_7() {
        super();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		for (int i = 0; i < 5; i++) {
			String num = Integer.toString(i);
			Cookie ck = new Cookie (num, num); 
			response.addCookie(ck);
		}
		
        Cookie[] cookies = request.getCookies();
		
        for (int i = 0; i < 5; i++) {
        	String num = Integer.toString(i);
			for (Cookie ck : cookies) {
				if (ck.getName().equals(num)) {
					out.print("<h1>equals " + ck.getValue() + "</h1><br>");
					break;
				}
			}
        }
        
        Cookie cookie = new Cookie("daramji", "daramji");
        String newCookieName = cookie.getName();
        out.print("<h3>" + newCookieName + "</h3><br>");
    	cookie.setMaxAge(0); // 쿠키의 유효기간을 만료시킴
    	// 쿠키의 유효기간이 만료되면 
    	response.addCookie(cookie);
    	
    	Cookie[] newCookies = request.getCookies();
    	int token = 0;
    	
    	for (Cookie ck : newCookies) {
    		if (ck.getValue().equals("daramji")) {
    			token = 1;
    			break;
    		}
    		
    		else {
    			token = 0;
    			out.print("NO DARAMJI HERE<br>");
    		}
    	}
    	
    	if (token == 0) {
    		out.print("OH MY GOD DARAMJI WHERE ARE YOU");
    	}
}
}
