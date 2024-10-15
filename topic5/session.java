public package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Session
 */
@WebServlet("/session")
public class session extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public session() {
        super();
    }

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        // 세션 생성
        HttpSession session = request.getSession();
        session.setAttribute("id", "daramji");
        
        // 세션 정보 얻기
        String id = (String) session.getAttribute("id");
        // String id = session.getAttribute("id").toString();
        out.println(id);
    }
}


/*
	Session 
		- cookie가 사용자 웹브라우저에 저장하는 값이라면, session은 서버가 가지고 있음 
		- 서버에 sesssion을 저장할 수 있는 임시 저장 공간이 만들어짐 (사용자별로 별도로 만들어짐) 
			- 브라우저는 서버에 접속하면 세션아이디 발급된거 기억됨
			- 서버는 해당 세션 아이디로 할당된 영역에 접근
		- 브라우저가 종료되면 없어진다
		- cookie보다는 보안성이 높다 
		- 보관이 용이하지 않다 (종료하면 사라지니깐)
		- 로그인 유지를 어떻게 할 것인가
			- 어느 기간정도 접속할때마다 로그인되게 하기 -> token
			- 브라우저 창 닫으면 창 켰을때 다시 로그인하게 하기 -> session
		- 페이지에서 페이지로 이동할때는 session이 유효한데 그냥 브라우저 자체를 닫아버리면 없어지는거임
		- 장바구니, 컨트롤러 구현에 많이 사용됨
		
		- getAttribute()  : 특정 속성 값 가져오기
		- removeAttribute()
		- setAttribute()
		- setMaxInactiveInterval
		...
*/ {
    
}
