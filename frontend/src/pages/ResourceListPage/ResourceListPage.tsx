import React from "react";

import ResourceList from "../../components/ResourceList/ResourceList";

const ResourceListPage = () => {
  const mockResources = [
    { id: 1, title: "Java", link: "Java Link" },
    { id: 2, title: "Python", link: "Python Link" },
    { id: 3, title: "Javascript", link: "Javascript Link" },
  ];

  return <ResourceList resources={mockResources} />;
};

export default ResourceListPage;
