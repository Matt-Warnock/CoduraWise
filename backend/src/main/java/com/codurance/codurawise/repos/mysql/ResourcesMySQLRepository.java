package com.codurance.codurawise.repos.mysql;

import com.codurance.codurawise.domain.models.Resource;
import com.codurance.codurawise.repos.ResourcesRepository;
import com.codurance.codurawise.repos.mysql.util.PreparedStatementExecutor;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ResourcesMySQLRepository implements ResourcesRepository {

  private static final String RESOURCE_TABLE = "Resource";
  private static final String DEFAULT_USER_EMAIL = "default@codurance.com";
  private final Connection connection;

  public ResourcesMySQLRepository(Connection connection) {
    this.connection = connection;
  }

  @Override
  public List<Resource> getAllSortedByAverageRatingAndCreationDate() {
    try {
      String sql = ("SELECT" +
        " * " +
        "FROM " + RESOURCE_TABLE + " " +
        "ORDER BY Resource.Average_Rating DESC, Resource.Creation_Date DESC;");
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      return runQuery(preparedStatement);
    } catch (SQLException sqlException) {
      throw new RuntimeException("Error getting resources", sqlException);
    }
  }

  @Override
  public List<Resource> getByTagSortedByAverageRatingAndCreationDate(String tag) {
    try {
      String sql = ("SELECT" +
        " Resource.* " +
        "FROM Resource " +
        "INNER JOIN Resource_Tag " +
        "USING (Resource_ID) " +
        "WHERE Resource_Tag.Tag = ? " +
        "ORDER BY Resource.Average_Rating DESC, Resource.Creation_Date DESC;");

      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, tag);

      return runQuery(preparedStatement);
    } catch (SQLException sqlException) {
      throw new RuntimeException("Error getting resources", sqlException);
    }
  }

  @Override
  public Resource add(Resource resourceToAdd) {
    try {
      String sql = ("INSERT INTO `Resource` " +
        "(Title, Link, Description, Creation_Date, Media_Type, Average_Rating, Email) " +
        "VALUES (?,?,?,?,?,?,?);");

      PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      preparedStatement.setString(1, resourceToAdd.getTitle());
      preparedStatement.setString(2, resourceToAdd.getLink());
      preparedStatement.setString(3, "");
      preparedStatement.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
      preparedStatement.setString(5, resourceToAdd.getMediaType());
      preparedStatement.setDouble(6, resourceToAdd.getAverageRating());
      preparedStatement.setString(7, DEFAULT_USER_EMAIL);

      int rowsAdded = preparedStatement.executeUpdate();
      if (rowsAdded != 1) {
        throw new RuntimeException("Resource not added!");
      }

      ResultSet generatedKeysResult = preparedStatement.getGeneratedKeys();
      generatedKeysResult.next();
      int newId = generatedKeysResult.getInt(1);

      resourceToAdd.setId(newId);

      return resourceToAdd;
    } catch (SQLException sqlException) {
      throw new RuntimeException("Error adding resource", sqlException);
    }
  }

  private List<Resource> runQuery(PreparedStatement preparedStatement) throws SQLException {
    return PreparedStatementExecutor.executeResourceQuery(preparedStatement);
  }

}
