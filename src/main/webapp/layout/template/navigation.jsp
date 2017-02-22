<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav
	class="navbar  navbar-fixed-top  navbar-default  js-sticky-reference"
	id="main-navbar">
	<div class="container-fluid">

		<div class="navbar-header">
			<a class="navbar-brand  hidden-xs" href="#"> <img alt="Blog AW"
				src="<c:url value="/layout/images/logo.png"/>"></img>
			</a>

			<ul class="nav  navbar-nav">
				<li><a href="#" class="js-sidebar-toggle"><i
						class="fa  fa-bars"></i></a></li>
			</ul>
		</div>

		<ul class="nav navbar-nav  navbar-right">

			<li><a href="#" class="js-search-modal-trigger-show"><i
					class="fa  fa-search"></i></a></li>

			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#" aria-expanded="false"> <i
					class="fa  fa-envelope"></i> <span
					class="label  label-danger  aw-label-corner">48</span>
			</a>

				<ul class="dropdown-menu">
					<li><a href="javascript:;">Item 1</a></li>
					<li><a href="javascript:;">Item 2</a></li>
				</ul></li>

			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown" role="button" aria-haspopup="true"
				aria-expanded="false"> <i class="fa  fa-user"></i>
			</a>

				<ul class="dropdown-menu">
					<li>
						<div class="aw-logged-user">
							<img src="https://api.adorable.io/avatars/${usuario.id}/${usuario.username}"
								width="80" height="80" alt="${usuario.fullName}"
								class="aw-logged-user__picture" /> <span
								class="aw-logged-user__name">${usuario.fullName}</span>
						</div>
					</li>
					<li role="separator" class="divider"></li>
					<li><a href="#">Meu perfil</a></li>
					<li><a href="#">Alterar senha</a></li>
					<li><a href="#">Pagamentos</a></li>
				</ul></li>

			<li><a href="#"><em class="fa  fa-sign-out"></em></a></li>
		</ul>

	</div>
</nav>