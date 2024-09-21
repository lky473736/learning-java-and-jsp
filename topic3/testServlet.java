package com.test; // 방금 전에 패키지명 작성할 때 com.test 적었음

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
@WebServlet("/testServlet") // 이게 일종의 라우터임. 이 파일은 localhost:8080/파일명/testServlet에 들어가면 실행됨 
public class testServlet extends HttpServlet { // HttpServlet을 상속하고 있다
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // service는 request와 responce를 parameter로 두고 있음
		System.out.println("server activated"); // 콘솔에 출력함 (client에서 response하고 있는 건 없음)
		
		PrintWriter out = response.getWriter(); // Servlet에서 response를 하기 위해 (웹에 출력하기 위해) PrintWriter가 필요
		
		out.print("<h1>hello client</h1>"); // 이제 클라이언트 웹 브라우저에 이게 보임
		
		// 그니깐 out.print를 이용하여 사용자에게 가공된 데이터를 보여줄 수 있는데,
		// HTML와 데이터를 조합해야 하기 때문에 작성하기가 복잡하고 어려움
		// 파이썬에서는 f"hello {data}"라고 하면 되지만 자바에서는 그게 안되나봄
	}

}

/*
	- 서블릿
		- 서버 쪽에서 실행되는 프로그램(단위)
		- 자바 프로그램의 웹 프로그래밍을 위해 필요함
		- 서블릿은 HTML과 데이터를 조합하는 것이 어려움 -> JSP가 등장
		
	- 서블릿 컨테이너
		- 자바로 웹프로그래밍을 하기 위해선 자바로 작성된 웹 실행기가 필요함 => 서블릿 컨테이너 (서블릿을 실행하는 일종의 실행기)
		- 톰캣은 서블릿 컨테이너를 가지고 있는 WAS라고 하는 소프트웨어임
		- WAS (Web Application Server) : 서블릿 컨테이너가 탑재된 프로그램
		
	- 웹 동작 과정
		- 클라이언트 서버 방식
			- 클라이언트가 요청하면 서버는 그에 따라 응답한다.
		
		- 클라이언트 서버 방식 + 서블릿
			- 서블릿을 이용하여 사용자의 요청에 반응하고 동적으로 웹페이지를 만듦
			- 클라이언트가 요청하면 웹서버가 서블릿을 호출 -> 요청한 것에 맞는 서블릿을 이용하여 처리 -> 처리한 결과를 HTML+데이터로 가공하여 서버에게 전송 -> 서버가 클라이언트에게 요청 결과 보여줌
*/
