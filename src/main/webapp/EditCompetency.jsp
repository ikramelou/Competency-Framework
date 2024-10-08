<%@ page import="esi.competencyframework.model.Competency" %>
<%@ page import="esi.competencyframework.model.Competency" %>
<%@ page import="esi.competencyframework.model.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="esi.competencyframework.dao.CategoryDAO" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
  <link rel="icon" href="icon/favicon.png">
  <title>Edit a competency</title>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
      <li class="nav-item">
        <a class="nav-link active" aria-current="page" href="ManageCompetency.jsp">Manage Competencies</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="ManageCategory.jsp">Manage Categories</a>
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
      <div class="card">
        <h2 class="text-center mt-1">Edit a competency</h2>
        <div class="card-body">
          <form action="${pageContext.request.contextPath}/EditCompetencyServlet" method="POST" class="was-validated">
            <% Competency competency = (Competency) request.getAttribute("competency");%>
            <input type="text" hidden="hidden" name="id" id="id" value="<%=competency.getId()%>">
            <div class="form-floating mb-3">
              <input type="text" class="form-control" id="name" name="name" placeholder="" maxlength="255" required
                     value="<%=competency.getName()%>">
              <label for="name">Competency name</label>
              <div class="invalid-feedback" id="invalid-name"></div>
            </div>
            <div class="form-floating mb-3">
              <textarea class="form-control" id="description" name="description" placeholder=""
                        required><%=competency.getDescription()%></textarea>
              <label for="description">Description</label>
              <div class="invalid-feedback" id="invalid-description"></div>
            </div>
            <div class="form-floating mb-3">
              <input type="text" class="form-control" id="domain" name="domain" placeholder="" required
                     value="<%=competency.getDomain()%>">
              <label for="domain">Domain</label>
              <div class="invalid-feedback" id="invalid-domain"></div>
            </div>
            <div class="form-floating mb-3">
              <select class="form-select" id="level" name="level" required>
                <option value="" disabled>Select a level</option>
                <option value="Beginner" <%=(competency.getLevel().equals("Beginner")) ? "selected" : ""%>>Beginner
                </option>
                <option value="Intermediate" <%=(competency.getLevel().equals("Intermediate")) ? "selected" : ""%>>
                  Intermediate
                </option>
                <option value="Advanced" <%=(competency.getLevel().equals("Advanced")) ? "selected" : ""%>>Advanced
                </option>
              </select>
              <label for="level">Level</label>
              <div class="invalid-feedback" id="invalid-level"></div>
            </div>
            <div class="form-floating mb-3">
              <select class="form-select" id="category" name="category" required>
                <option value="" disabled selected>Select a level</option>
                <% CategoryDAO categoryDAO = new CategoryDAO();
                  List<Category> categoryList = categoryDAO.getAllCategories();
                  if (!categoryList.isEmpty()) {
                    for (Category c : categoryList) {%>
                <option value=<%=c.getId()%>><%=c.getName()%>
                </option>
                <%
                    }
                  }
                %>
              </select>
              <label for="category">Category</label>
              <div class="invalid-feedback" id="invalid-category"></div>
            </div>
            <button type="submit" class="btn btn-success float-end">Edit Competency</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
<script src="bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="jquery/jquery.min.js"></script>
</body>
</html>
