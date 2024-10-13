<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hello World</title>
</head>
<body>
<h2>Hello World</h2>

<hr>

현재 날짜와 시간은
<%=java.time.LocalDateTime.now()%> <!-- 동적 웹이 탄생 -->
입니다.
</body>
</html>

<!--
    그니깐 이게 동적 웹이다. 사용자, 즉 클라이언트가 사이트를 들어갈 때마다 저 LocalDateTime.now() 명령으로 인하여 바뀌어진다.

    동적 웹을 만들기 위해 2가지 스크립트가 필요한데 그게 바로 client script, server script이다.
-->