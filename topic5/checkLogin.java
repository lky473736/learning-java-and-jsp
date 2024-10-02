package com.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import java.io.PrintWriter;

@WebServlet("/checkLogin")
public class checkLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public checkLogin() {
        super();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        Cookie cookie = new Cookie("name", "임규연");
		response.addCookie(cookie); // 쿠키 추가

        Cookie[] cookies = request.getCookies();
        int token = 0;

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("name")) {
                    out.println("<h1>"+ c.getValue() + "님 로그인하세요</h1><br>");
                    token = 1;
                    break;
                }
            }
        }

        if (token == 0) {
            out.println("<h1>회원가입 하세요.</h1>");
        }
    }
}
