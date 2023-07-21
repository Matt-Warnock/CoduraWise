package com.codurance.codurawise.repos.mysql;

import com.codurance.codurawise.domain.models.Resource;
import com.codurance.codurawise.domain.models.Tag;
import com.codurance.codurawise.repos.mysql.util.SqlTestBase;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResourcesMySQLRepositoryTest extends SqlTestBase {

  @Test
  void add_resource_with_existing_tag() throws Exception {

    // arrange
    sqlExecutor.executeUpdate(connection, "INSERT INTO `Media_Type` VALUES ('article');");
    sqlExecutor.executeUpdate(connection, "INSERT INTO `User` VALUES ('default@codurance.com','Default');");
    sqlExecutor.executeUpdate(connection, "INSERT INTO `Tag` VALUES ('java'),('agile');");

    Resource resourceToAdd = new Resource();
    resourceToAdd.setAverageRating(3.0);
    resourceToAdd.setTitle("Uncle Bob");
    resourceToAdd.setLink("www.bob.com");
    resourceToAdd.setMediaType("article");
    resourceToAdd.setTags(List.of(Tag.of("java"), Tag.of("agile")));

    // act
    ResourcesMySQLRepository repository = new ResourcesMySQLRepository(connection);
    Resource resourceAdded = repository.add(resourceToAdd);

    // assert
    List<Resource> resources = repository.getAllSortedByAverageRatingAndCreationDate();
    assertThat(resources.size()).isEqualTo(1);
    assertThat(resourceAdded.getId()).isGreaterThan(0);

    int resourceTagAddedCount = sqlExecutor.queryCount(connection, "SELECT * FROM `Resource_Tag`");
    assertThat(resourceTagAddedCount).isEqualTo(2);
  }

}