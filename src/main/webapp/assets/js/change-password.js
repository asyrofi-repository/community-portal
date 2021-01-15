$("document").ready(
  $("input[type='password']").keyup(function () {
    var rpassword = $("#repeat_password");
    var password = $("#password");
    var btn = $("#btn_submit");

    if (password.val() == "") {
      $("#err_msg").html("Password Empty !");
    } else {
      $("#err_msg").html("Password Mismatch !");
    }

    if (password.val() == rpassword.val() && password.val() != "") {
      rpassword.removeClass("is-invalid");
      rpassword.addClass("is-valid");
      btn.removeClass("disabled");
    } else {
      rpassword.removeClass("is-valid");
      rpassword.addClass("is-invalid");
      btn.addClass("disabled");
    }
  })
);
