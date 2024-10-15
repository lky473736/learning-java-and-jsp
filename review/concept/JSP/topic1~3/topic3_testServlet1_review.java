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
@WebServlet("/testServlet1") // 이게 일종의 라우터임. 이 파일은 localhost:8080/파일명/testServlet에 들어가면 실행됨 
public class topic3_testServlet1_review extends HttpServlet { // HttpServlet을 상속하고 있다
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public topic3_testServlet1_review() {
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


/* --------------------------------------------------------------------------- */

/*
	서블릿은 서버 쪽에서 실행되는 프로그램 단위를 이야기한다. 예를 들어서, operand가 2개인 웹 계산기를 생각해보자. operand를 입력하고 submit을 입력할텐데, operator에 따라서 계산 방법 및 보여주는 페이지도 달라야 한다. 그니깐 서버 단에서 실행되는 프로그램이 다르다는 것이다. 서블릿은 자바로 구성되어 있고, HTML와 데이터를 조합하는 것이 어려워서 JSP가 등장했는데, JSP는 추후에 살펴보겠다.

	서블릿 컨테이너는, 웹 서비스 프로그램이다. 이전 문서에서 서버를 구축하기 위해 필요한 3가지를 OS, 컴퓨터, 그리고 웹 서비스 프로그램이라고 언급하였다. 그니깐 자바로 웹프로그래밍을 하기 위해서는 자바로 작성된 것을 해석하고 실행시킬 프로그램이 필요하고, 그것이 서블릿 컨테이너, 일종의 실행기 역할인 것이다. WAS는 서블릿 컨테이너가 탑재된 프로그램이며, 톰캣이 그 WAS인 것임.

	웹이 어떻게 동작되는지 생각해보자.

	클라이언트-서버 방식을 다시 한번 끌고오자면, 클라이언트는 웹 서비스를 사용하는 사용자의 입장에서 서버에게 요청하고, 서버는 요청받은대로 서비스를 제공한다. 근데 여기에 서블릿이 더해진다면...

	서블릿을 이용하여 사용자의 요청에 반응하고 동적으로 웹페이지를 생성한다. 그니깐 서블릿에서 사용자가 무슨무슨 요청을 하면 이렇게저렇게 데이터를 만들어서 페이지에 뿌려주는 거라고 생각하자. 결국엔 클라이언트가 요청하면 웹서버가 서블릿을 호출 -> 요청한 것에 맞는 서블릿을 이용하여 처리 -> 처리한 결과를 HTML+데이터로 가공하여 서버에게 전송 -> 서버가 클라이언트에게 요청 결과 보여주는 것일테다.

	위 소스코드를 보자.

	15줄에 있는 주소가 바로 라우터이다. URL 형식은 서비스프로토콜://주소:포트/자원명이다. 여기서 자원명이 저 argument가 된다.

	33줄에 PrintWriter라고 하는 객체는 servlet에서 HTML 문서를 만들어 response하기 위해 필요하다. PrintWriter out = response.getWriter();이며, out.print, out.prinln처럼 사용한다.

	service는 request와 response를 parameter로 두고 있다. 말 그대로 요청, 응답인데, 지금 PrintWriter 보면 out = response.getWriter()라고 적지 않았는가? 그니깐 사용자에게 HTML 문서로 이쁘게 응답하기 위해서 response.~~~ 라고 한거다.

	참고로, out.print와 out.println의 차이는 뒤에 <br>의 차이다.
 */