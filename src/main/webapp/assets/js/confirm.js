$("document").ready(
  $("#send_mail").click(function () {
    var btn = $(this);
    var number = 20;
    btn.prop("disabled", true);
    var downloadTimer = setInterval(function () {
      if (number <= 0) {
        $("#time").html("");
        btn.prop("disabled", false);
        clearInterval(downloadTimer);
      } else {
        $("#time").html("( " + number + " second )");
      }
      number -= 1;
    }, 1000);
  })
);