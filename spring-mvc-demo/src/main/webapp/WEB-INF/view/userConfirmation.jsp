<%--
  Created by IntelliJ IDEA.
  User: ЗТЛ
  Date: 14.11.2019
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <title>User page</title>
</head>
<body>
User is confirmed: ${user.firstName} ${user.lastName}
<br><br/>
Country: ${user.country}
<br><br/>
User's favorite language: ${user.favoriteLanguage}
<br><br/>
Operating systems:
<ul><c:forEach var="temp" items="${user.operatingSystems}">
    <li>${temp}</li>
    </c:forEach>
</ul>
<br><br/>


<a href="/user/showForm">to User form</a>
</body>
</html>
