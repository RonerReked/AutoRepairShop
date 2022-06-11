<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--[if IE]><meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"><![endif]-->
<meta name="viewport" content="width=device-width">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath }/css/templatemo_main.css">
<script
	src="${pageContext.servletContext.contextPath }/js/jquery.min.js"></script>
<script
	src="${pageContext.servletContext.contextPath }/js/bootstrap.min.js"></script>
<script src="${pageContext.servletContext.contextPath }/js/Chart.min.js"></script>
<script
	src="${pageContext.servletContext.contextPath }/js/templatemo_script.js"></script>
<title></title>
</head>
<body>

	<tiles:insertAttribute name="vehicle_banner" />

	<div class="template-page-wrapper">
		<tiles:insertAttribute name="vehicle_menu_left" />
		<tiles:insertAttribute name="main" />
	</div>
</body>
</html>