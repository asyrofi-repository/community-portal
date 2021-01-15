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

    <title>Find User | ABC Jobs</title>
</head>

<body>

    <jsp:include page="header_login.jsp"></jsp:include>

    <div class="container-fluid indigo-lighten-4 box-full py-4">
        <div class="row justify-content-center">
            <div class="col-md-8 col-10 indigo-lighten-5 shadow">
                <div class="row p-3">
                    <div class="col-md-12">
                        <form method="post" action="<s:url action='search_user' />">
                            <div class="form-row">
                                <div class="col-md-2 my-1">
                                    <select class="form-control" name="key" id="exampleFormControlSelect1">
                                        <option value="name">Name</option>
                                        <option value="city">City</option>
                                        <option value="country">Country</option>
                                    </select>
                                </div>
                                <div class="col-md-8 my-1">
                                    <input type="text" name="search" class="form-control" placeholder="Search User">
                                </div>
                                <div class="col my-1">
                                    <button type="submit" class="btn btn-indigo-accent-4 btn-block">Search</button>
                                </div>
                            </div>
                        </form>
                        <s:if test="%{key != null}"><p class="mt-2"><s:property value="key"/> : <strong><s:property value="search"/></strong></p></s:if>
                        <hr>
                    </div>
                    <div class="col-md-12">
                    	<s:iterator value="users">
                    		<div class="row indigo-lighten-4 p-3 rounded-lg align-items-center my-2">
                            <div class="col-2">
                                <img src="data:image/jpg;base64,${photo}" class="img-thumbnail rounded" alt="" width=100>
                            </div>
                            <div class="col">
                                <p class="font-italic text-info m-0">@<s:property value="username" /></p>
                                <a href="<s:url action='profile_page'><s:param name='usr'>${username}</s:param></s:url>" class="h4 text-dark text-decoration-none"><s:property value="first_name" /></a>
                                <p class="m-0"><s:property value="city" />, <s:property value="country" /></p>
                            </div>
                        	</div>
                    	</s:iterator>
                        <!-- <p class="text-muted">No available result</p> -->
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