<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>

<head>
    <title>Race Update</title>
    <jsp:include page="header.jsp"/>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>
<div class="container-fluid">
    <div class="row justify-content-center">
        <div class="col">
            <div class="form-container">
                <h2 class="text-center">Race Update</h2>

                <form:form modelAttribute="number" action="updateR" method="post" class="needs-validation">

                    <div class="form-group">
                        <label for="id">Race ID:</label>
                        <input type="race" class="form-control" id="id" name="id" value="${race.id}" required>
                        <div class="invalid-feedback">Please provide a valid race ID.</div>
                    </div>

                    <div class="form-group">
                        <label for="car1">First Car:</label>
                        <input type="race" class="form-control" id="car1" name="car1" value="${race.car1}"
                               required>
                        <div class="invalid-feedback">Please provide a valid car.</div>
                    </div>

                    <div class="form-group">
                        <label for="car1Hp">First Cars HP:</label>
                        <input type="race" class="form-control" id="car1Hp" name="car1Hp" value="${race.car1Hp}"
                               required>
                        <div class="invalid-feedback">Please provide valid horse power.</div>
                    </div>

                    <div class="form-group">
                        <label for="car2">Second Car:</label>
                        <input type="race" class="form-control" id="car2" name="car2" value="${race.car2}"
                               required>
                        <div class="invalid-feedback">Please provide a valid car.</div>
                    </div>

                    <div class="form-group">
                        <label for="car2Hp">Second Cars HP:</label>
                        <input type="race" class="form-control" id="car2Hp" name="car2Hp" value="${race.car2Hp}"
                               required>
                        <div class="invalid-feedback">Please provide valid horse power.</div>
                    </div>

                    <div class="form-group">
                        <label for="result">Result:</label>
                        <input type="text" class="form-control" id="result" name="result" value="${race.result}"
                               required>
                        <div class="invalid-feedback">Please provide a valid result.</div>
                    </div>

                    <button type="submit" class="btn btn-primary btn-block">Update Race</button>

                </form:form>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>

</html>
