package esi.competencyframework.servlet;

import esi.competencyframework.dao.CategoryDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;

@WebServlet(name = "DeleteCategoryServlet", value = "/DeleteCategoryServlet")
public class DeleteCategoryServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }

  @SneakyThrows
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int id = Integer.parseInt(request.getParameter("delete"));
    CategoryDAO categoryDAO = new CategoryDAO();
    categoryDAO.deleteCategory(id);
    request.setAttribute("success", "The category has been deleted successfully!");
    RequestDispatcher dispatcher = request.getRequestDispatcher("ManageCategory.jsp");
    dispatcher.forward(request, response);
  }
}
