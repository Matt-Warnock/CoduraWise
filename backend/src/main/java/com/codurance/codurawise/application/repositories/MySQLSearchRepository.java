package com.codurance.codurawise.application.repositories;

import com.codurance.codurawise.domain.models.Resource;

import com.codurance.codurawise.application.repositories.mysql.util.PreparedStatementExecutor;
import com.codurance.codurawise.domain.ports.repositories.SearchRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MySQLSearchRepository implements SearchRepository {
  private final Connection connection;

  public MySQLSearchRepository(Connection connection) {
    this.connection = connection;
  }

  @Override
  public List<Resource> queryByTitleAndTag(String title, String tag) {
    if (title != null && tag == null) {
      return queryByTitle(title);
    } else if (tag != null && title == null) {
      return queryByTag(tag);
    } else {
      return queryBothByTitleAndTag(title, tag);
    }
  }

  @Override
  public List<Resource> queryBothByTitleAndTag(String title, String tag) {
    try {
      String sql = ("SELECT" +
        " Resource.* " +
        "FROM Resource " +
        "INNER JOIN Resource_Tag " +
        "USING (Resource_ID) " +
        "WHERE Resource_Tag.Tag = ? " +
        " OR Title LIKE ? " +
        " ORDER BY Resource.Average_Rating DESC, Resource.Creation_Date DESC;");

      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, tag);
      preparedStatement.setString(2, anyMatch(title));

      return runQuery(preparedStatement);
    } catch (SQLException sqlException) {
      throw new RuntimeException("Error searching resources", sqlException);
    }
  }

  @Override
  public List<Resource> queryByTitle(String title) {
    try {
      String sql = ("SELECT" +
        " Resource.* " +
        "FROM Resource " +
        "INNER JOIN Resource_Tag " +
        "USING (Resource_ID) " +
        "WHERE Title LIKE ? " +
        "ORDER BY Resource.Average_Rating DESC, Resource.Creation_Date DESC;");

      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, anyMatch(title));

      return runQuery(preparedStatement);
    } catch (SQLException sqlException) {
      throw new RuntimeException("Error getting resources", sqlException);
    }
  }

  @Override
  public List<Resource> queryByTag(String tag) {
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

  private List<Resource> runQuery(PreparedStatement preparedStatement) throws SQLException {
    return PreparedStatementExecutor.executeResourceQuery(preparedStatement);
  }

  private static String anyMatch(String title) {
    return "%" + title + "%";
  }

}
