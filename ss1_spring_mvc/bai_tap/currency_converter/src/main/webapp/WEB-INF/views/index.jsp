<%--
  Created by IntelliJ IDEA.
  User: lapto
  Date: 5/18/2023
  Time: 10:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h1 align="center">Currency Converter</h1>
<div class="container" style="margin-top: 50px">
    <div class="mb-3" style="display: flex;justify-content: center">
        <form action="/change" method="post" style="width: 50%">
            <h5 class="form-label">The amount (USD)</h5>
            <input class="form-control" type="number" name="usd" placeholder="Enter your number need change"><br>
            <div class="mt-4" style="display: flex;justify-content: center">
                <button class="btn btn-success" type="submit">Change</button>
            </div>
        </form>
    </div>
    <div class="mt-4 d-flex justify-content-center">
        <h3>Result: ${result} VND</h3>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
