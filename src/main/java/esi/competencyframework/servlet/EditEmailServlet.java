package esi.competencyframework.servlet;

import esi.competencyframework.dao.UserDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "EditEmailServlet", value = "/EditEmailServlet")
public class EditEmailServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
    String newEmail = request.getParameter("email");
    String oldEmail = (String) session.getAttribute("email");
    String password = request.getParameter("password");
    UserDAO userDAO = new UserDAO();
    if (!userDAO.checkLogin(oldEmail, password)) {
      request.setAttribute("error", "Password incorrect!");
      RequestDispatcher dispatcher = request.getRequestDispatcher("EditAccount.jsp");
      dispatcher.forward(request, response);
      return;
    }
    userDAO.editEmail(oldEmail, newEmail);
    session.setAttribute("email", newEmail);
    request.setAttribute("success", "Email changed successfully");
    RequestDispatcher dispatcher = request.getRequestDispatcher("EditAccount.jsp");
    dispatcher.forward(request, response);
  }
}
