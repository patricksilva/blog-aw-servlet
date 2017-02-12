<%@page import="br.com.vofffice.aw.blog.domain.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	Usuario usuario = (Usuario) session.getAttribute("usuario");
	String context = request.getContextPath();
%>

<h3>Usuario logado <%=usuario.getNome()%></h3>
<p><a href="<%=context%>/authenticate/logout">Logout</a></p>
<h1>Blog Academia Web</h1>
</body>
</html>