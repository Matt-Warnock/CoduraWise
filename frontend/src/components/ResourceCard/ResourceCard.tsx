import React from "react";
import StarRating from "../StarRating/StarRating";
import "./ResourceCard.scss";

interface ResourceCardProps {
  title: string;
  link: string;
  rating: number;
  mediaType: string;
}

const ResourceCard = ({
  title,
  link,
  rating,
  mediaType,
}: ResourceCardProps) => {
  const imageForCard = (mediaType: string) => {
    if (mediaType === "book") {
      return "book.jpg";
    }
    if (mediaType === "article") {
      return "article.jpg";
    }
    if (mediaType === "video") {
      return "video.jpg";
    }
    if (mediaType === "tutorial") {
      return "tutorial.jpg";
    }
    if (mediaType === "course") {
      return "course.jpg";
    }
  };

  return (
    <article className="resource-card__container">
      <img
        src={`../../../public/ResourceCardImage/${imageForCard(mediaType)}`}
        alt=""
      />
      <h3 className="resource-card__title">
        <a
          className="resource-card__link"
          href={link}
          target="_blank"
          rel="noreferrer"
        >
          {title}
        </a>
      </h3>
      <StarRating rating={rating} />
    </article>
  );
};

export default ResourceCard;
