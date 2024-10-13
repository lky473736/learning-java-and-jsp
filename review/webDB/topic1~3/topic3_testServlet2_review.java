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
public class topic3_testServlet2_review extends HttpServlet { 
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public topic3_testServlet2_review() {
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


/*
	- JSP
		- 서블릿 안에 HTML와 데이터 결합을 손쉽게 처리하기 위해 만들어짐
		- 일일히 태그를 입력하고 이러기엔 너무 어려움. 그래서 HTML 문서 위에 자바소스코드를 적는 것임 (ejs처럼)
		- HTML 파일에 자바 코드를 심는 형태(JSP) vs 자바 코드에 HTML 파일을 심는 형태(서블릿)
		- <%= %> 안에 코드 혹은 데이터 작성
		- JSP는 page 지시어 부분만 제외하면 HTML 파일 구조랑 동일
		- CSS, 자바스크립트 또한 안에 넣을 수 있음
		- 서블릿으로 변환되어 실행됨 
			- 컨테이너에 의해 서블릿 형태로 변환 후 컴파일되어 컨테이너에 적재되는 구조임
			- 결국엔 JSP가 서블릿으로 변환되어 실행되는 거니깐 JSP 또한 서블릿의 전단계가 됨
		
	- 웹 개발 history (백엔드)
		- HTML : 정적 웹 -> 동적 웹으로 이동하기 위함
		- servlet : 동적 웹을 구성하기 위함 -> 태그 사용하기 불편
		- JSP : Java server page
		- MVC : MVC패턴 
			- Model, View, Controller
				- Model : 비지니스 논리 (엑세스)
				- View : JSP (프론트엔드)
				- Controller : Servlet (백엔드)
			- 각각이 모듈화되어 있어서 유지보수가 쉽고 개발을 따로 분리하여 할 수 있음 (각각 별도로 개발해서 합칠 수도 있고, 협업에도 유리함)
		- MVC Framework : 여기서 백엔드를 많이 함 (spring, express, fastapi...)
*/
