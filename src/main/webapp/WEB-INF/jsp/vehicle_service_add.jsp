<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="templatemo-content-wrapper">
	<div class="templatemo-content">

		<div class="row">
			<div class="col-md-9 margin-bottom-15">

				<form:form modelAttribute="service" method="POST"
					action="${pageContext.servletContext.contextPath }/services/handleAdd">

					<label for="singleSelect"><spring:message
							code="vehicle_service_add.mechanics" /></label>
					<form:select class="form-control margin-bottom-15"
						id="singleSelect" path="mechanic" items="${mechanics}"
						itemLabel="name" itemValue="id">
					</form:select>

					<label for="singleSelect"><spring:message
							code="vehicle_service_add.customers" /></label>
					<form:select class="form-control margin-bottom-15"
						id="singleSelect" path="customers" items="${customers}"
						itemLabel="name" itemValue="id">
					</form:select>

					<label for="singleSelect"><spring:message
							code="vehicle_service_add.vehicles" /></label>
					<form:select class="form-control margin-bottom-15"
						id="singleSelect" path="vehicles" items="${vehicles}"
						itemLabel="registrationnumber" itemValue="id">
					</form:select>

					<label for="firstName" class="control-label"><spring:message
							code="vehicle_service_add.createdate" /></label>
					<form:input path="createdate" class="form-control margin-bottom-15" />
					<form:errors path="createdate" />
					<label for="firstName" class="control-label"><spring:message
							code="vehicle_service_add.detail" /></label>
					<form:textarea rows="5" cols="20" path="details" class="form-control margin-bottom-15" />
					<form:errors path="details" />

					<button type="submit" class="btn btn-primary"><spring:message
							code="vehicle_service_add.save" /></button>

				</form:form>

			</div>
		</div>

	</div>
</div>