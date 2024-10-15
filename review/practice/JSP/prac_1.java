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

@WebServlet("/prac_1")
public class prac_1 extends HttpServlet { 
	private static final long serialVersionUID = 1L;

    public prac_1() {
        super();
    }
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

//		try {
		out.print("<b>hello!!!! 조금만 기다리면 네이버로 이동됩니다</b>");

			
//			Thread.sleep(5000); // Pause for 5 second
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}		
//		response.sendRedirect("http://naver.com");
	}
}