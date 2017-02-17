<%@page import="br.com.vofffice.aw.blog.domain.Usuario"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:url value=""></c:url>
<h3>Usuario logado ${usuario.nome}</h3>
<p><a href="<c:url value="/authenticate/logout"/>">Logout</a></p>
<h1>Blog Academia Web</h1>
</body>
</html>