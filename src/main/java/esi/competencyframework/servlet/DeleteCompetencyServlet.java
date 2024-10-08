package esi.competencyframework.servlet;

import esi.competencyframework.dao.CompetencyDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;

@WebServlet(name = "DeleteCompetencyServlet", value = "/DeleteCompetencyServlet")
public class DeleteCompetencyServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }

  @SneakyThrows
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int id = Integer.parseInt(request.getParameter("delete"));
    CompetencyDAO competencyDAO = new CompetencyDAO();
    competencyDAO.removeCompetency(id);
    request.setAttribute("success", "The competency has been deleted successfully!");
    RequestDispatcher dispatcher = request.getRequestDispatcher("ManageCompetency.jsp");
    dispatcher.forward(request, response);
  }
}
