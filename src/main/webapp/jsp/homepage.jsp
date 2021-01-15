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

    <title>Homepage | ABC Jobs</title>
</head>

<body>

    <jsp:include page="header_public.jsp"></jsp:include>

    <div class="container-fluid indigo-lighten-4 box-full py-5">
        <div class="row justify-content-center">
            <div class="col-md-11 col-10 indigo-lighten-5 shadow">
                <div class="row align-items-center p-5">
                    <div class="col-md-6">
                        <p class="display-4 text-center">Connect, Discuss, &amp; Find Job !</p>
                        <hr>
                        <p class="text-justify homedesc">
                            <strong>ABC Jobs Portal</strong> is a global community portal to connect people arround the
                            world to discuss, send message, and find job opportunity.
                        </p>
                        <a href="<s:url action='login_page' />" class="btn btn-indigo-accent-4 my-2">Connect to Our Community</a>
                    </div>
                    <div class="col-md-6">
                        <img src="./assets/img/Working remotely-pana.svg" class="img-fluid" alt="">
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