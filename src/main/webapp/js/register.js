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
$("#fname").on("keyup", function () {
  if ($(this).val().length < 3) {
    $(this).removeClass("is-valid")
    $(this).addClass("is-invalid")
    $("#invalid-fname").text("Please input a valid name!")
  } else {
    $(this).removeClass("is-invalid")
    $(this).addClass("is-valid")
  }
})
$("#lname").on("keyup", function () {
  if ($(this).val().length < 3) {
    $(this).removeClass("is-valid")
    $(this).addClass("is-invalid")
    $("#invalid-lname").text("Please input a valid name!")
  } else {
    $(this).removeClass("is-invalid")
    $(this).addClass("is-valid")
  }
})
$("#password1").on("keyup", function () {
  if (!validatePassword($(this).val())) {
    $(this).removeClass("is-valid")
    $(this).addClass("is-invalid")
    $("#invalid-password1").text("Password does not meet complexity requirements!")
  } else {
    $(this).removeClass("is-invalid")
    $(this).addClass("is-valid")
  }
})
$("#password2").on("keyup", function () {
  if ($(this).val().localeCompare($("#password1").val())) {
    $(this).removeClass("is-valid")
    $(this).addClass("is-invalid")
    $("#invalid-password2").text("Passwords do not match!")
  } else {
    $(this).removeClass("is-invalid")
    $(this).addClass("is-valid")
  }
})

function validateEmail(email) {
  const emailRegex = new RegExp("^([a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,})$");
  return (emailRegex.test(email));
}

function validatePassword(password) {
  const passwordRegex = new RegExp("^(?=.*[a-zA-ZàâæáäãåāéèêëęėēûùüúūîïìíįīôœöòóõÀÂÆÁÄÃÅĀÉÈÊËĘĖĒÛÙÜÚŪÎÏÌÍĮĪÔŒÖÒÓÕ](?=.*\\d)(?=.*[!@#$%^&*()\\-_=+{};:,<.>])).{8,20}$");
  return (passwordRegex.test(password))
}
