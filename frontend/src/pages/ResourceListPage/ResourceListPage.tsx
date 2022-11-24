import React, { useEffect, useState } from "react";

import ResourceList from "../../components/ResourceList/ResourceList";
import { backendUrls, getResources } from "../../routes/paths";

const ResourceListPage = () => {
  const [resources, setResources] = useState([]);

  useEffect(() => {
    const newResources = getResources();
    console.log(newResources);
    setResources([]);
  }, []);

  return <ResourceList resources={resources} />;
};

export default ResourceListPage;
