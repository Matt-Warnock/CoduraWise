import React, { useEffect, useState } from "react";
import ResourceList from "../../components/ResourceList/ResourceList";
import { Resource } from "../../models/Resource";
import { backendUrls } from "../../routes/paths";

const ResourceListPage = () => {
  const [resources, setResources] = useState<Array<Resource>>([]);

  async function getResources() {
    const response = await fetch(backendUrls.resourceListUrl);
    const data = await response.json();
    if (data) {
      setResources(data);
    }
  }

  useEffect(() => {
    getResources();
  }, []);

  return <ResourceList resources={resources} />;
};

export default ResourceListPage;
