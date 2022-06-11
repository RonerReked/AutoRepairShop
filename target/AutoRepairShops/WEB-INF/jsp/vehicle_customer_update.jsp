<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="templatemo-content-wrapper">
	<div class="templatemo-content">

		<div class="row">
			<div class="col-md-9 margin-bottom-15">

				<form:form modelAttribute="customer" method="POST"
					action="${pageContext.servletContext.contextPath }/customers/handleUpdate">

					<form:hidden path="id" />

					<label for="firstName" class="control-label"><spring:message
							code="vehicle_customer_add.name" /></label>
					<form:input path="name" class="form-control margin-bottom-15" />
					<form:errors path="name" />
					<label for="firstName" class="control-label"><spring:message
							code="vehicle_customer_add.address" /></label>
					<form:input path="address" class="form-control margin-bottom-15" />
					<form:errors path="address" />
					<label for="firstName" class="control-label"><spring:message
							code="vehicle_customer_add.gender" /></label>
					<br />
					<form:radiobutton path="gender" value="Male" />
					<spring:message code="vehicle_customer_add.gender.male" />
					<form:radiobutton path="gender" value="Female" />
					<spring:message code="vehicle_customer_add.gender.female" />
					<br />
					<label for="contactdetails" class="control-label"><spring:message
							code="vehicle_customer_add.gender.contact_detail" /></label>
					<br>			
					<form:textarea rows="5" cols="20" path="contactdetails"
						class="form-control margin-bottom-15" />
				
					<form:errors path="contactdetails" />
					<label for="firstName" class="control-label"><spring:message
							code="vehicle_customer_add.age" /></label>
					<form:input path="age" class="form-control margin-bottom-15" />
					<form:errors path="age" />
					<button type="submit" class="btn btn-primary"><spring:message
							code="vehicle_customer_add.button.update" /></button>

				</form:form>

			</div>
		</div>

	</div>
</div>
