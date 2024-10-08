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
    <div class="col-sm-10 col-md-8 col-lg-4">
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
        <h2 class="text-center mt-1">Login</h2>
        <div class="card-body">
          <form action="${pageContext.request.contextPath}/LoginServlet" method="post" class="needs-validation"
                novalidate>

            <div class="form-floating mb-3">
              <input type="text" class="form-control" id="email" name="email" placeholder="">
              <label for="email">Email address</label>
              <div class="invalid-feedback" id="invalid-email"></div>
            </div>
            <div class="form-floating mb-3">
              <input required type="password" class="form-control" id="password" name="password" placeholder="">
              <label for="password">Password</label>
            </div>
            <div class="mb-3">
              <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked>
              <label class="form-check-label" for="flexCheckChecked">
                Remember me
              </label>
            </div>


            <button type="submit" class="btn btn-primary float-end">Login</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
<script src="bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="jquery/jquery.min.js"></script>
<script src="js/login.js"></script>
</body>
</html>
