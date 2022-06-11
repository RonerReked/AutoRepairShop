<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="templatemo-content-wrapper">
	<div class="templatemo-content">

		<div class="row">
			<div class="col-md-9 margin-bottom-15">

				<form:form modelAttribute="vehicle" method="POST"
					action="${pageContext.servletContext.contextPath }/vehicles/handleUpdate">

					<form:hidden path="id" />
					<label for="firstName" class="control-label"><spring:message
							code="vehicle_vehicle_add.customer" /></label>
					<br />
					<select name="customerid">
						<c:forEach var="c" items="${customers }">
							<option value="${c.id }">${c.name }</option>
						</c:forEach>
					</select>
					<br />

					<label for="firstName" class="control-label"><spring:message
							code="vehicle_vehicle_add.registration_number" /></label>
					<form:input path="registrationnumber"
						class="form-control margin-bottom-15" />
					<form:errors path="registrationnumber" />
					<label for="firstName" class="control-label"><spring:message
							code="vehicle_vehicle_add.make" /></label>
					<form:input path="make" class="form-control margin-bottom-15" />
					<form:errors path="make" />
					<label for="firstName" class="control-label"><spring:message
							code="vehicle_vehicle_add.model" /></label>
					<form:input path="model" class="form-control margin-bottom-15" />
					<form:errors path="model" />
					<label for="firstName" class="control-label"><spring:message
							code="vehicle_vehicle_add.model_year" /></label>
					<form:input path="modelyear" class="form-control margin-bottom-15" />
					<form:errors path="modelyear" />
					<label for="firstName" class="control-label"><spring:message
							code="vehicle_vehicle_add.funds" /></label>
					<form:input path="funds" class="form-control margin-bottom-15" />
					<form:errors path="funds" />
					<label for="firstName" class="control-label"><spring:message
							code="vehicle_vehicle_add.miles" /></label>
					<form:input path="miles" class="form-control margin-bottom-15" />
					<form:errors path="miles" />

					<button type="submit" class="btn btn-primary">
						<spring:message code="vehicle_vehicle_add.update" />
					</button>

				</form:form>

			</div>
		</div>

	</div>
</div>