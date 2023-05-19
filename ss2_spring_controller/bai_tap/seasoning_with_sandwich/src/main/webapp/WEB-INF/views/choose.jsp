<%--
  Created by IntelliJ IDEA.
  User: lapto
  Date: 5/19/2023
  Time: 10:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>The spices chosen are: </h3>
<c:forEach var="condiment" items="${condiment}">
    <p>- ${condiment}</p>
</c:forEach>
</body>
</html>
