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

@WebServlet("/prac_3")
public class prac_3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public prac_3() {
        super();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
//        response.setContentType("text/html; charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		
//		String[] subjects = request.getParameterValues("subject");
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		int cnt = 1;
//		
//		for (String subject : subjects) {
//			out.print("<b>subject " + cnt + "</b> : " + subject + "<br>");
//			cnt++;
//		}
//		
//		out.print(username + ' ' + password);
	}
}
