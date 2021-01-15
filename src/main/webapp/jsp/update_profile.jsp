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

    <title>Edit Profile | ABC Jobss</title>
</head>

<body>

    <jsp:include page="header_login.jsp"></jsp:include>

    <div class="container-fluid indigo-lighten-4 box-full p-5">
        <div class="row justify-content-around">
            <div class="col-md-6 mt-2">
                <div class="row align-items-center">
                    <div class="col indigo-lighten-5 shadow p-3">
                        <p class="display-4 text-center">Update Profile</p>
                        <hr>
                        <form method="post" action="<s:url action='update_profile' />">
                            <div class="form-group">
                                <label for="photo">Profile Photo</label><br>
                                <img src="data:image/jpg;base64,${user.photo}" class="img-thumbnail rounded" alt="" width=100>
                                <button type="button" class="btn btn-primary" data-toggle="modal"
                                    data-target="#exampleModal">
                                    Change Profile Photo
                                </button>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="first_name">First Name <span class="text-danger">*</span></label>
                                    <input type="text" class="form-control" id="first_name" name="user.first_name"
                                        value="<s:property value='user.first_name' />" required>
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="last_name">Last Name</label>
                                    <input type="text" class="form-control" id="last_name" name="user.last_name"
                                        value="<s:property value='user.last_name' />" placeholder="( Optional )">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="username">Username <span class="text-danger">*</span></label>
                                <div class="input-group mb-2">
                                    <div class="input-group-prepend">
                                        <div class="input-group-text">@</div>
                                    </div>
                                    <input type="text" class="form-control" id="username"
                                        value="<s:property value='user.username' />" required disabled>
                                    <div id="usr_msg" class="invalid-feedback"></div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="email">
                                	Email <span class="text-danger">*</span>
                                </label>
                                <input type="email" class="form-control" id="email" name="user.email"
                                    value="<s:property value='user.email' />" required>
                            </div>
                            <div class="form-group">
                                <label for="gender">Gender <span class="text-danger">*</span></label>
                                <select id="gender" name="user.gender" class="form-control" required>
                                    <option selected>
                                        <s:property value='user.gender' />
                                    </option>
                                    <option>Male</option>
                                    <option>Female</option>
                                </select>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="birth_place">Birth Place <span class="text-danger">*</span></label>
                                    <input type="text" class="form-control" id="birth_place" name="user.birth_place"
                                        value="<s:property value='user.birth_place' />" required>
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="birth_date">Birth Date <span class="text-danger">*</span></label>
                                    <input type="date" class="form-control" id="birth_date" name="user.birth_date"
                                        value="<s:property value='user.birth_date' />" required>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="city">City <span class="text-danger">*</span></label>
                                    <input type="text" class="form-control" id="city" name="user.city"
                                        value="<s:property value='user.city' />" required>
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="country">Country <span class="text-danger">*</span></label>
                                    <input type="text" class="form-control" id="country" name="user.country"
                                        value="<s:property value='user.country' />" required>
                                </div>
                            </div>
                            <button id="btn_submit" type="submit" class="btn btn-indigo-accent-4 btn-block">Save
                                Changes</button>
                        </form>
                    </div>
                </div>
            </div>

            <!-- Modal -->
            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content indigo-lighten-5">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Change Profile Photo</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
	       					<form action="<s:url action='update_photo' />" method="post" enctype="multipart/form-data">
								<div class="form-group">
							    	<input type="file" class="form-control-file" name="userImage" id="exampleFormControlFile1">
								</div>
								<button id="btn_submit" type="submit" class="btn btn-indigo-accent-4 btn-block">Change Photo</button>
							</form>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-md-5">
                <div class="row">
                    <div class="col-md-12 indigo-lighten-5 shadow mt-2 p-3">
                        <h3>Skill</h3>
                        <hr>
                        <s:if test="msgSkill == 'err_skill'">
			    			<div class="alert alert-danger alert-dismissible fade show" role="alert">
				  				Can't add same skill !
				  				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				    				<span aria-hidden="true">&times;</span>
				  				</button>
							</div>
						</s:if>
                        <!-- <p class="text-muted">No Data Found</p> -->
                        <form action="<s:url action='add_skill' />">
                            <div class="form-row">
                                <div class="form-group col-9">
                                    <input type="text" class="form-control" id="skill" name="skill.skill_name"
                                        placeholder="Skill Name" required>
                                </div>
                                <div class="form-group col-3">
                                    <button id="btn_submit" type="submit"
                                        class="btn btn-indigo-accent-4 btn-block">Add</button>
                                </div>
                            </div>
                        </form>
                        <div class="row pb-3 px-3">
                        	<s:iterator value="skills">
                            <div class="col-md-12 indigo-lighten-4 py-2 my-2 rounded-lg">
                                <div class="row align-items-center">
                                    <div class="col-9">
                                        <p class=" font-weight-bold m-0"><s:property value="skill_name" /></p>
                                    </div>
                                    <div class="col-3">
                                        <a href="
                                        <s:url action="delete_skill">
    										<s:param name="skill.skill_id" value="skill_id" />
										</s:url>
                                        " class="btn btn-danger btn-block">Delete</a>
                                    </div>
                                </div>
                            </div>
                        		
                        	</s:iterator>
                        </div>
                    </div>
                    <div class="col-md-12 indigo-lighten-5 shadow mt-2 p-3">
                        <h3>Work History</h3>
                        <hr>
                        <!-- <p class="text-muted">No Data Found</p> -->
                        <form method="post" action="<s:url action='add_work_history' />">
                            <div class="form-row">
                                <div class="form-group col-md-12">
                                    <input type="text" class="form-control" id="position" name="work.position"
                                        placeholder="Position Name" required>
                                </div>
                                <div class="form-group col-md-12">
                                    <input type="text" class="form-control" id="company" name="work.company"
                                        placeholder="Company Name" required>
                                </div>
                                <div class="form-group col-md-6">
                                    <input type="number" class="form-control" id="start_year" name="work.start_year"
                                        placeholder="Start Year" min="1900" max="2999" required>
                                </div>
                                <div class="form-group col-md-6">
                                    <input type="number" class="form-control" id="end_year" name="work.end_year"
                                        placeholder="End Year" min="1900" max="2999" required>
                                </div>
                            </div>
                            <button id="btn_submit" type="submit" class="btn btn-indigo-accent-4 btn-block">Add</button>
                        </form>
                        <div class="row pb-3 px-3 mt-3">
                        	<s:iterator value="workHistories">
	                            <div class="col-md-12 indigo-lighten-4 py-2 my-2 rounded-lg">
	                                <div class="row align-items-center">
	                                    <div class="col-9">
	                                        <p class="h5"><s:property value="start_year" /> - <s:property value="end_year" /></p>
	                                        <p class="m-0"><s:property value="position" /> | <strong><s:property value="company" /></strong></p>
	                                    </div>
	                                    <div class="col-3">
	                                        <a href="
	                                        <s:url action="delete_work_history">
	                                        	<s:param name="work_id" value="work_id" />
	                                        </s:url>
	                                        " class="btn btn-danger btn-block">Delete</a>
	                                    </div>
	                                </div>
	                            </div>
                        	</s:iterator>
                        </div>
                    </div>
                    <div class="col-md-12 indigo-lighten-5 shadow mt-2 p-3">
                        <h3>Education</h3>
                        <hr>
                        <!-- <p class="text-muted">No Data Found</p> -->
                        <form method="post" action="<s:url action='add_education' />">
                            <div class="form-row">
                                <div class="form-group col-md-12">
                                    <input type="text" class="form-control" id="major" name="education.major"
                                        placeholder="Major Name" required>
                                </div>
                                <div class="form-group col-md-12">
                                    <input type="text" class="form-control" id="school" name="education.school"
                                        placeholder="School Name" required>
                                </div>
                                <div class="form-group col-md-6">
                                    <input type="number" class="form-control" id="start_year" name="education.start_year"
                                        placeholder="Start Year" min="1900" max="2999" required>
                                </div>
                                <div class="form-group col-md-6">
                                    <input type="number" class="form-control" id="end_year" name="education.end_year"
                                        placeholder="End Year" min="1900" max="2999" required>
                                </div>
                            </div>
                            <button id="btn_submit" type="submit" class="btn btn-indigo-accent-4 btn-block">Add</button>
                        </form>
                        <div class="row pb-3 px-3 mt-3">
                        	<s:iterator value="educations">
	                            <div class="col-md-12 indigo-lighten-4 py-2 my-2 rounded-lg">
	                                <div class="row align-items-center">
	                                    <div class="col-9">
	                                        <p class="h5"><s:property value="start_year" /> - <s:property value="end_year" /></p>
	                                        <p class="m-0"><s:property value="major" /> | <strong><s:property value="school" /></strong></p>
	                                    </div>
	                                    <div class="col-3">
	                                        <a href="
	                                        <s:url action="delete_education">
	                                        	<s:param name="education_id" value="education_id" />
	                                        </s:url>
	                                        " class="btn btn-danger btn-block">Delete</a>
	                                    </div>
	                                </div>
	                            </div>
                        	</s:iterator>
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

    <script src="./assets/js/register.js"></script>
</body>

</html>