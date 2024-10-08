package esi.competencyframework.dao;

import esi.competencyframework.model.Category;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends DAO {

  @SneakyThrows
  public void addCategory(Category category) {
    Connection connection = getConnection();
    final String sql = "INSERT INTO category(name) VALUES (?)";
    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setString(1, category.getName());
    statement.execute();
  }

  @SneakyThrows
  public void updateCategory(Category category) {
    Connection connection = getConnection();
    final String sql = "UPDATE category SET name=? WHERE id=?";
    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setString(1, category.getName());
    statement.setInt(2, category.getId());
    statement.execute();
  }

  @SneakyThrows
  public void deleteCategory(int id) {
    Connection connection = getConnection();
    final String sql = "DELETE FROM category WHERE id=?";
    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setInt(1, id);
    statement.execute();
  }

  @SneakyThrows
  public Category getCategoryById(int id) {
    Connection connection = getConnection();
    final String sql = "SELECT * FROM category WHERE id=?";
    Category category = null;
    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setInt(1, id);
    ResultSet resultSet = statement.executeQuery();
    if (resultSet.next()) {
      category = new Category();
      category.setId(resultSet.getInt("id"));
      category.setName(resultSet.getString("name"));
    }
    return category;
  }

  @SneakyThrows
  public List<Category> getAllCategories() {
    Connection connection = getConnection();
    final String sql = "SELECT * FROM category";
    PreparedStatement statement = connection.prepareStatement(sql);
    ResultSet resultSet = statement.executeQuery();
    List<Category> categories = new ArrayList<>();
    while (resultSet.next()) {
      Category category = new Category();
      category.setId(resultSet.getInt("id"));
      category.setName(resultSet.getString("name"));
      categories.add(category);
    }
    return categories;
  }
}
