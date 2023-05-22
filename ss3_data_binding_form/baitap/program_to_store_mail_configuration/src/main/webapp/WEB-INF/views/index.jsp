<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
</head>
<body>
<div align="center">
    <form:form method="post" modelAttribute="emailConfig" action="/save">
        <fieldset style="width: 30%">
            <legend align="10px"><h1>Settings</h1></legend>
            <table class="table table-success table-striped">
                <tr>
                    <td>Languages</td>
                    <td>
                        <form:select path="languages" items="${languagesList}"/>
                    </td>
                </tr>
                <tr>
                    <td>Page Size :</td>
                    <td>Show
                        <form:select path="pageSize" items="${pageSizeList}"/>
                        email per page
                    </td>
                </tr>
                <tr>
                    <td>Spams filter :</td>
                    <td>
                        <form:checkbox path="spamsFilter"/>
                        Enable spams filter
                    </td>
                </tr>
                <tr>
                    <td>Signature :</td>
                    <td>
                        <form:textarea path="signature"/>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td style="width: 100%; display: flex">
                        <button class="btn btn-sm btn-outline-primary" style="flex: 1">Update</button>
                        <button class="btn btn-sm btn-outline-warning" type="button" style="flex: 1"
                                onclick="window.location.href='/'">Cancel
                        </button>
                    </td>
                </tr>
            </table>
        </fieldset>
    </form:form>
</div>
</body>
</html>