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

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    System.out.println(email);
    System.out.println(password);
    UserDAO userDAO = new UserDAO();
    System.out.println(userDAO.checkLogin(email, password));
    if (!userDAO.checkLogin(email, password)) {
      request.setAttribute("error", "Email and/or password incorrect!");
      RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
      dispatcher.forward(request, response);
      return;
    }
    HttpSession session = request.getSession();
    session.setAttribute("email", email);
    RequestDispatcher dispatcher = request.getRequestDispatcher("ManageCompetency.jsp");
    dispatcher.forward(request, response);
  }
}
