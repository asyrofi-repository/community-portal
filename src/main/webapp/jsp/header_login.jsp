<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark indigo-darken-4">
        <a class="navbar-brand" href="<s:url action='index' />">ABC Jobs</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
            	<s:if test="#session.role == 'Admin'">
            		<li class="nav-item">
                    	<a class="nav-link" href="<s:url action='admin_page' />">Admin</a>
                	</li>
            	</s:if>
                <li class="nav-item">
                    <a class="nav-link" href="<s:url action='profile_page' />">Profile</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<s:url action='search_user_page' />">Find User</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Settings
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="<s:url action='update_profile_page' />">Edit Profile</a>
                        <a class="dropdown-item" href="<s:url action='new_password_page' />">Change Password</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="<s:url action='logout' />">Logout</a>
                    </div>
                </li>
            </ul>
        </div>
    </nav>
    <!-- navbar-end -->