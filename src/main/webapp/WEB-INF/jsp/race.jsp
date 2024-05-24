<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Race</title>
    <jsp:include page="header.jsp"/>
</head>
<body class="container">
<div class="table-responsive">
    <caption>Race information</caption>
    <table class="table table-striped">
        <tr>
            <td><b>ID:</b></td>
            <td>${race.id}</td>
        </tr>

        <tr>
            <td><b>First Car:</b></td>
            <td>${race.car1}</td>
        </tr>

        <tr>
            <td><b>First Cars Horse Power:</b></td>
            <td>${race.car1Hp}</td>
        </tr>

        <tr>
            <td><b>Second Car:</b></td>
            <td>${race.car2}</td>
        </tr>

        <tr>
            <td><b>Second Cars Horse Power:</b></td>
            <td>${race.car2Hp}</td>
        </tr>

        <tr>
            <td><b>Result</b></td>
            <td>${race.result}</td>
        </tr>
    </table>
</div>
<br>
<a type="button" href="${pageContext.request.contextPath}/allNumbers" class="button">Back</a>
</body>
</html>
