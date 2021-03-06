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
                <s:if test="%{errMsg == 'err_username'}">
    			<div class="alert alert-danger alert-dismissible fade show" role="alert">
    			Username not registered !
  				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
    				<span aria-hidden="true">&times;</span>
  				</button>
				</div>
				</s:if>
				<s:elseif test="%{errMsg == 'err_token'}">
    			<div class="alert alert-danger alert-dismissible fade show" role="alert">
    			Your Reset Password Link Was Expired !
  				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
    				<span aria-hidden="true">&times;</span>
  				</button>
				</div>
				</s:elseif>
				<s:elseif test="%{errMsg == 'success'}">
    			<div class="alert alert-success alert-dismissible fade show" role="alert">
  				The Link has Sent to Your Email !
  				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
    				<span aria-hidden="true">&times;</span>
  				</button>
				</div>
				</s:elseif>
                <form action="<s:url action='send_password_link' />" method="post">
                    <div class="form-group">
                        <label for="username">Username</label>
                        <input type="text" class="form-control" id="username" name="username" value="<s:property value='username' />" placeholder="Enter your username" required>
                    </div>
                    <button id="btn_submit" type="submit" class="btn btn-indigo-accent-4 btn-block mt-4">Send Change Password Link</button>
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
</body>

</html>