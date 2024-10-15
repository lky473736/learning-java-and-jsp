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

@WebServlet("/prac_9")
public class prac_9 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public prac_9() {
        super();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		Cookie[] cookies = request.getCookies();
		
		int tokenOfDaramji = 0;
		
		for (Cookie ck : cookies) {
			if (ck.getName().equals("username")) {
				out.print("username : " + ck.getValue() + "<br>");
			}
			
			if (ck.getName().equals("password")) {
				out.print("password : " + ck.getValue() + "<br>");
			}
			
			if (ck.getName().equals("daramji")) {
				tokenOfDaramji = 1;
			}
		}
		
		if (tokenOfDaramji == 0) {
			out.print ("WHERE ARE YOU DARAMJI?");
		}
}
}
