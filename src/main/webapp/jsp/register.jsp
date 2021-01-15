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

  <title>Register | ABC Jobs</title>
</head>

<body>

  <jsp:include page="header_public.jsp"></jsp:include>

  <div class="container-fluid indigo-lighten-4 box-full py-5">
    <div class="row justify-content-center">
      <div class="col-10 indigo-lighten-5 shadow">
        <div class="row align-items-center p-3">
          <div class="col-md-6">
            <img src="./assets/img/Version control-amico.svg" class="img-fluid" alt="">
          </div>
          <div class="col-md-6">
            <p class="display-4 text-center">Account Registration</p>
            <hr>
            <s:if test="%{errMsg != null}">
    			<div class="alert alert-danger alert-dismissible fade show" role="alert">
  				<s:if test="errMsg == 'err_username'">Username has been used !</s:if>
  				<s:elseif test="errMsg == 'err_email'">Email has been used !</s:elseif>
  				<s:elseif test="errMsg == 'err_insert'">Register Failed, Please Try Again !</s:elseif>
  				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
    				<span aria-hidden="true">&times;</span>
  				</button>
				</div>
			</s:if>
            <form action="<s:url action='register' />" method="post">
              <div class="form-row">
                <div class="form-group col-md-6">
                  <label for="first_name">First Name <span class="text-danger">*</span></label>
                  <input type="text" class="form-control" id="first_name" name="user.first_name" value="<s:property value='user.first_name' />" required>
                </div>
                <div class="form-group col-md-6">
                  <label for="last_name">Last Name</label>
                  <input type="text" class="form-control" id="last_name" name="user.last_name" value="<s:property value='user.last_name' />" placeholder="( Optional )">
                </div>
              </div>
              <div class="form-group">
                <label for="username">Username <span class="text-danger">*</span></label>
                <div class="input-group mb-2">
                  <div class="input-group-prepend">
                    <div class="input-group-text">@</div>
                  </div>
                  <input type="text" class="form-control" id="username" name="user.username" value="<s:property value='user.username' />" required>
                  <div id="usr_msg" class="invalid-feedback"></div>
                </div>
              </div>
              <div class="form-group">
                <label for="email">Email <span class="text-danger">*</span></label>
                <input type="email" class="form-control" id="email" name="user.email" value="<s:property value='user.email' />" required>
              </div>
              <div class="form-group">
                <label for="password">Password <span class="text-danger">*</span></label>
                <input type="password" class="form-control" id="password" name="user.password" value="<s:property value='user.password' />" required>
                <div id="pwd_msg" class="invalid-feedback"></div>
              </div>
              <div class="form-group">
                <label for="gender">Gender <span class="text-danger">*</span></label>
                <select id="gender" name="user.gender" class="form-control" required>
                  <option value="" disabled selected>Choose Gender</option>
                  <option value="Male">Male</option>
                  <option value="Female">Female</option>
                </select>
              </div>
              <div class="form-row">
                <div class="form-group col-md-6">
                  <label for="birth_place">Birth Place <span class="text-danger">*</span></label>
                  <input type="text" class="form-control" id="birth_place" name="user.birth_place" value="<s:property value='user.birth_place' />" required>
                </div>
                <div class="form-group col-md-6">
                  <label for="birth_date">Birth Date <span class="text-danger">*</span></label>
                  <input type="date" class="form-control" id="birth_date" name="user.birth_date" value="<s:property value='user.birth_date' />" required>
                </div>
              </div>
              <div class="form-row">
                <div class="form-group col-md-6">
                  <label for="city">City <span class="text-danger">*</span></label>
                  <input type="text" class="form-control" id="city" name="user.city" value="<s:property value='user.city' />" required>
                </div>
                <div class="form-group col-md-6">
                  <label for="country">Country <span class="text-danger">*</span></label>
                  <input type="text" class="form-control" id="country" name="user.country" value="<s:property value='user.country' />" required>
                </div>
              </div>
              <div class="form-group">
                <div class="form-check">
                  <input class="form-check-input" type="checkbox" id="check_data" required>
                  <label class="form-check-label text-muted" for="check_data">
                    I have checked all given information <span class="text-danger">*</span>
                  </label>
                </div>
              </div>
              <button id="btn_submit" type="submit" class="btn btn-indigo-accent-4 btn-block">Register an
                Account</button>
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

  <script src="./assets/js/register.js"></script>
</body>

</html>