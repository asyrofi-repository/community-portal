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
            <li class="nav-item p-1">
                <a href="<s:url action='register_page' />"
                    class="btn btn-indigo-accent-4 btn-block mx-lg-3">Register</a>
            </li>
            <li class="nav-item p-1">
                <a href="<s:url action='login_page' />" class="btn btn-success btn-block mx-lg-3">Login</a>
            </li>
        </ul>
    </div>
</nav>
<!-- navbar-end -->