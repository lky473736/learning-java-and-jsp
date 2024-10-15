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

@WebServlet("/prac_4")
public class prac_4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public prac_4() {
        super();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		Enumeration<String> paramNames = request.getParameterNames();
		int token = 0;
		
		while (paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();
			String[] values = request.getParameterValues(paramName);

			for (String value : values) {
				if ("daramji".equals(value)) {
					response.sendRedirect("prac_5?exist=true");
					token = 1;
					break;
				}
			}

			if (token == 1) {
				break;
			}
		}
		
		if (token == 0) {
			response.sendRedirect("prac_5?exist=false");
		}
	}
}
