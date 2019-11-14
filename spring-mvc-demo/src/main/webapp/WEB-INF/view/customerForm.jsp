<%--
  Created by IntelliJ IDEA.
  User: ЗТЛ
  Date: 14.11.2019
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Customer registration form</title>
    <style>
        .error{color: #ff2800}
    </style>
</head>
<body>
    <form:form action="processForm" modelAttribute="customer">
        First name <form:input path="firstName"/>
        <br><br>
        Last name<form:input path="lastName"/>
        <form:errors path="lastName" cssClass="error"/>
        <br><br>
        <input type="submit" value="Sumbit"/>
    </form:form>
</body>
</html>
