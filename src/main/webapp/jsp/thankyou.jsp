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

    <jsp:include page="header_public.jsp"></jsp:include>

    <div class="container-fluid indigo-lighten-4 box-full py-5">
        <div class="row justify-content-center">
            <div class="col-10 indigo-lighten-5 shadow p-5 text-center">
                <p class="display-4">Welcome, <strong><s:property value="user.first_name" /></strong>!</p>
                <p class="lead">Your account has successfully created. Now you can login to Community Portal with your account.</p>
                <div class="mt-5">
                	<!-- <button id="send_mail" class="btn btn-indigo-accent-4">Resend Confirmation Mail <span
                            id="time"></span></button> -->
                  	<a href="<s:url action='login_page' />" class="btn btn-indigo-accent-4">Login To Community Portal</a>
                </div>
                <img src="./assets/img/High five-bro.svg" class="img-fluid" alt="" style="max-width: 400px;">
            </div>
        </div>
    </div>
    
    <jsp:include page="footer.jsp"></jsp:include>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="./assets/js/jquery-3.5.1.slim.min.js"></script>
    <script src="./assets/js/popper.min.js"></script>
    <script src="./assets/js/bootstrap.min.js"></script>

    <script src="./assets/js/confirm.js"></script>
</body>

</html>