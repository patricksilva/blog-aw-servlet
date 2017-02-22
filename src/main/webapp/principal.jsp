<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt">
<head>
	<meta charset="UTF-8"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
	<meta name="viewport" content="width=device-width, initial-scale=1"/>

	<title>Blog AW</title>

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
<body>

<div class="aw-layout-loading  js-loading-overlay">
	<div class="aw-layout-loading__container">
		<span class="aw-balls-spinner">Carregando...</span>
	</div>
</div>

<div class="aw-layout-page">

	<jsp:include page="layout/template/navigation.jsp" flush="true">
		<jsp:param name="title" value="DashBoard"/>
	</jsp:include>
	
	<jsp:include page="layout/template/menu.jsp" flush="true">
		<jsp:param name="title" value="DashBoard"/>
	</jsp:include>

	<section class="aw-layout-content  js-content">


		<div class="page-header">
		  <div class="container-fluid">
		    <h1>
		      Dashboard
		    </h1>
		  </div>
		</div>
	
		<div class="container-fluid">
		  
		  <div class="row">
		    <div class="col-sm-4">
		    
		      <div class="aw-box">
		        <div class="aw-box__icon">
		          <i class="fa  fa-bank  fa-3x"></i>
		        </div>
		        <div class="aw-box__value">R$983.433,20</div>
		        <div class="aw-box__title">Faturamento total</div>
		      </div>
		    
		    </div>
		
		    <div class="col-sm-4">
		    
		      <div class="aw-box">
		        <div class="aw-box__icon">
		          <i class="fa  fa-usd  fa-3x"></i>
		        </div>
		        <div class="aw-box__value">R$343.542,59</div>
		        <div class="aw-box__title">Faturamento no ano</div>
		      </div>
		    
		    </div>
		    
		    <div class="col-sm-4">
		    
		      <div class="aw-box">
		        <div class="aw-box__icon">
		          <i class="fa  fa-heartbeat  fa-3x"></i>
		        </div>
		        <div class="aw-box__value">R$40.233,40</div>
		        <div class="aw-box__title">Faturamento no mês</div>
		      </div>
		    
		    </div>
		  </div>
		
		  <div class="row">
		    <div class="col-sm-4">
		    
		      <div class="aw-box">
		        <div class="aw-box__icon">
		          <i class="fa  fa-users  fa-3x"></i>
		        </div>
		        <div class="aw-box__value">1.298</div>
		        <div class="aw-box__title">Total de clientes</div>
		      </div>
		    
		    </div>
		    
		    <div class="col-sm-4">
		    
		      <div class="aw-box">
		        <div class="aw-box__icon">
		          <i class="fa  fa-battery-empty  fa-3x"></i>
		        </div>
		        <div class="aw-box__value">123</div>
		        <div class="aw-box__title">Produtos sem estoque</div>
		      </div>
		    
		    </div>
		    
		    <div class="col-sm-4">
		    
		      <div class="aw-box">
		        <div class="aw-box__icon">
		          <i class="fa  fa-truck  fa-3x"></i>
		        </div>
		        <div class="aw-box__value">3.344</div>
		        <div class="aw-box__title">Estoque total</div>
		      </div>
		    
		    </div>
		  </div>
		
		  <div class="row">
		    <div class="col-sm-6">
		      <div class="aw-graph-box">
		        <div class="aw-graph-box__header">
		          <h2 class="aw-graph-box__title">Faturamento por mês <small>últimos 12 meses</small></h2>
		        </div>
		        <div class="aw-graph-box__content">
		          <div class="aw-graph-box__no-data">
		              <i class="fa  fa-line-chart  fa-2x"></i>
		              <span>Não há dados</span>
		          </div>
		
		          <div>
		            <canvas id="lineChart" height="160"></canvas>
		          </div>
		        </div>
		      </div>
		    </div>
		    
		    <div class="col-sm-6">
		      <div class="aw-graph-box">
		        <div class="aw-graph-box__header">
		          <h2 class="aw-graph-box__title">Faturamento por representante <small>últimos 12 meses</small></h2>
		        </div>
		        <div class="aw-graph-box__content" style="position: relative">
		          <div class="aw-graph-box__no-data">
		              <i class="fa  fa-line-chart  fa-2x"></i>
		              <span>Não há dados</span>
		          </div>
		
		          <div>
		            <canvas id="lineChart" height="160"></canvas>
		          </div>
		        </div>
		      </div>
		    </div>
		  </div>
		</div>

	</section>
	
	<footer class="aw-layout-footer  js-content">
		<div class="container-fluid">
			<span class="aw-footer-disclaimer">Blog AW.</span>
		</div>
	</footer>

</div>

<div class="aw-search-modal  js-search-modal">
	<form action="#" class="aw-search-modal__form">
		<input class="aw-search-modal__input  js-search-modal-input" type="text" placeholder="O que você está procurando?"/>
		<div class="aw-search-modal__input-icon">
			<i class="glyphicon  glyphicon-search  js-search-modal-go"></i>
		</div>
	</form>
	
	<div class="aw-search-modal__controls">
		<i class="glyphicon glyphicon-remove  js-search-modal-close"></i>
	</div>
</div>

<script src="<c:url value="/layout/javascripts/vendors.min.js"/>"></script>
<script src="<c:url value="/layout/javascripts/algaworks.min.js"/>"></script>

</body>
</html>