<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Luck
  Date: 2/4/2020
  Time: 6:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
    <form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">

        <c:if test="${param.error != null}">
            <i>invalid username/password</i>
        </c:if>

        <c:if test="${param.logout != null}">
            <i>You have been logged out!</i>
        </c:if>


        <p>
        Username: <input type="text" name="username" placeholder="username"/>
        </p>
        <p>
        Password: <input type="password" name="password" placeholder="password"/>
        </p>
        <input type=submit value="Login"/>

    </form:form>

</body>
</html>
