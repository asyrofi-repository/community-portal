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

    <title>Profile | ABC Jobs</title>
</head>

<body>

    <jsp:include page="header_login.jsp"></jsp:include>

    <div class="container-fluid indigo-lighten-4 box-full py-3">
        <div class="row justify-content-around">
            <div class="col-md-3">
                <div class="row p-3">
                    <div class="col-md-12 indigo-lighten-5 shadow text-center p-4">
                        <img src="data:image/jpg;base64,${user.photo}" class="img-thumbnail rounded" alt="" width=150>
                        <!-- <p>
                            <span class="badge bg-warning text-white p-2 text-l">@asyrofii</span>
                        </p> -->
                        <p class="h4 mt-3"><s:property value="user.first_name" /> <s:property value="user.last_name" /></p>
                        <p class="font-italic text-info m-0">@<s:property value="user.username" /></p>
                        <hr>
                        <p class="h5">Basic Information</p>
                        <p class="m-0"><s:property value="user.gender" /></p>
                        <p class="m-0 font-italic"><s:property value="user.birth_place" />, <s:property value="user.birth_date" /></p>
                        <hr>
                        <p class="h5">Location</p>
                        <p><s:property value="user.city" /> - <s:property value="user.country" /></p>
                        <hr>
                        <p class="h5 mb-3">Skill</p>
                        <s:if test="%{skills.isEmpty()}">
                        		<p class="text-muted">No information added</p>
						</s:if>
						<s:else>
							<s:iterator value="skills">
	                        	<span class="badge badge-pill indigo-accent-4 text-white p-2 mt-1"><s:property value="skill_name" /></span>
	                        </s:iterator>
						</s:else>
                        
                        <hr>
                        <p class="h5">Email</p>
                        <p><s:property value="user.email" /></p>
                    </div>
                </div>
            </div>
            <div class="col-md-8">
                <div class="row p-3">
                    <div class="col-md-12 indigo-lighten-5 shadow">
                        <p class="h4 mt-3">Work History</p>
                        <hr>
                        <div class="row pb-3 px-3">
                        	<s:if test="%{workHistories.isEmpty()}">
                        		<p class="text-muted">No information added</p>
							</s:if>
							<s:else>
	                        	<s:iterator value="workHistories">
		                            <div class="col-md-12 indigo-lighten-4 py-2 my-2 rounded-lg">
		                                <p class="h5"><s:property value="start_year" /> - <s:property value="end_year" /></p>
		                                <p class="m-0"><s:property value="position" /> | <strong><s:property value="company" /></strong></p>
		                            </div>
	                        	</s:iterator>
							</s:else>
                        </div>
                        <!-- <p class="text-muted">No available information</p> -->
                    </div>
                    <div class="col-md-12 indigo-lighten-5 shadow mt-3">
                        <p class="h4 mt-3">Education</p>
                        <hr>
                        <div class="row pb-3 px-3">
                        	<s:if test="%{educations.isEmpty()}">
                        		<p class="text-muted">No information added</p>
							</s:if>
                        	<s:else>
	                        	<s:iterator value="educations">
		                            <div class="col-md-12 indigo-lighten-4 py-2 my-2 rounded-lg">
		                                <p class="h5"><s:property value="start_year" /> - <s:property value="end_year" /></p>
		                                <p class="m-0"><s:property value="major" /> | <strong><s:property value="school" /></strong></p>
		                            </div>
	                        	</s:iterator>
                        	</s:else>
                        </div>
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