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

/*
	이 프로그램은 로그인 프로그램이다. 여기서는 doGet과 doPost 구조를 사용하였다. doGet은 get 방식으로 데이터가 넘어왔을 때 호출되고, doPost는 post방식으로 데이터가 넘어왔을 때 호출되는 함수다. 두 함수 또한 service처럼 response와 request를 매개변수로 가지고 있다는 것이다. 그럼 뭘 할지 알고 있을 것 같은데?

	get, post를 클라이언트가 하면, 그게 get이던 post이던 서버는 응답을 해야한다. 당연히 "응답" 해야하니깐 response가 있는 것이겠고, 어떻게 요청했는지를 알아야 뭘 하지 않을까? 그러니 request가 있는 것일거다. 그러면 클라이언트는 서버에게 어떤 방식을 통하여 무언가를 요청하는가?

	get 방식에서는 URL Parameter에 정보를 붙여서 서버로 전송한다. URL의 최대 길이를 넘어가면 안되며, 속도가 빠르다는 장점이 있으나, 로그인이나 회원가입 같은 민감한 정보를 get으로 보내면 당연히 URL에 노출이 되기 때문에 보안성이 취약하다는 단점이 있다. 반면 post 방식에서는 request header에 정보를 붙여서 서버로 전송하게 되는데, 외부로 노출되지 않기 때문에 보안적 측면에서는 우수하다. 하지만 get보다는 좀 느리다.

	query string을 통하여 get에서 정보를 전달하는데, 아래와 같은 양식이다.

	http://www.myhomepage.com/main?name=lky&animal=daramji

	그러면 사용자가 보낸 정보가 무엇인지를 뜯어보아야 할 테니, 그 함수는 getParamter이다. getParameter는 사용자가 서버에게 보낸 정보가 무엇인지를 볼 수 있으며, argument로는 name명이 들어간다. (여기서 name은 폼 태그 안에서 입력 (input) 태그에서 붙이는 이름이다.) 예시로 아래와 같은 코드가 있다고 가정하자.

	String name = request.getParameter("name");

	문자를 받을 변수인 name을 만들어주었고, name명이 name인 입력창에 사용자가 입력한 정보를 name에 넣으라고 하는 명령이다. (name밭)

	여러 개를 동시에 받을 수도 있는데, getParameterValues()이다. 예를 들어 아래 예시를 보자.

	String[] names = request.getParamterValues("name");

	그니깐 names라고 하는 문자열 배열을 만들어주었고, 거기에 name이라고 하는 name을 가진 입력창에서 입력한 여러 값들을 배열로 assign해주는 것이다.

	모든 parameter의 이름, 그니깐 쿼리 스트링에서 이름에 해당되는 부분을 Enumeration 형식으로 반환해주는 getParameterNames()도 있다.
*/