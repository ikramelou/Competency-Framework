<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
  <link rel="icon" href="icon/favicon.png">
  <title>Register</title>
</head>
<body>
<div class="container-fluid mt-4">
  <div class="row justify-content-center">
    <div class="col-sm-10 col-md-8 col-lg-6">
      <% String color = null;
        String message = null;
        if (request.getAttribute("success") != null) {
          color = "alert-success";
          message = (String) request.getAttribute("success");
        }
        if (request.getAttribute("error") != null) {
          color = "alert-danger";
          message = (String) request.getAttribute("error");
        }
        if (color != null) {
      %>
      <div class="<%=color%> alert alert-dismissible fade show" role="alert">
        <%= message %>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
      </div>
      <% }%>
      <div class="card">
        <h2 class="text-center mt-1">Register</h2>
        <div class="card-body">
          <form action="${pageContext.request.contextPath}/RegisterUserServlet" method="post" class="needs-validation">
            <div class="row">
              <div class="col-md-6">
                <div class="form-floating mb-3">
                  <input type="text" class="form-control" id="fname" name="fname" placeholder="">
                  <label for="fname">First name</label>
                  <div class="invalid-feedback" id="invalid-fname"></div>
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-floating mb-3">
                  <input type="text" class="form-control" id="lname" name="lname" placeholder="">
                  <label for="lname">Last name</label>
                  <div class="invalid-feedback" id="invalid-lname"></div>
                </div>
              </div>
            </div>
            <div class="form-floating mb-3">
              <input type="text" class="form-control" id="email" name="email" placeholder="">
              <label for="email">Email address</label>
              <div class="invalid-feedback" id="invalid-email"></div>
            </div>
            <div class="row">
              <div class="col-md-6">
                <div class="form-floating mb-3">
                  <input type="password" class="form-control" id="password1" name="password1" placeholder="">
                  <label for="password1">Password</label>
                  <div class="invalid-feedback" id="invalid-password1"></div>
                  <div class="form-text">
                    Your password must be 8-20 characters long, contain at least a letter, a numbers
                    and a special characters.
                  </div>
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-floating mb-3">
                  <input type="password" class="form-control" id="password2" placeholder="">
                  <label for="password2">Confirm password</label>
                  <div class="invalid-feedback" id="invalid-password2"></div>
                </div>
              </div>
            </div>
            <button type="submit" class="btn btn-primary float-end" id="button">Register</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
<script src="bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="jquery/jquery.min.js"></script>
<script src="js/register.js"></script>
</body>
</html>
