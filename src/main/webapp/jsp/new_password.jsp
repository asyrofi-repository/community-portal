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

    <title>Change Password | ABC Jobs</title>
</head>

<body>

    <jsp:include page="header_public.jsp"></jsp:include>

    <div class="container-fluid indigo-lighten-4 box-full py-5">
        <div class="row justify-content-center">
            <div class="col-md-5 col-8 indigo-lighten-5 shadow p-5">
                <p class="display-4 text-center">Change Password</p>
                <hr>
                <form method="post" action="<s:url action='new_password' />">
                    <div class="form-group">
                        <label for="password">New Password</label>
                        <input type="password" class="form-control" id="password" required>
                    </div>
                    <div class="form-group">
                        <label for="repeat_password">Repeat New Password</label>
                        <input type="password" class="form-control" id="repeat_password" name="password"
                            required>
                        <div class="valid-feedback">Password Match</div>
                        <div id="err_msg" class="invalid-feedback">Password Mismatch !</div>
                    </div>
                    <button id="btn_submit" type="submit" class="btn btn-indigo-accent-4 btn-block mt-4">Change Password</button>
                </form>
            </div>
        </div>
    </div>
    
    <jsp:include page="footer.jsp"></jsp:include>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="./assets/js/jquery-3.5.1.slim.min.js"></script>
    <script src="./assets/js/popper.min.js"></script>
    <script src="./assets/js/bootstrap.min.js"></script>

    <script src="./assets/js/change-password.js"></script>
</body>

</html>