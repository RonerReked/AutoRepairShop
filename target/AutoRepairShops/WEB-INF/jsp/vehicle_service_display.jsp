<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="templatemo-content-wrapper">
	<div class="templatemo-content">
		<div class="row">
			<div class="col-md-12">
				<div class="table-responsive">
					<h4 class="margin-bottom-15">
						<spring:message code="vehicle_service_display.part" />
					</h4>
					<h1>${message}</h1>
					<label for="singleSelect"><spring:message
							code="vehicle_service_display.title.search" /></label>
					<form method="get"
						action="${pageContext.servletContext.contextPath }/services/search">
						<input type="month" name="monthValue"
							class="form-control margin-bottom-15">
						<button type="submit" class="btn btn-primary margin-bottom-15"><spring:message
							code="vehicle_service_display.search" /></button>
					</form>
					<table class="table table-striped table-hover table-bordered">
						<thead>
							<tr>
								<th><spring:message code="vehicle_service_display.id" /></th>
								<th><spring:message code="vehicle_service_display.vehicle" /></th>
								<th><spring:message code="vehicle_service_display.customer" /></th>
								<th><spring:message code="vehicle_service_display.mechanic" /></th>
								<th><spring:message code="vehicle_service_display.createdate" /></th>
								<th><spring:message code="vehicle_service_display.detail" /></th>
								<th><spring:message code="vehicle_service_display.display_edit" /></th>
								<th><spring:message code="vehicle_service_display.delete" /></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="service" varStatus="i" items="${services}">
								<tr>
									<td>${i.count}</td>
									<td>${service.vehicles.registrationnumber }</td>
									<td>${service.customers.name }</td>
									<td>${service.mechanic.name }</td>
									<td>${service.createdate }</td>
									<td>${service.details }</td>
									<td><a
										href="${pageContext.servletContext.contextPath }/services/update/${service.id}"
										class="btn btn-default"><spring:message
												code="vehicle_service_display.edit" /></a></td>
									<td><a onclick="return confirm('<spring:message code="message.delete" />')"
										href="${pageContext.servletContext.contextPath }/services/delete/${service.id}"
										class="btn btn-link"><spring:message
												code="vehicle_service_display.button.delete" /></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>