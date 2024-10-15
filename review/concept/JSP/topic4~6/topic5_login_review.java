package com.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class topic5_login_review extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public topic5_login_review() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if (username != null && password != null) {
			Cookie cookie = new Cookie("username", username);
			response.addCookie(cookie); // 쿠키 추가
		}
		
		else {
			;
		}
		
		response.sendRedirect(request.getContextPath() + "/welcome1");
}
}

/*
 * 프로그램에서 username과 password에 대하여 String으로 받고 있다. 보니깐 query string을 이용했을 것이다. (GET)
 * 
 * 그래서 만약 username과 password이 정상적으로 들어왔을 경우, username=username과 같은 양식으로 쿠키를 지정해주었다. 그래서 response.addCookie를 이용하여 쿠키를 웹페이지에 생성해주었다.
 * 
 * 여기서 쿠키를 만드는 방법은 Cookie ck = new Cookie("이름", 벨류) 이며, 쿠키를 웹페이지에 생성하는 방법은 response.addCookie(ck)와 같은 형식이다.
 */
