<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<aside class="aw-layout-sidebar  js-sidebar">
	<div class="aw-layout-sidebar__content">

		<nav class="aw-menu  js-menu">
			<ul class="aw-menu__list">

				<li class="aw-menu__item"><a href="dashboard.html"><i
						class="fa  fa-fw  fa-home"></i><span>${fn:escapeXml(param.title)}</span></a></li>

				<li class="aw-menu__item  is-active"><a href="#"> <i
						class="fa  fa-fw  fa-file-text"></i><span>Cadastros</span> <i
						class="aw-menu__navigation-icon  fa"></i>
				</a>

					<ul class="aw-menu__list  aw-menu__list--sublist">
						<li class="aw-menu__item  aw-menu__item--link"><a
							href="3">Posts</a></li>
						<li class="aw-menu__item  aw-menu__item--link  is-active"><a
							href="<c:url value="/user"/>">${fn:escapeXml('Usuários')}</a></li>
					</ul></li>

			</ul>
		</nav>

	</div>
</aside>