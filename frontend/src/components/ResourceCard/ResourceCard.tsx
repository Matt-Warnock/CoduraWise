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
      return "https://images.unsplash.com/photo-1516979187457-637abb4f9353?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2340&q=80";
    }
    if (mediaType === "article") {
      return "https://images.unsplash.com/photo-1623039405147-547794f92e9e?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1126&q=80";
    }
    if (mediaType === "video") {
      return "https://images.unsplash.com/photo-1485846234645-a62644f84728?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2318&q=80";
    }
    if (mediaType === "tutorial") {
      return "https://images.unsplash.com/photo-1585829365343-ea8ed0b1cb5b?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2340&q=80";
    }
    if (mediaType === "course") {
      return "https://images.unsplash.com/photo-1616531770192-6eaea74c2456?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2340&q=80";
    }
  };

  return (
    <article className="resource-card__container">
      <img
        className="resource-card__image"
        src={imageForCard(mediaType)}
        alt=""
      />
      <StarRating rating={rating} />
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
    </article>
  );
};

export default ResourceCard;
