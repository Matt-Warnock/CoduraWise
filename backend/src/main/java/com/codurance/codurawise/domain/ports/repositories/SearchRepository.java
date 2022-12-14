package com.codurance.codurawise.domain.ports.repositories;

import com.codurance.codurawise.domain.models.Resource;

import java.util.List;

public interface SearchRepository {
  List<Resource> queryByTitleAndTag(String title, String tag);
  List<Resource> queryByTitle(String title);
  List<Resource> queryByTag(String tag);
  List<Resource> queryBothByTitleAndTag(String title, String tag);

}
