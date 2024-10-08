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

@WebServlet(name = "AddCategoryServlet", value = "/AddCategoryServlet")
public class AddCategoryServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  }

  @SneakyThrows
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String name = request.getParameter("name");
    Category category = new Category(name);


    CategoryDAO categoryDAO = new CategoryDAO();
    categoryDAO.addCategory(category);
    request.setAttribute("success", "The category has been added successfully!");

    RequestDispatcher dispatcher = request.getRequestDispatcher("ManageCategory.jsp");
    dispatcher.forward(request, response);
  }
}
