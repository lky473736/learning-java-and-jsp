package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class jsp
 */
@WebServlet("/findGender")
public class jsp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jsp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		
		var name = request.getParameter("name");
		var number = request.getParameter("number");
		
		PrintWriter out = response.getWriter();
		response.sendRedirect("prtinfo?name=" + name + "&number=" + number);
	}
}

/*
 * 서블릿의 장점
 *  - 자바를 기반으로 자바 API를 모두 사용 가능 (JVM으로 운영체제 제약 없이 사용 가능)
 *  - JVM은 OS 위에 돌아감. 자바 바이트코드는 변경 없이 각 OS에 맞게 실행 가능해지는 것임
 * 
 * 서블릿의 단점
 *  - 출력문으로 문자열 결합이 어렵고 번거로움
 *  - 서블릿에서 HTML을 포함할 경우, 화면 수정이 어려움
 *  - HTML 폼의 데이터 처리가 불편함
 * 
 * 서블릿 클래스의 구조
 *  - 2.0 버전에서는 웹 app 구조를 컨테이너에 알리기 위해 배포 서술자인 web.xml에 등록해야 했었음
 *  - 3.0 버전부터는 별도의 web.xml 작성 없이 자바 애너테이션을 이용하여 자원명을 기술함
 * 
 * HttpServletResponse: 정보를 주기 위한 객체
 * HttpServletRequest: 정보를 받기 위한 객체
 * 
 * 서블릿의 생명 주기
 *  1) 서블릿이 처음 초기화될 때 init()이 작동됨 (초기에 한 번만 실행)
 *  2) 쓰레드를 통해 동시에 실행됨 (service(), doGet(), doPost())
 *  3) 서블릿을 종료할 때 destroy()가 작동됨
 * 
 * sendRedirect(): 웹 브라우저에서 다른 페이지로 강제 이동시키기 위해 사용
 *  - 예시: 로그인 중 잘못된 접근이 발생하면 sendRedirect로 에러 메시지를 띄움
 *  - sendRedirect의 특징은 데이터를 공유할 수 없다는 것 (다른 웹페이지에서 실행 중이던 데이터를 넘길 수 없음)
 * 
 * 위 특징을 해결하기 위한 웹페이지 간 정보 공유 방법:
 *  1) session을 이용하는 방법
 *  2) query string을 사용하는 방법
 */
