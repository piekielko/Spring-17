<%@ include file="./includes/common.jsp" %>
<!--
author: mbartyzel
created: 2008-08-18 11:46:39
-->
<html>
<body>
	<h1>Add new entry to the PhoneBook</h1>
	<form:form modelAttribute="entry">
		<table border="1">
			<tr>
				<td><spring:message code="category.label" /></td>
				<td>
					<form:select path="category" items="${categories}"/>
				</td>
			</tr>

		</table>
		<hr />
		<table border="1">
			<tr>
				<td><spring:message code="name.label" /></td>
				<td>
					<form:input path="person.name" />
					<form:errors path="person.name"/>
				</td>
			</tr>
	
			<tr>
				<td><spring:message code="surname.label" /></td>
				<td>
					<form:input path="person.surname" />
					<form:errors path="person.surname"/>
				</td>
			</tr>
		</table>
		<hr />
		<table border="1">
			<tr>
				<td><spring:message code="street.label" /></td>
				<td>
					<form:input path="address.street" />
					<form:errors path="address.street"/>
				</td>
			</tr>
	
			<tr>
				<td><spring:message code="number.label" /></td>
				<td>
					<form:input path="address.number" />
					<form:errors path="address.number" />
				</td>
			</tr>
	
			<tr>
				<td><spring:message code="city.label" /></td>
				<td>
					<form:input path="address.city" />
					<form:errors path="address.city" />	
				</td>
			</tr>

			<tr>
				<td><spring:message code="postalCode.label" /></td>
				<td>
					<form:input path="address.postalCode" />
					<form:errors path="address.postalCode" />
				</td>
			</tr>
		</table>
		<hr />
		<table border="1">
			<tr>
				<td><spring:message code="phoneType.label" /></td>
				<td>
					<form:select path="phone.type" items="${phoneTypes}"/>
				</td>
			</tr>

			<tr>
				<td><spring:message code="countryNumber.label" /></td>
				<td>
					<form:input path="phone.countryNumber" />
					<form:errors path="phone.countryNumber" />
				</td>
			</tr>

			<tr>
				<td><spring:message code="areaNumber.label" /></td>
				<td>
					<form:input path="phone.areaNumber" />
					<form:errors path="phone.areaNumber" />
				</td>
			</tr>

			<tr>
				<td><spring:message code="phoneNumber.label" /></td>
				<td>
					<form:input path="phone.phoneNumber" />
					<form:errors path="phone.phoneNumber" />
				</td>
			</tr>
			
		</table>
		<hr />
		<table border="1">
			<tr>
				<td>
					<input type="submit" value="<spring:message code="submit.label" />" colspan="2" />
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>