package esi.competencyframework.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
  protected Connection getConnection() throws SQLException, ClassNotFoundException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    String url = "jdbc:mysql://localhost:3306/competency_framework";
    String username = "root";
    String password = "";
    return DriverManager.getConnection(url, username, password);
  }
}
