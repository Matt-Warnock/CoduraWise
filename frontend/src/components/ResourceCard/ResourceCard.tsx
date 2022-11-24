import React from "react";

interface ResourceCardProps {
  title: string;

  link: string;
}

const ResourceCard = ({ title, link }: ResourceCardProps) => {
  return (
    <article>
      <h3>Title: {title}</h3>

      <a href={link}>URL: {link}</a>
    </article>
  );
};

export default ResourceCard;
