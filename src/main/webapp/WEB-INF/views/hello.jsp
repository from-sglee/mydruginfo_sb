<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<script src="${contextPath}/js/scriptTest.js" type="text/javascipt"></script>
<meta charset="UTF-8">
<title>hello.jsp 확인</title>
</head>
<body>
	하하하<p>
	<h2>${message }</h2>
	<input type="button" value="btn here">
</body>
</html>