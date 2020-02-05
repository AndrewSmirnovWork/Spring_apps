<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>

<head>
	<title>Company Home Page</title>
</head>

<body>
	<h2>Company Home Page</h2>
	<hr>
	
	Welcome to company home page!
	<p>
		User: <security:authentication property="principal.username"/>
	</p>
	<p>
		Role: <security:authentication property="principal.authorities"/>
	</p>
		<security:authorize access="hasRole('MANAGER')">
		<p>
			<a href="${pageContext.request.contextPath}/managers">Manager info</a>
		</p>
		</security:authorize>
		<security:authorize access="hasRole('ADMIN')">
		<p>
			<a href="${pageContext.request.contextPath}/systems">Admin(system) info</a>
		</p>
		</security:authorize>
	<hr>
	<form:form action="${pageContext.request.contextPath}/logout" method="post">
		<input type="submit" value="Logout"/>
	</form:form>

</body>

</html>