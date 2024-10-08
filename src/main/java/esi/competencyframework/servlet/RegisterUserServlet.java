package esi.competencyframework.servlet;

import esi.competencyframework.dao.UserDAO;
import esi.competencyframework.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;

@WebServlet(name = "RegisterUserServlet", value = "/RegisterUserServlet")
public class RegisterUserServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  }

  @SneakyThrows
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String firstName = request.getParameter("fname");
    String lastName = request.getParameter("lname");
    String email = request.getParameter("email");
    String password = request.getParameter("password1");
    UserDAO userDAO = new UserDAO();
    if (userDAO.checkIfEmailExists(email)) {
      request.setAttribute("error", "Email already exists!");
      RequestDispatcher dispatcher = request.getRequestDispatcher("Register.jsp");
      dispatcher.forward(request, response);
      return;
    }
    User user = User.builder().firstName(firstName).lastName(lastName).email(email).password(password).build();
    userDAO.addUser(user);
    request.setAttribute("success", "You have successfully registered, now please login!");
    RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
    dispatcher.forward(request, response);
  }
}
