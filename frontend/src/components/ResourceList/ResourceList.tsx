import React from "react";
import { Resource } from "../../models/Resource";
import ResourceCard from "../ResourceCard/ResourceCard";

interface ResourceListProps {
  resources: Array<Resource>;
}

const ResourceList = ({ resources }: ResourceListProps) => {
  return (
    <section>
      {resources.map((resource) => (
        <ResourceCard key = {resource.id} title = {resource.title} link = {resource.link}/>
      ))}
    </section>
  );
};

export default ResourceList;
