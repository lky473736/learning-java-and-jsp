package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class practiceSession
 */
@WebServlet("/practiceSession")
public class topic5_practiceSession_review extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public topic5_practiceSession_review() {
        super();
    }

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        Cookie[] cookies = request.getCookies(); // 쿠키
        HttpSession session = request.getSession();  // 세션
        String name = null; 
        int token = 0;
        
        if (cookies != null) { // 쿠키가 비어있다면
            for (Cookie c : cookies) { // 쿠키를 이용한 반복문 (쿠키 하나 빼겠음)
                if (c.getName().equals("username")) { // username이라고 하는 이름을 가진 쿠키가 지금 쿠키라면
                    name = c.getValue();  // 그 쿠키의 값을 빼와라 (string)
                    Integer counting = (Integer) session.getAttribute(name);  // 세션의 attribute을 Integer로 한다
                    
                    if (counting == null) {
                        counting = 0; // 방문 한번도 안했다면
                    } // 만약 counting이 현재 null이라면 (그니깐 가져온 name) -> counting을 0으로 지정해라
                    
                    out.print(name + "님 환영합니다.<br>");
                    out.print(name + "님은 " + (counting + 1) + "번째 방문이십니다.<br>");
                    session.setAttribute(name, counting + 1);  // setAttribute로 이름을 지정해주는것임(counting이 계속 지정됨 -> 업데이트되는것임)
                    token = 1; // token이 1이 됨
                    break;
                }
            }
        }
        
        if (token == 0) { // 그니깐 token = 0이라는 것은 쿠키를 아무리 뒤져도 username이라고 하는 키를 가진 쿠키가 없다
            out.println("<h1>로그인 하세요.</h1>");
        }
    }
}
