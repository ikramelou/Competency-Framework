package esi.competencyframework.dao;

import esi.competencyframework.model.User;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO extends DAO {

  @SneakyThrows
  public Boolean checkIfEmailExists(String email) {
    Connection connection = getConnection();
    final String query = "SELECT COUNT(*) FROM Users WHERE email = ?";
    PreparedStatement statement = connection.prepareStatement(query);
    statement.setString(1, email);
    ResultSet resultSet = statement.executeQuery();
    resultSet.next();
    int count = resultSet.getInt(1);
    return count > 0;
  }

  @SneakyThrows
  public void addUser(User user) {
    Connection connection = getConnection();
    final String query = "INSERT INTO Users(email, password, first_name, last_name) VALUES(?, ?, ?, ?)";
    PreparedStatement statement = connection.prepareStatement(query);
    statement.setString(1, user.getEmail());
    statement.setString(2, user.getPassword());
    statement.setString(3, user.getFirstName());
    statement.setString(4, user.getLastName());
    statement.execute();
  }

  @SneakyThrows
  public Boolean checkLogin(String email, String password) {
    Connection connection = getConnection();
    final String query = "SELECT COUNT(*) FROM Users WHERE email = ? AND password = ?";
    PreparedStatement statement = connection.prepareStatement(query);
    statement.setString(1, email);
    statement.setString(2, password);
    ResultSet resultSet = statement.executeQuery();
    resultSet.next();
    int count = resultSet.getInt(1);
    return count > 0;
  }

  @SneakyThrows
  public void editEmail(String email, String newEmail) {
    Connection connection = getConnection();
    final String query = "UPDATE Users SET email = ? WHERE email = ?";
    PreparedStatement statement = connection.prepareStatement(query);
    statement.setString(1, newEmail);
    statement.setString(2, email);
    statement.execute();
  }

  @SneakyThrows
  public void editPassword(String email, String newPassword) {
    Connection connection = getConnection();
    final String query = "UPDATE Users SET password = ? WHERE email = ?";
    PreparedStatement statement = connection.prepareStatement(query);
    statement.setString(1, newPassword);
    statement.setString(2, email);
    statement.execute();
  }



}
