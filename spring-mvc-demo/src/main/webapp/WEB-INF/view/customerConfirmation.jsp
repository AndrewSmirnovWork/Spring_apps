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
    <title>Customer confirmation</title>

</head>
<body>
   The customer is confirmed: ${customer.lastName} ${customer.firstName}
   <br><br/>
   Free passes: ${customer.freePasses}
   <br><br/>
   Postal code: ${customer.postalCode}
   <br><br/>
   Course code: ${customer.courseCode}
</body>
</html>
