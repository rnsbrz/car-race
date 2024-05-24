<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">

<head>
    <title>All races</title>
    <jsp:include page="header.jsp"/>
</head>

<body class="container">
<div class="table-responsive">
    <table class="table table-striped">
        <tr>
            <th>First car</th>
            <th>First cars horse power</th>
            <th>Second car</th>
            <th>Seconds cars horse power</th>
            <th>Result</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="race" items="${races}">

            <!-- Construct address for number updating by id -->
            <c:url var="updateRace" value="/updateRace">
                <c:param name="id" value="${race.id}"/>
            </c:url>

            <!-- Construct number deletion address by id -->
            <c:url var="delete" value="/delete">
                <c:param name="id" value="${race.id}"/>
            </c:url>

            <!-- Construct number show address by id -->
            <c:url var="showRace" value="/showRace">
                <c:param name="id" value="${race.id}"/>
            </c:url>

            <tr>
                <td>${race.car1}</td>
                <td>${race.car1Hp}</td>
                <td>${race.car2}</td>
                <td>${race.car2Hp}</td>
                <td>${race.result}</td>


                <td>

                    <a href="${updateRace}">Change</a> |
                    <a href="${delete}"
                       onclick="if (!(confirm('Do you want to delete this?'))) return false">Delete</a> |
                     <a href="${showRace}">Show</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>

</html>
