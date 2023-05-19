<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h1 align="center">Dictionary</h1>
<div class="container">
    <div class="mb-3" style="display: flex;justify-content: center">
        <form action="/translate" method="post" style="width: 50%">
            <h4 class="form-label">Enter the word you want to translate</h4>
            <input class="form-control" type="text" name="text" value="${text}"><br>
            <div class="mt-4" style="display: flex;justify-content: center">
                <button class="btn btn-success" type="submit">Translate</button>
            </div>
        </form>
    </div>
    <div class="mt-4 d-flex justify-content-center">
        <h3>Result: ${vietnamese}</h3>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>