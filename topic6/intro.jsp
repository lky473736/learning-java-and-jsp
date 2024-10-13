<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp" %> 
    <!-- 이게 page지시어, 소스코드 맨 앞에 적힘-->
<%@ page import="java.util.*" %> 
    
<!DOCTYPE html>  
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		System.out.println("hello!!");
	%>
</body>
</html>

<!-- 
	지시어, 스크립트릿, 주석, 선언문, 표현식
	
	지시어 : jsp 파일의 속성 정보 기술
	- page : JSP를 컨테이너에서 처리 (서블릿 변화) 하는데 필요한 속성 쓰기
	- include
	- taglib
	
	
-->