<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="./assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="./assets/css/style.css">

    <title>Welcome | ABC Jobs</title>
</head>

<body>

    <jsp:include page="header_login.jsp"></jsp:include>

    <div class="container-fluid indigo-lighten-4 box-full py-5">
        <div class="row justify-content-center">
            <div class="col-md-9 col-10 indigo-lighten-5 shadow">
                <div class="row align-items-center p-5">
                    <div class="col-md-6">
                        <p class="display-4">Welcome back,<br><strong><s:property value="#session.username" /></strong> !</p>
                    </div>
                    <div class="col-md-6">
                        <img src="./assets/img/High five-bro.svg" class="img-fluid" alt="">
                    </div>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="footer.jsp"></jsp:include>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="./assets/js/jquery-3.5.1.slim.min.js"></script>
    <script src="./assets/js/popper.min.js"></script>
    <script src="./assets/js/bootstrap.min.js"></script>
</body>

</html>