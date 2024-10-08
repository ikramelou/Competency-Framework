<!DOCTYPE html>
<html lang="en">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
  <link rel="icon" href="icon/favicon.png">
  <title>Edit profile</title>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
      <li class="nav-item">
        <a class="nav-link" aria-current="page" href="ManageCompetency.jsp">Manage Competencies</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="ManageCategory.jsp">Manage Categories</a>
      </li>
    </ul>
    <div class="nav-item dropdown">
      <a class="nav-link active dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
        My account
      </a>
      <ul class="dropdown-menu">
        <li><a class="dropdown-item" href="EditAccount.jsp">Edit info</a></li>
        <li>
          <form action="${pageContext.request.contextPath}/LogoutServlet" method="post">
            <button class="dropdown-item submit">Logout</button>
          </form>
        </li>
      </ul>
    </div>
  </div>
</nav>
<main class="container-fluid pt-5 justify-content-center mt-6">
  <div class="row gutters-md justify-content-center">
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
    <div class="col-md-6 col-xl-5 mb-3">
      <div class="card w-100 h-100">
        <div class="card-body">
          <h5 class="text-center mb-4">Change your email address</h5>
          <form action="${pageContext.request.contextPath}/EditEmailServlet" method="post" class="needs-validation">
            <div class="form-floating mb-3">
              <input autocomplete="off" type="text" class="form-control" name="email" id="email" placeholder="" required
                     value="<%= (String) session.getAttribute("email")%>"/>
              <label class="lab" for="email">New email address</label>
              <div class="invalid-feedback" id="invalid-email"></div>
            </div>
            <div class="form-floating mb-4">
              <input autocomplete="off" type="password" class="form-control" id="password" name="password"
                     placeholder="" required
                     value="">
              <label class="lab" for="password">Your password</label>
            </div>
            <br/>
            <br/>
            <div class="text-center ">
              <button type="submit" class="btn btn-success ">Submit</button>
            </div>
          </form>
        </div>
      </div>
    </div>
    <div class="col-md-6 col-xl-5 mb-3">
      <div class="card w-100 h-100">
        <div class="card-body">
          <h5 class="text-center mb-4">Edit your password</h5>
          <form action="${pageContext.request.contextPath}/EditPasswordServlet" method="post" class="needs-validation">
            <div class="form-floating mb-3">
              <input autocomplete="off" type="password" class="form-control" name="opassword" placeholder="" required
                     value="" id="opassword">
              <label class="lab" for="opassword">Old password</label>
            </div>
            <div class="form-floating mb-4">
              <input autocomplete="off" type="password" class="form-control" name="npassword" placeholder="" required
                     value="" id="npassword">
              <label class="lab" for="npassword">New password</label>
              <div class="invalid-feedback" id="invalid-npassword"></div>
              <div class="form-text">
                Your password must be 8-20 characters long, contain at least a letter, a numbers
                and a special characters.
              </div>
            </div>
            <div class="text-center">
              <button type="submit" class="btn btn-success ">Submit</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</main>
<script src="bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="jquery/jquery.min.js"></script>
<script src="js/edit.js"></script>
</body>
</html>
