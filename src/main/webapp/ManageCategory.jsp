<%@ page import="java.util.List" %>
<%@ page import="esi.competencyframework.dao.CategoryDAO" %>
<%@ page import="esi.competencyframework.model.Category" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="bootstrap/css/bootstrap-icons.min.css">
  <link rel="icon" href="icon/favicon.png">
  <title>Manage Category</title>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
      <li class="nav-item">
        <a class="nav-link" aria-current="page" href="ManageCompetency.jsp">Manage Competencies</a>
      </li>
      <li class="nav-item">
        <a class="nav-link active" href="ManageCategory.jsp">Manage Categories</a>
      </li>
    </ul>
    <div class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
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
        <h2 class="text-center mt-1">Add a category</h2>
        <div class="card-body">
          <form action="${pageContext.request.contextPath}/AddCategoryServlet" method="POST" class="was-validated">
            <div class="form-floating mb-3">
              <input type="text" class="form-control" id="name" name="name" placeholder="" maxlength="255" required>
              <label for="name">Category name</label>
              <div class="invalid-feedback" id="invalid-name"></div>
            </div>
            <button type="submit" class="btn btn-success float-end">Add Category</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
<div class="container-fluid mt-4">
  <div class="card">
    <h2 class="text-center mt-1">Category list</h2>
    <div class="card-body">
      <% CategoryDAO categoryDAO = new CategoryDAO();
        List<Category> categoryList = categoryDAO.getAllCategories();
        if (categoryList.isEmpty()) {%>
      <h3>No categories</h3>
      <%} else { %>
      <table class="table table-striped">
        <thead>
        <tr>
          <th class="col-10">Name</th>
          <th class="col-2"></th>
        </tr>
        </thead>
        <tbody>
          <% for (Category c : categoryList){%>
        <tr>
          <td><%=c.getName()%>
          </td>
          <td>
            <form class="float-end px-1" action="${pageContext.request.contextPath}/EditCategoryServlet"
                  method="post">
              <input
                  name="edit" hidden="hidden" value="<%=c.getId()%>">
              <button class="btn p-0" type="submit"><i class="bi bi-pencil-square" style="color: blue"></i></button>
            </form>
            <form class="float-end px-1" action="${pageContext.request.contextPath}/DeleteCategoryServlet"
                  method="post" onsubmit="return confirm('Are you sure you want to delete this category?');">
              <input
                  name="delete" hidden="hidden" value="<%=c.getId()%>">
              <button class="btn p-0" type="submit"><i class="bi bi-trash-fill" style="color: red"></i></button>
            </form>
          </td>
        </tr>
          <% }}%>
    </div>
  </div>
</div>
<script src="bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="jquery/jquery.min.js"></script>
</body>
</html>
