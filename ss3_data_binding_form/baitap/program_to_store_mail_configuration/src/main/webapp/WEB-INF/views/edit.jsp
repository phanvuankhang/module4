<%--
  Created by IntelliJ IDEA.
  User: lapto
  Date: 5/22/2023
  Time: 11:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Result</h3><br>
<h4>Languages: ${emailConfig.getLanguages()}</h4>
<h4>Page Size: ${emailConfig.getPageSize()}</h4>
<span>Spam Filter: <c:if test="${emailConfig.isSpamsFilter()==true}">
    <span>Spams Filter</span>
</c:if></span>
<h4>Signature: ${emailConfig.getSignature()}</h4>
</body>
</html>
