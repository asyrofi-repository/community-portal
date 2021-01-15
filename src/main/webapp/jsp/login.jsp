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

    <title>Login | ABC Jobs</title>
</head>

<body>

    <jsp:include page="header_public.jsp"></jsp:include>

    <div class="container-fluid indigo-lighten-4 box-full py-5">
        <div class="row justify-content-center">
            <div class="col-md-8 col-10 indigo-lighten-5 shadow">
                <div class="row align-items-center p-5">
                    <div class="col-md-6">
                        <img src="./assets/img/Working remotely-pana.svg" class="img-fluid" alt="">
                    </div>
                    <div class="col-md-6">
                        <p class="display-4 text-center">Login to Portal</p>
                        <hr>
                        <s:if test="errMsg == 'err_login'">
			    			<div class="alert alert-danger alert-dismissible fade show" role="alert">
				  				Invalid Username or Password !
				  				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				    				<span aria-hidden="true">&times;</span>
				  				</button>
							</div>
						</s:if>
						<s:if test="errMsg == 'err_disabled'">
			    			<div class="alert alert-danger alert-dismissible fade show" role="alert">
				  				Your Account has Disabled, Please Contact Admin !
				  				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				    				<span aria-hidden="true">&times;</span>
				  				</button>
							</div>
						</s:if>
						<s:elseif test="errMsg == 'password_updated'">
			    			<div class="alert alert-success alert-dismissible fade show" role="alert">
				  				Password Successfully Updated !
				  				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				    				<span aria-hidden="true">&times;</span>
				  				</button>
							</div>
						</s:elseif>
                        <form action="<s:url action='login' />" method="post" >
                            <div class="form-group">
                                <label for="username">Username</label>
                                <input type="text" class="form-control" id="username" name="user.username" required>
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="password" class="form-control" id="password" name="user.password" required>
                            </div>
                            <button id="btn_submit" type="submit" class="btn btn-indigo-accent-4 btn-block mt-4">Login</button>
                            <a href="<s:url action='forgot_password_page' />" id="btn_submit" type="submit" class="btn btn-outline-dark btn-block">Forgot Password</a>
                        </form>
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