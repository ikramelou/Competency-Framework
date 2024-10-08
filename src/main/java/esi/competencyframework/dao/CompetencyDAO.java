package esi.competencyframework.dao;

import esi.competencyframework.model.Competency;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CompetencyDAO extends DAO {

  public void addCompetency(Competency competency) throws SQLException, ClassNotFoundException {
    Connection connection = getConnection();
    final String query = "INSERT INTO Competencies (name, description, domain, level, category_id) VALUES ( ?, ?, ?, ?, ?)";
    PreparedStatement ps = connection.prepareStatement(query);
    ps.setString(1, competency.getName());
    ps.setString(2, competency.getDescription());
    ps.setString(3, competency.getDomain());
    ps.setString(4, competency.getLevel());
    ps.setInt(5, competency.getCategory().getId());
    ps.executeUpdate();
  }

  public Competency getCompetencyByID(int id) throws SQLException, ClassNotFoundException {
    Connection connection = getConnection();
    final String query = "SELECT * FROM Competencies WHERE id = ?";
    PreparedStatement ps = connection.prepareStatement(query);
    ps.setInt(1, id);
    ResultSet rs = ps.executeQuery();
    if (rs.next()) {
      Competency competency = new Competency();
      competency.setId(rs.getInt("id"));
      competency.setName(rs.getString("name"));
      competency.setDescription(rs.getString("description"));
      competency.setDomain(rs.getString("domain"));
      competency.setLevel(rs.getString("level"));
      competency.setCategory(new CategoryDAO().getCategoryById(rs.getInt("category_id")));
      return competency;
    }
    return null;
  }

  public List<Competency> getAllCompetencies() throws SQLException, ClassNotFoundException {
    Connection connection = getConnection();
    List<Competency> competenciesList = new ArrayList<>();
    final String query = "SELECT * FROM Competencies";
    PreparedStatement ps = connection.prepareStatement(query);
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      Competency competency = new Competency();
      competency.setId(rs.getInt("id"));
      competency.setName(rs.getString("name"));
      competency.setDescription(rs.getString("description"));
      competency.setDomain(rs.getString("domain"));
      competency.setLevel(rs.getString("level"));
      competency.setCategory(new CategoryDAO().getCategoryById(rs.getInt("category_id")));
      competenciesList.add(competency);
    }
    return competenciesList;
  }

  public void removeCompetency(int id) throws SQLException, ClassNotFoundException {
    Connection connection = getConnection();
    final String query = "DELETE FROM Competencies WHERE id = ?";
    PreparedStatement ps = connection.prepareStatement(query);
    ps.setInt(1, id);
    ps.executeUpdate();
  }

  public void editCompetency(Competency competency) throws SQLException, ClassNotFoundException {
    Connection connection = getConnection();
    final String query = "UPDATE Competencies SET name = ?, description = ?, domain = ?, level = ?, category_id = ? WHERE id = ?";
    PreparedStatement ps = connection.prepareStatement(query);
    ps.setString(1, competency.getName());
    ps.setString(2, competency.getDescription());
    ps.setString(3, competency.getDomain());
    ps.setString(4, competency.getLevel());
    ps.setInt(5, competency.getCategory().getId());
    ps.setInt(6, competency.getId());
    ps.executeUpdate();
  }
}
