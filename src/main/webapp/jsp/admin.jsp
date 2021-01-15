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
                <p class="display-4 text-center">Admin Panel</p>
                <hr>
                <p class="text-center"><a class="btn btn-primary my-2" href="<s:url action='bulk_email_page' />">Send Bulk Email</a></p>
                <div class="table-responsive">
                <table class="table table-striped">
                    <thead class="thead-dark">
                      <tr class="text-center">
                        <th scope="col">Username</th>
                        <th scope="col">Full Name</th>
                        <th scope="col">Email</th>
                        <th scope="col">Status</th>
                        <th scope="col">Action</th>
                      </tr>
                    </thead>
                    <tbody>
                      <s:iterator value="users">
                      	<tr>
                        <td><s:property value="username" /></td>
                        <td><s:property value="first_name" /></td>
                        <td><s:property value="email" /></td>
                        <td class="text-center"><s:property value="status" /></td>
                        <td class="text-center">
                            <a class="btn btn-info btn-sm mt-1" href="<s:url action="profile_page"><s:param name="usr"><s:property value="username" /></s:param></s:url>">See Profile</a>
                            <a class="btn btn-success btn-sm mt-1" href="<s:url action="update_status"><s:param name="username"><s:property value="username" /></s:param><s:param name="status">active</s:param></s:url>">Activate</a>
                            <a class="btn btn-danger btn-sm mt-1" href="<s:url action="update_status"><s:param name="username"><s:property value="username" /></s:param><s:param name="status">disabled</s:param></s:url>">Disable</a>
                        </td>
                      </tr>
                      </s:iterator>
                    </tbody>
                  </table>
            
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