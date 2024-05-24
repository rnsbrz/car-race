<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
<head>
    <title>Race Selector</title>
    <style>
        .error {
            color: red
        }
    </style>
    <jsp:include page="header.jsp"/>
</head>
<body>
<h2>Select two cars to race against each other</h2>

<form:form method="post" action="result" modelAttribute="race">

First car: <form:input type="race" path="car1"/>
<form:errors path="car1" cssClass="error"/><br><br>
First cars horse power: <form:input type="number" path="car1Hp"/>
<form:errors path="car1Hp" cssClass="error"/><br><br>

First car: <form:input type="race" path="car2"/>
<form:errors path="car2" cssClass="error"/><br><br>
First cars horse power: <form:input type="number" path="car2Hp"/>
<form:errors path="car2Hp" cssClass="error"/><br><br>

<p>
    <input type="submit" value="result">

    </form:form>
</body>
</html>
