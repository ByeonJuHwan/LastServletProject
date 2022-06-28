<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
<style>
    h1{
        text-align: center;
    }
    div{
        width: 200px;
        margin: auto;
    }
</style>
</head>
<body>
    <h1>환영합니다!! 메인페이지 이므로 로그인 해주시기 바랍니다!!</h1><br><br>
    
       <div>
        <a href="http://localhost:8080/LastServlet/login.html">
            <input type="button" value="로그인">
        </a>
        <a href="http://localhost:8080/LastServlet/memberFrom2.jsp">
            <input type="button" value="회원가입">
        </a>
    </div>
</body>
</html>