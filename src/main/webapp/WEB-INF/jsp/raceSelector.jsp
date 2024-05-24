<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
<head>
    <title>Race Selector</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 20px;
        }

        h2 {
            color: #333;
        }

        .form-group {
            margin-bottom: 15px;
        }

        .form-group label {
            display: block;
            margin-bottom: 5px;
        }

        .form-group input {
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            width: 100%;
            box-sizing: border-box;
        }

        .error {
            color: red;
            font-size: 0.9em;
        }

        .form-actions {
            margin-top: 15px;
        }

        .form-actions input {
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            background-color: #007bff;
            color: white;
            cursor: pointer;
        }

        .form-actions input:hover {
            background-color: #0056b3;
        }
    </style>
    <jsp:include page="header.jsp"/>
</head>
<body>
<h2>Select two cars to race against each other</h2>

<form:form method="post" action="result" modelAttribute="race">
    <div class="form-group">
        <label for="car1">First car:</label>
        <form:input path="car1" id="car1"/>
        <form:errors path="car1" cssClass="error"/>
    </div>

    <div class="form-group">
        <label for="car1Hp">First car's horse power:</label>
        <form:input type="number" path="car1Hp" id="car1Hp"/>
        <form:errors path="car1Hp" cssClass="error"/>
    </div>

    <div class="form-group">
        <label for="car2">Second car:</label>
        <form:input path="car2" id="car2"/>
        <form:errors path="car2" cssClass="error"/>
    </div>

    <div class="form-group">
        <label for="car2Hp">Second car's horse power:</label>
        <form:input type="number" path="car2Hp" id="car2Hp"/>
        <form:errors path="car2Hp" cssClass="error"/>
    </div>

    <div class="form-actions">
        <input type="submit" value="Result">
    </div>
</form:form>
</body>
</html>