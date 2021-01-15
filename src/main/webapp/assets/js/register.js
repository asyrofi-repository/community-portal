var username_valid = true;
var password_valid = true;

$("document").ready(
  $("#username").keyup(function () {
    var username = $(this);
    var usr_msg = $("#usr_msg");
    var patt = /[^\w]+/g;
    var msg = "";
    if (username.val().length < 4) {
      msg = "The username must has 4 minimal characters";
      username_valid = false;
      usr_msg.html(msg);
      username.addClass("is-invalid");
      $("#btn_submit").prop("disabled", true);
    } else {
      if (patt.test($(username).val())) {
        msg = "The username can only contains a-z, A-Z, 0-9, and underscore";
        username_valid = false;
        usr_msg.html(msg);
        username.addClass("is-invalid");
        $("#btn_submit").prop("disabled", true);
      } else {
        msg = "";
        username_valid = true;
        usr_msg.html(msg);
        username.removeClass("is-invalid");
        check_valid(username_valid, password_valid);
      }
    }
  }),

  $("#password").keyup(function () {
    var password = $(this);
    var pwd_msg = $("#pwd_msg");
    var msg = "";
    if (password.val().length < 8) {
      msg = "The password must has 8 minimal characters";
      password_valid = false;
      pwd_msg.html(msg);
      password.addClass("is-invalid");
      $("#btn_submit").prop("disabled", true);
    } else {
      msg = "";
      password_valid = true;
      pwd_msg.html(msg);
      password.removeClass("is-invalid");
      check_valid(username_valid, password_valid);
    }
  })
);

function check_valid(username_valid, password_valid) {
    if(username_valid && password_valid){
        $("#btn_submit").prop("disabled", false);
    }
}