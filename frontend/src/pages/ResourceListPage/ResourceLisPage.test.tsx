import { render, screen } from "@testing-library/react";
import ResourceListPage from "./ResourceListPage";
import React from "react";

describe("given the resorce list page", () => {
  test("it renders the resource list", () => {
    render(<ResourceListPage />);

    const resourceList = screen.getByRole("list");

    expect(resourceList).toHaveClass("resource-list__container");
  });
});

export {};
