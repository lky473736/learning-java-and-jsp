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
public class topic5_checkLogin_review extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public topic5_checkLogin_review() {
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

/* ------- */

/*
 * 현재 프로그램에서는 new Cookie ("name", "value")형식으로 이름 쿠키를 저장하고, getCookies()을 이용하여 현재 브라우저에 있는 쿠키를 전부 gathering한다. 이때 Cookie[] 형태로 배열로 각 component가 쿠키로 지정된다.
 * 
 * if (cookies!=null)로 쿠키가 브라우저에 있다면, 반복문을 이용하여 cookie를 지정해놓고 있다. 쿠키를 c라고 지정하고 반복문을 돌리고 있으며, c.getName().equals("name") 코드로 name이라는 이름을 가진 쿠키이면 c.getValue()를 통하여 name 쿠키의 값을 반환한다.
 */