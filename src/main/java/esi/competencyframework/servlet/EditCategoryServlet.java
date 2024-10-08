package esi.competencyframework.servlet;

import esi.competencyframework.dao.CategoryDAO;
import esi.competencyframework.model.Category;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;

@WebServlet(name = "EditCategoryServlet", value = "/EditCategoryServlet")
public class EditCategoryServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }

  @SneakyThrows
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if (request.getParameter("edit") != null) {
      int id = Integer.parseInt(request.getParameter("edit"));
      CategoryDAO categoryDAO = new CategoryDAO();
      Category category = categoryDAO.getCategoryById(id);
      request.setAttribute("category", category);
      RequestDispatcher dispatcher = request.getRequestDispatcher("EditCategory.jsp");
      dispatcher.forward(request, response);
    } else {
      CategoryDAO categoryDAO = new CategoryDAO();
      Category category = new Category(Integer.parseInt(request.getParameter("id")), request.getParameter("name"));
      categoryDAO.updateCategory(category);
      request.setAttribute("success", "The category has been edited successfully!");
      RequestDispatcher dispatcher = request.getRequestDispatcher("ManageCategory.jsp");
      dispatcher.forward(request, response);
    }
  }
}
