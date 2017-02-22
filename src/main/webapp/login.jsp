<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="UTF-8"/>
  <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
  <meta name="viewport" content="width=device-width, initial-scale=1"/>

  <title>AlgaWorks</title>

  <link rel="stylesheet" type="text/css" href="<c:url value="/layout/stylesheets/vendors.min.css"/>"></link>
  <link rel="stylesheet" type="text/css" href="<c:url value="/layout/stylesheets/algaworks.min.css"/>"></link>
  <link rel="stylesheet" type="text/css" href="<c:url value="/layout/stylesheets/application.css"/>"></link>

  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>

<body class="aw-layout-simple-page">
  <div class="aw-layout-simple-page__container">

<form id="loginForm" action="authenticate/login" method="post">
	<div class="aw-simple-panel">
		<%--<img alt="Blog AW" src="layout/images/logo-gray.png"/> --%>
		<h1>Blog AW</h1>
		
		<div class="aw-simple-panel__message">
			Por favor, faça o login.
		</div>
		
		<div class="aw-simple-panel__box">
			<div class="form-group  has-feedback">
				<input type="text" class="form-control  input-lg" placeholder="Seu usuário" name="username"/>
				<span class="glyphicon  glyphicon-envelope  form-control-feedback" aria-hidden="true"></span>
			</div>
			
			<div class="form-group  has-feedback">
				<input type="password" class="form-control  input-lg" placeholder="Sua senha" name="password"/>
				<span class="glyphicon  glyphicon-lock  form-control-feedback" aria-hidden="true"></span>
			</div>
			<div class="form-group">
				<button type="submit" class="btn  btn-primary  btn-lg  aw-btn-full-width">Entrar</button>
			</div>
			
			<div class="form-group clearfix">
				<div class="pull-right">
					<a href="esqueceu-a-senha.html">Esqueceu a senha?</a>
				</div>
			</div>
		</div>
		
		<div class="aw-simple-panel__footer">Novo por aqui? <a href="#">Cadastre-se</a>.</div>
	</div>
</form>

  </div>

  <script src="<c:url value="/layout/javascripts/vendors.min.js"/>"></script>
  <script src="<c:url value="/layout/javascripts/algaworks.min.js"/>"></script>
</body>
</html>