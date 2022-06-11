<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="navbar-collapse collapse templatemo-sidebar">
	<ul class="templatemo-sidebar-menu">
		
		<li class="active"><a href="${pageContext.servletContext.contextPath }/home"><i class="fa fa-home"></i><spring:message
							code="vehicle_menu_left.home" /></a></li>
		
		<li class="sub open"><a href="javascript:;"> <i
				class="fa fa-database"></i> <spring:message
							code="vehicle_menu_left.customers" />
				<div class="pull-right">
					<span class="caret"></span>
				</div>
		</a>
			<ul class="templatemo-submenu">
				<li><a
					href="${pageContext.servletContext.contextPath }/customers/add"><spring:message
							code="vehicle_menu_left.customers.add" /></a></li>
				<li><a
					href="${pageContext.servletContext.contextPath }/customers/display"><spring:message
							code="vehicle_menu_left.customers.display" /></a></li>
			</ul></li>

		<li class="sub open"><a href="javascript:;"> <i
				class="fa fa-database"></i> <spring:message
							code="vehicle_menu_left.vehicles" />
				<div class="pull-right">
					<span class="caret"></span>
				</div>
		</a>
			<ul class="templatemo-submenu">
				<li><a
					href="${pageContext.servletContext.contextPath }/vehicles/add"><spring:message
							code="vehicle_menu_left.vehicles.add" /></a></li>
				<li><a
					href="${pageContext.servletContext.contextPath }/vehicles/display"><spring:message
							code="vehicle_menu_left.vehicles.display" /></a></li>
			</ul></li>

		<li class="sub open"><a href="javascript:;"> <i
				class="fa fa-database"></i> <spring:message
							code="vehicle_menu_left.services" />
				<div class="pull-right">
					<span class="caret"></span>
				</div>
		</a>
			<ul class="templatemo-submenu">
				<li><a
					href="${pageContext.servletContext.contextPath }/services/add"><spring:message
							code="vehicle_menu_left.services.add" /></a></li>
				<li><a
					href="${pageContext.servletContext.contextPath }/services/display"><spring:message
							code="vehicle_menu_left.services.display" /></a></li>
			</ul></li>
	</ul>
</div>