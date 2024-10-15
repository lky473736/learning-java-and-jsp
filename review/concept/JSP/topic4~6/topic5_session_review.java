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
public class topic5_session_review extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public topic5_session_review() {
        super();
    }

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        // 세션 생성
        HttpSession session = request.getSession(); // HttpSession을 이용하여 세션을 만들게 된다. request.getSession으로 세션을 만든다. 
        session.setAttribute("id", "daramji"); // 세션의 값을 지정한다. setAttribute로 이름 : 값 이런 형식으로 지정한다.
        
        // 세션 정보 얻기
        String id = (String) session.getAttribute("id"); // getAttribute("이름") <-- String으로 형변환하여서 사용해줘야함
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
/*
 * Cookie는 웹브라우저에 저장하는 값으로, 각 웹 브라우저의 쿠키 저장소에 쿠키를 보관해놓고, 필요할 때마다 servlet에서 하나씩 추출하여 사용하는 것이다. Cookie를 생성할 때는 Cookie ck = new Cookie("~~", "");를 이용하고, Cookie를 웹브라우저에 추가할 때는 response.addCookie(ck); 와 같은 코드를 사용한다. Cookie를 이용하여 반복문을 돌릴 때는 for(Cookie c: Cookies)와 같은 형식으로 사용하며, Cookie의 이름을 가져오고 싶을 때는 c.getName()이며, 문자열과 비교하기 위하여 .equals("~~~~")와 같이 사용한다. 이때 c.getValue()와 같이 그에 대한 수치를 가져올 수 있게 된다.
 * 
 * Cookie와 다르게, session은 서버가 가지고 있는 데이터이다. 서버에 session을 저장할 수 있는 임시 저장 공간이 만들어지며, 이는 사용자별로 별도로 만들어지게 된다. (브라우저가 종료되면 없어짐 / cookie보다는 보안성이 좋음)
 * 
 * session은 종료하면 사라지니깐 보관성이 용이하지는 않다. 페이지에서 페이지로 이동할 때 session이 유효하게 된다. 
 * 
 * Cookie와 비슷하게 getAttribute, removeAttribute, setAttribute, setMaxInactiveInterval와 같이 사용하게 된다.
 */