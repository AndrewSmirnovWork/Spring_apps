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
    <br><br/>
    
    Favorite Programming Language:<br/>
    Java <form:radiobutton path="favoriteLanguage" value="Java"/>
    C#<form:radiobutton path="favoriteLanguage" value="C#"/>
    PHP<form:radiobutton path="favoriteLanguage" value="PHPH"/>
    Ruby<form:radiobutton path="favoriteLanguage" value="Ruby"/>
    <br><br/>

    Operation systems:

    Linux <form:checkbox path="operatingSystems" value="Linux"/>
    Windows <form:checkbox path="operatingSystems" value="Windows"/>
    Mac OS <form:checkbox path="operatingSystems" value="Mac OS"/>
    <br><br/>
    
    <input type="submit" value="Submit"/>
</form:form>

</body>
</html>
