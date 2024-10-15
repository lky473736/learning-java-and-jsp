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
public class topic4_findGender_review extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public topic4_findGender_review() {
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



/* --------------------------- */

/*
 *  서블릿이라고 하는 것은, 일종의 자바 백엔드 프로그램을 돌릴 수 있는 프로그램의 단위였다. 서블릿을 구동시키는 것이 서블릿 컨테이너이며, 서블릿 컨테이너 중 WAS가 있었고, 그런 WAS은 현재 톰캣을 이용하고 있다. 
 * 
 * 결국엔 JAVA가 주가 되는 것이 서블릿, HTML가 주가 되는 것이 JSP가 되겠다. 그러면 서블릿의 좋은 점은, 자바의 API를 모두 사용 가능하며, JVM으로 인하여 OS에 대한 제약이 없어졌다. JSP와의 차이점은 데이터를 결합하는 방식이 매우 어렵다는 것인데, JSP는 HTML 파일에 바로 자바 코드를 작성할 수 있어서 가공된 데이터를 웹에 띄우기가 편하였지만 서블릿은 직접 태그를 작성하고, 이것이 HTML 파일을 쓰는 것인지 setContentType으로 정의해야 하기 때문에 데이터 결합이 굉장히 어려웠다. 
 * 
 * 서블릿 클래스의 구조는, 2.0 버전에서는 전부 web.xml에 웹 app 구조를 명시하였어야 했다. 하지만 3.0 버전부터는 별도의 web.xml 작성 없이 자바 에터네이션 (@)을 이용하여 자원명을 기술할 수 있게 되었다.
 * 
 * 결국에 백엔드 시스템은 서버와 클라이언트의 상호작용이며, 클라이언트가 서버에게 무언가를 요청하면, 서버는 요청한 것을 처리하고 응답해주는 방식이기 때문에 response 객체와 request 객체가 존재하는 것이다. 여기서 request 객체로 처리할 수 있었던 것은 parameter를 가지고 오는 (getParameter, getParameterName, getParameterValue) 메소드와 response.setContentType 이였다. 
 * 
 * 서블릿의 생명 주기가 중요한데, 서블릿이 처음 초기화할 때는 init()이 한번 동작한다. 그 다음 쓰레드를 통해 동시에 실행될 때, service(), doGet(), doPost()를 동시에 실행한다. 이때 서블릿이 종료되면 destroy()가 작동된다. 
 * 
 * 여기서 sendRedirect라고 하는 코드가 있는데, 이는 response 객체의 메소드로써, 사용자에게 특정 라우팅된 주소로 이동시킬 때 사용한다. 이때 sendRedirect는 다른 페이지로 이동을 하게 시키는데, 중요한 점은 데이터를 같이 이동할 수 없다는 점이다. 추후에 servlet context를 이용하면 함께 이동을 시킬 수는 있으나, 현재는 불가능하니 URL에 정보를 실어서 정보를 전송한다. URL에 정보를 실을 수 있는 방법은 Query String이며, 이는 아래와 같이 구현할 수 있다.
 * 
 * http://www.mypage.com/main?name=hello&question=why
 * 
 * 서비스프로토콜://주소:포트/자원명 이런 형식으로 사용하게 되고, ? 이후로 Query string을 사용하게 된다. 
 * 
 */