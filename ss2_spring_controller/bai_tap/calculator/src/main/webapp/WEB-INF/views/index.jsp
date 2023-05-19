<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Calculator</h1>
<form if="calculate" action="/calculate" method="post">
    <div style="margin-top: 10px">
        <input type="number" class="form-control" id="number1" placeholder="Enter the first number" name="number1">
        <input type="number" class="form-control" id="number2" placeholder="Enter the first number" name="number2">
    </div>
    <div style="margin-top: 10px">
        <button type="submit" name="math" value="Addition">Addition(+)</button>
        <button type="submit" name="math" value="Subtraction">Subtraction(-)</button>
        <button type="submit" name="math" value="Multiplication">Multiplication(X)</button>
        <button type="submit" name="math" value="Division">Division(/)</button>
    </div>
</form>

<c:if test="${result != null}">
    <div class="mb-3">
        <p>${result}</p>
    </div>
</c:if>
</body>
</html>