import TestRenderer from "react-test-renderer";
import ResourceCard from "./ResourceCard";
import React from "react";

test("snapshot test: the html matches", () => {
  const card = TestRenderer.create(<ResourceCard link="url" title="title" />);

  expect(card.toJSON()).toMatchSnapshot();
});
