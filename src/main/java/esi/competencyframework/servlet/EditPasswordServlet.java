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

@WebServlet(name = "EditPasswordServlet", value = "/EditPasswordServlet")
public class EditPasswordServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
    String email = (String) session.getAttribute("email");
    String opassword = request.getParameter("opassword");
    String npassword = request.getParameter("npassword");
    UserDAO userDAO = new UserDAO();
    if (!userDAO.checkLogin(email, opassword)) {
      request.setAttribute("error", "Old password incorrect!");
      RequestDispatcher dispatcher = request.getRequestDispatcher("EditAccount.jsp");
      dispatcher.forward(request, response);
      return;
    }
    userDAO.editPassword(email, npassword);
    request.setAttribute("success", "Password changed successfully");
    RequestDispatcher dispatcher = request.getRequestDispatcher("EditAccount.jsp");
    dispatcher.forward(request, response);
  }
}
