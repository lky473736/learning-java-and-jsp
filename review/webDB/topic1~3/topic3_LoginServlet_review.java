package com.test1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class topic3_LoginServlet_review extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public topic3_LoginServlet_review() {
        super();
    }
	
	/*
	 *  doGet, doPost를 이용하여 로그인 메소드를 만들기
	 *  doGet : get방식으로 데이터가 넘어왔을 때 호출되는 함수
	 *  doPost : post방식으로 데이터가 넘어왔을 때 호출되는 함
	 *  
	 *  두 함수 또한 service처럼 request와 response를 매개변수로 가지고 있음
	 *  
	 *  참고 : 서블릿 만들 때 패키지 (com.test) 아래 경로에서 만들면 됨
	 */
    
  /*
   *  URL로부터 사용자 입력 값을 추출하기 위한 함수 (URL파라미터로 사용자 입력 추출)
   *  1) getParameter(String name) : URL의 쿼리 스트링에서 이름이 name인 파라미터 반환
   *  	  - ~~~~.com/LoginServlet?name=daramji&age=10 -> name이 여기서 daramji니깐 getParameter(String name) == daramji
   *  2) getParameterValues(String name) : URL 쿼리 스트링에서 이름이 name인 파라미터가 여러개이면 배열 형태로 받을 수 있음
   *  3) getParameterNames() : 쿼리 스트링에서 이름에 해당되는 부분이 Enumeration 형식으로 반환
   */
    
    /*
     * src/main/webapp에 웹 파일 (html)을 가져다놓는거임
     * 클라이언트가 요청을 하는 경우에 보여줄 파일을 webapp에 놓음
     */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		// doGet -> 클라이언트가 get방식으로 보내면 이 함수가 보여짐
		
		PrintWriter out = response.getWriter();
		/*
		 * success하기 전에 DB에 엑세스하여 사용자의 id, pw를 먼저 찾고 아래 코드를 실행해야 할것임
		 */
		out.println("<html>");
		out.print("<h1>login success!</h1>");
		out.print("ID : " + request.getParameter("username") + "<br>"); // ID 출력
		out.print("PW : " + request.getParameter("password")+ "<br>"); // PW 출력
		out.print("paratmeters : " + request.getParameterNames());
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response); // 지금 보면 doPost가 doGet을 처음에 쓰고 있음. 따라서 post 처리 함수도 get에다가 써주면 문제 없을 것임
	}
}

/* --------------------------------------------------------------------------- */