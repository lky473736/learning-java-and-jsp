package com.test;

import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class sessionAddition
 */
@WebServlet("/sessionAddition")
public class sessionAddition extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sessionAddition() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session = request.getSession(); // 세션 만들어주세요
		PrintWriter out = response.getWriter(); // out 객체 선언
	
		session.setAttribute("name", "kim"); // 세션에 key, value 형태로 저장
		session.setAttribute("id", "kimid");
		session.setAttribute("university", "gachon");  
		
		String name = (String)session.getAttribute("name");
		String id = (String)session.getAttribute("id");		
		String university = (String)session.getAttribute("university");		
		
		out.println(name + ' ' + id + ' ' + university + "<br>");
		
		Enumeration en = session.getAttributeNames(); // getAttributeNames : 세션의 모든 키들의 이름을 열거형으로
		
		while (en.hasMoreElements()) { // 더 원소가 있을 때까지
			String s_name = en.nextElement().toString(); // key의 이름을 가져옴 (차례차례)
			String value = (String)session.getAttribute(s_name); // key를 넣어서 value 뽑기
			out.print("<b>" + s_name + " : " + value + "</b><br>");
		}
		
		// attribute 하나 삭제 : removeAttributes(세션 key 이름)
		session.removeAttribute("name");
		out.println("name : " + (String)session.getAttribute("name") + "<br>"); // 삭제했으니깐 null로 뜸
	
		// attribute 전부 삭제 : invalidate
		session.invalidate();
		
		if (request.isRequestedSessionIdValid()) { // 세션이 유효한가?
			out.print("세션이 있습니다.");
		}
		
		else {
			out.print("세션이 없습니다.");
		}
		
		// session의 유효 시간을 설정 : setMaxInactiveInterval 
		// 웹 브라우저에 마지막 접근한 시간부터 일정 시간내에 다시 접근 안하면 자동으로 세션 죽임
		HttpSession newSession = request.getSession();
		newSession.setAttribute("animal", "daramji");
		
		newSession.setMaxInactiveInterval(50); // 유효 시간의 기본값은 1800초이다 (초 단위로 설정)
		// 세션 유효 시간이 0이나 음수다 -> 유효 시간이 없다 -> 죽음 
		// 근데 여기서 invalidate를 안하고 있으면 유효 시간이 없는 세션이 계속 있는거임 (좀비프로세스마냥)
		
		// session의 유효 시간을 가져오기 : getMaxInactiveInterval
		double time = newSession.getMaxInactiveInterval();
		out.print("시간은 " + time);
	}
}
