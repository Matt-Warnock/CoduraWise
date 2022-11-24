import React from "react";
import ResourceList from "../../components/ResourceList/ResourceList";

const ResourceListPage = () => {
  return (
    <ResourceList
      resources={[
        { id: 1, title: "Java", link: "Java Link" },
        { id: 2, title: "Python", link: "Python Link" },
        { id: 3, title: "Javascript", link: "Javascript Link" },
      ]}
    />
  );
};

export default ResourceListPage;
