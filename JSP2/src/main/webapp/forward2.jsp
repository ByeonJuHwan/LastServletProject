<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="JSP.*"%>
    <%request.setCharacterEncoding("UTF-8");
      MemberBean member = new MemberBean("lee","1234","이순신","lee@test.com");
      request.setAttribute("member",member);%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set  var="id"  value="hong"  scope="page" />


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward2</title>
</head>
<body>
	<jsp:forward page = "member2.jsp"/>
</body>
</html>