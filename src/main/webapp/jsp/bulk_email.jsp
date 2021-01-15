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

    <title>Admin | ABC Jobs</title>
</head>

<body>

    <jsp:include page="header_login.jsp"></jsp:include>

    <div class="container-fluid indigo-lighten-4 box-full py-5">
        <div class="row justify-content-center">
            <div class="col-11 indigo-lighten-5 shadow p-3">
                <p class="display-4 text-center">Bulk Email Sender</p>
                <hr>
                <s:if test="msg == 'success'">
			    			<div class="alert alert-success alert-dismissible fade show" role="alert">
				  				Email Has Been Sent to All Receiver !
				  				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				    				<span aria-hidden="true">&times;</span>
				  				</button>
							</div>
						</s:if>
               <form action="<s:url action='bulk_email' />" method="post" >
                    <div class="form-group">
                      <label for="email">Email Receiver</label>
                      <input type="text" class="form-control" id="email" name="email" aria-describedby="emailHelp" placeholder="ex. abc@gmail.com,xyz@gmail.com">
                      <small id="emailHelp" class="form-text text-muted">Use comma ( , ) as separator to send to more than 1 receiver</small>
                    </div>
                    <div class="form-group">
                      <label for="subject">Subject</label>
                      <input type="text" class="form-control" id="subject" name="subject" placeholder="Enter email subject">
                    </div>
                    <div class="form-group">
                        <label for="content">Content</label>
                        <textarea class="form-control" id="content" name="content" rows="3"></textarea>
                      </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
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