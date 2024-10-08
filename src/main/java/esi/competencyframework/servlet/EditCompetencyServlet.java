package esi.competencyframework.servlet;

import esi.competencyframework.dao.CategoryDAO;
import esi.competencyframework.dao.CompetencyDAO;
import esi.competencyframework.model.Category;
import esi.competencyframework.model.Competency;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;

@WebServlet(name = "EditCompetencyServlet", value = "/EditCompetencyServlet")
public class EditCompetencyServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }

  @SneakyThrows
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if (request.getParameter("edit") != null) {
      int id = Integer.parseInt(request.getParameter("edit"));
      CompetencyDAO competencyDAO = new CompetencyDAO();
      Competency competency = competencyDAO.getCompetencyByID(id);
      request.setAttribute("competency", competency);
      RequestDispatcher dispatcher = request.getRequestDispatcher("EditCompetency.jsp");
      dispatcher.forward(request, response);
    } else {
      int categoryID = Integer.parseInt(request.getParameter("category"));
      CategoryDAO categoryDAO = new CategoryDAO();
      Category category = categoryDAO.getCategoryById(categoryID);
      Competency competency = new Competency(Integer.parseInt(request.getParameter("id")), request.getParameter("name"), request.getParameter("description"), request.getParameter("domain"), request.getParameter("level"), category);
      CompetencyDAO competencyDAO = new CompetencyDAO();
      competencyDAO.editCompetency(competency);
      request.setAttribute("success", "The competency has been edited successfully!");
      RequestDispatcher dispatcher = request.getRequestDispatcher("ManageCompetency.jsp");
      dispatcher.forward(request, response);
    }
  }
}
