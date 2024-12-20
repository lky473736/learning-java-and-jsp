package com.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

/**
 * Servlet implementation class cookie
 */
@WebServlet("/cookie")
public class topic5_cookie_review extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public topic5_cookie_review() {
        super();
    }

    /**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 쿠키 생성 및 추가
		Cookie cookie = new Cookie("id", "admin");
		response.addCookie(cookie); // 쿠키 추가
		response.addCookie(new Cookie("pw", "admin")); // 객체 생성 후 쿠키 추가
    }
} 

/*
	JSP에서 데이터를 공유하는 방법
		- query string을 이용하여 파라미터를 넣음 (url rewriting)
			- 보안성은 그리 좋지 않을 것임
			- sendRedirect에 주소에 파라미터 넣어서 보내기
			- 페이지마다  url query string을 만들어내야함 (굉장히 짜증남)
			
		- Cookie
			- 사이트에 접속할 때 생성되는 정보를 담은 4kb 이하 크기의 임시 파일
			- 사이트가 사용자 컴퓨터에 데이터를 저장할 수 있다 
			- 사이트에서 정보를 다룰 때, 무거운 데이터는 db에 보관해서 사용해야 되겠지만, 가벼운 데이터는 그냥 사용자 웹브라우저에 쿠키 심어두고 쓰면 되는거임
				- 사용자의 웹브라우저의 쿠키저장소에 쿠키가 쌓이고, 서버는 필요할 때마다 쿠키저장소에서 쿠키 빼먹으면 됨
			- 보안에 취약함 (특별한 보안 옵션을 부여 안했음)
			- 형식 : name = value (name : 쿠키이름 /  value : 값)
				- 유효기간, 요청경로, 도메인지정 등을 포함할 수 있음
			- getName() : 쿠키 이름 반환
			- getValue() : 쿠키 설정 값 반환
			- setMaxAge() : 쿠키 유효기간 설정
			- setValue() : 쿠키 값 설정
			- 로그인을 하면 로그인 상태랑 사용자 id가 들어있는 쿠키를 홈페이지에 넣어서 로그인 된 상태로 홈페이지를 쓸 수 있게 함
*/

/*------------------------------ */

/*
 * JSP에서 데이터를 공유하는 방법이나 Servlet에서 데이터를 공유하는 방법 뿐만이 아니라 그냥 모든 백엔드 시스템에서 데이터를 공유하는 방법은 거의 같다. GET이 method인 폼 태그에서 백엔드 시스템으로 넘어올 땐 Query String을 사용하겠다. 쿼리 스트링의 parameter를 받아오기 위해서 request.getParameter, request.getParameterNames, request.getParameterValues 등이 있었다. 이러면 사실 그렇게 좋은 방식은 아니다.
 * 
 * 그 이유는 보안적인 측면이다. 만약에 로그인을 하는데 GET방식으로 서버와 통신한다고 할 때, URL에 사용자의 id와 pw를 전부 노출하는 것이 보안성이 좋은 프로그램인가? 또한 sendRedirect에 주소에 파라미터를 보내는 것은, 페이지마다 url query string을 만들어내는 것이기 때문에 매우 귀찮은 작업이 되겠다.
 * 
 * 따라서 Cookie와 Session을 사용한다. Cookie란 사이트에 접속할 때 생성되는 정보를 담은 4kb 이하의 크기를 말한다. 사이트가 사용자 컴퓨터에 데이터를 저장하는 것이며, 무거운 데이터는 db에 저장하면 되지만, 가벼운 데이터는 그냥 웹페이지에 저장해버리는 것이 훨씬 효율적일 것이다. 웹브라우저에 쿠키 저장소에 쿠키를 저장하고, 필요할 때마다 쿠키를 빼면 되는 것이다. 하지만 쿠키는 보안에 매우 취약하다. 형식은 name = value와 같다. 유효기간과 요청경로, 도메인지정을 포함할 수 있다.
 * 
 * 
 */