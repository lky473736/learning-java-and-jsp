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
public class practiceSession extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public practiceSession() {
        super();
    }

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        Cookie[] cookies = request.getCookies();
        HttpSession session = request.getSession(); 
        String name = null; 
        int token = 0;
        
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("username")) {
                    name = c.getValue(); 
                    Integer counting = (Integer) session.getAttribute(name); 
                    
                    if (counting == null) {
                        counting = 0; // 방문 한번도 안했다면
                    }
                    
                    out.print(name + "님 환영합니다.<br>");
                    out.print(name + "님은 " + (counting + 1) + "번째 방문이십니다.<br>");
                    session.setAttribute(name, counting + 1); 
                    token = 1;
                    break;
                }
            }
        }
        
        if (token == 0) {
            out.println("<h1>로그인 하세요.</h1>");
        }
    }
}
