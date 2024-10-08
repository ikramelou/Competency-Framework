$("#email").on("keyup", function () {
  if (!validateEmail($(this).val())) {
    $(this).removeClass("is-valid")
    $(this).addClass("is-invalid")
    $("#invalid-email").text("Please input a valid email address!")
  } else {
    $(this).removeClass("is-invalid")
    $(this).addClass("is-valid")
  }
})

function validateEmail(email) {
  const emailRegex = new RegExp("^([a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,})$");
  return (emailRegex.test(email));
}
