package com.codurance.codurawise.application.repositories;

import com.codurance.codurawise.domain.models.Tag;

import com.codurance.codurawise.application.repositories.mysql.util.PreparedStatementExecutor;
import com.codurance.codurawise.domain.ports.repositories.TagRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MySQLTagsRepository implements TagRepository {

  private static final String TAG_TABLE = "Tag";
  private static final String TAG_COLUMN = "Tag";
  private final Connection connection;

  public MySQLTagsRepository(Connection connection) {
    this.connection = connection;
  }

  @Override
  public List<Tag> getAllTags() {
    try {
      String sql = ("SELECT" +
        " * " +
        "FROM " + TAG_TABLE + " " +
        "ORDER BY " + TAG_TABLE + "." + TAG_COLUMN + " ASC;");
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      return runQuery(preparedStatement);
    } catch (SQLException sqlException) {
      throw new RuntimeException("Error getting tags", sqlException);
    }
  }

  private List<Tag> runQuery(PreparedStatement preparedStatement) throws SQLException {
    return PreparedStatementExecutor.executeTagQuery(preparedStatement);
  }

}
