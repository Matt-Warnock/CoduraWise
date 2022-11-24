import React from "react";

import { Resource } from "../../models/Resource";

import ResourceCard from "../ResourceCard/ResourceCard";

interface ResourceListProps {
  resources: Array<Resource>;
}

const ResourceList = ({ resources }: ResourceListProps) => {
  return (
    <ul className="resource-list__container">
      {resources
        ? resources.map((resource) => (
            <li key={resource.id}>
              <ResourceCard title={resource.title} link={resource.link} />
            </li>
          ))
        : null}
    </ul>
  );
};

export default ResourceList;
