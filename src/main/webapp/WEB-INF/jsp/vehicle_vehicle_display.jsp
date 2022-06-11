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
						<spring:message code="vehicle_vehicle_display.part" />
					</h4>
					<h1>${message}</h1>
					<table class="table table-striped table-hover table-bordered">
						<thead>
							<tr>
								<th><spring:message code="vehicle_vehicle_display.id" /></th>
								<th><spring:message
										code="vehicle_vehicle_display.registration_number" /></th>
								<th><spring:message code="vehicle_vehicle_display.make" /></th>
								<th><spring:message code="vehicle_vehicle_display.model" /></th>
								<th><spring:message
										code="vehicle_vehicle_display.model_year" /></th>
								<th><spring:message code="vehicle_vehicle_display.funds" /></th>
								<th><spring:message code="vehicle_vehicle_display.miles" /></th>
								<th><spring:message
										code="vehicle_vehicle_display.detail_edit" /></th>
								<th><spring:message code="vehicle_vehicle_display.services" /></th>
								<th><spring:message code="vehicle_vehicle_display.delete" /></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="vehicle" varStatus="i" items="${vehicles}">
								<tr>
									<td>${i.count}</td>
									<td>${vehicle.registrationnumber }</td>
									<td>${vehicle.make }</td>
									<td>${vehicle.model }</td>
									<td>${vehicle.modelyear }</td>
									<td>${vehicle.funds }</td>
									<td>${vehicle.miles }</td>
									<td><a
										href="${pageContext.servletContext.contextPath }/vehicles/update/${vehicle.id}"
										class="btn btn-default"><spring:message
												code="vehicle_vehicle_display.button.edit" /></a></td>
									<td><a
										href="${pageContext.servletContext.contextPath }/services/serviceDisplay/${vehicle.id}"
										class="btn btn-link"><spring:message
												code="vehicle_vehicle_display.button.service" /></a></td>
									<td><a  onclick="return confirm('<spring:message code="message.delete" />')"
										href="${pageContext.servletContext.contextPath }/vehicles/delete/${vehicle.id}"
										class="btn btn-link"><spring:message
												code="vehicle_vehicle_display.button.delete" /></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>