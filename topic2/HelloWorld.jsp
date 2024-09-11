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