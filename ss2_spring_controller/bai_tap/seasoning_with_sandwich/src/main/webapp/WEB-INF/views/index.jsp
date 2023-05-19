<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/save" method="post">
    <span><input type="checkbox" id="lettuce" name="condiment" value="Lettuce">Lettuce</span>
    <span><input type="checkbox" id="tomato" name="condiment" value="Tomato">Tomato</span>
    <span><input type="checkbox" id="mustard" name="condiment" value="Mustard">Mustard</span>
    <span><input type="checkbox" id="sprouts" name="condiment" value="Sprouts">Sprouts</span>
    <hr>
    <input type="submit" value="Save" id="save">
</form>
</body>
</html>