<%--
  Created by IntelliJ IDEA.
  User: ЗТЛ
  Date: 13.11.2019
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>User registration form</title>
</head>
<body>

<form:form action="processForm" modelAttribute="user">
    First Name: <form:input path="firstName"/>

    <br><br/>

    Last name: <form:input path="lastName"/>

    <br><br/>
    Country:    <form:select path="country">
                    <form:options items="${user.countryList}"/>
                </form:select>
    <br/>
    <input type="submit" value="Submit"/>
</form:form>

</body>
</html>
