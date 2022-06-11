<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="templatemo-content-wrapper">
	<div class="templatemo-content">
		<div class="row">
			<div class="col-md-12">
				<div class="table-responsive">
					<h4 class="margin-bottom-15"><spring:message code="vehicle_customer_display.part"/></h4>
					<h1>${message}</h1>
					<table class="table table-striped table-hover table-bordered">
						<thead>
							<tr>
								<th><spring:message code="vehicle_customer_display.id"/></th>
								<th><spring:message code="vehicle_customer_display.name"/></th>
								<th><spring:message code="vehicle_customer_display.address"/></th>
								<th><spring:message code="vehicle_customer_add.contactdetails"/>
								<th><spring:message code="vehicle_customer_display.gender"/></th>
								<th><spring:message code="vehicle_customer_display.age"/></th>
								<th><spring:message code="vehicle_customer_display.detail_edit"/></th>
								<th><spring:message code="vehicle_customer_display.delete"/></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="customer" varStatus="i" items="${customers}">
								<tr>
									<td>${i.count}</td>
									<td>${customer.name }</td>
									<td>${customer.address }</td>
									<td>${customer.contactdetails }</td>
									<td>${customer.gender }</td>
									<td>${customer.age }</td>
									<td><a
										href="${pageContext.servletContext.contextPath }/customers/update/${customer.id}"
										class="btn btn-default"><spring:message code="vehicle_customer_display.button.edit"/></a></td>
									<td><a onclick="return confirm('<spring:message code="message.delete" />')"
										href="${pageContext.servletContext.contextPath }/customers/delete/${customer.id}"
										class="btn btn-link"><spring:message code="vehicle_customer_display.button.delete"/></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>