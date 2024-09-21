package com.test; 

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class testServlet
 */
@WebServlet("/testServlet2")  // URL mapping값 (라우터 주소)
public class testServlet extends HttpServlet { 
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testServlet2() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		response.setContentType("text/html") // 지금부터 html 문서를 적겠다고 명시 (필수는 아님, 브라우저 입장에서 좋음)
		/*
		 * 	HttpServletRequest : 요청 (앞으로 요청에 관한 메소드는 이 클래스에서 다룰 것임)
		 * HttpServletResponse : 응답 (앞으로 응답에 관한 메소드는 역시 이 클래스에서 다룰 것임
		 */
		System.out.println("server activated"); 
		
		String var1 = "this is the var";
		PrintWriter out = response.getWriter();
		out.print("<h1>hello client</h1>");  // 클라이언트에게 출력
		out.print("<span style='color:red'>hi client</span>");  // 클라이언트에게 출력
		out.print("<br><span style='color:blue'>" + var1 + "</span>"); // 이렇게 하기엔 너무 귀찮으니 JSP를 도입하였음
		// out.print을 이용하여 클라이언트 웹브라우저에 띄우는 거는 "HTML 태그"임.
		
		for (int i = 0; i < 10; i++) {
		    out.print("<h4>" + i + "</h4>");
		}

		/////
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		/////
		out.print("<meta charset='UTF-8'>");
		out.print("<h1>안녕 클라이언트</h1>");  
		
		// 한글을 출력하였지만 브라우저에 나타나는 것은 ??????? 
		// -> 인코딩 타입 지정, 49, 50번줄 추가
		}
	}
}

/*
	- http://localhost:8080/f01/test_srv <--f01/test_srv에 있는 "자원"을 실행한 것임
	- 127.0.0.1 == localhost, 내 컴퓨터를 서버로 만든거임. 또한 크롬 브라우저에 저 주소를 넣어서 내 컴퓨터를 클라이언트로도 만든거임
	- 서버의 f01이라고 하는 폴더 안에 있는 test_srv라고 하는 것이 서블릿임
	- 서블릿은 일종의 자원 (프로그램) 
*/
