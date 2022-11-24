import { render, screen } from "@testing-library/react";
import ResourceListPage from "./ResourceListPage";
import React from "react";
import { server } from "../../mocks/server";

describe("given the resorce list page", () => {
  beforeEach(() => {
    server.listen();
  });
  test("it renders the resource list", async () => {
    render(<ResourceListPage />);

    const resourceList = await screen.getByRole("list");

    expect(resourceList).toHaveClass("resource-list__container");
  });
});

export {};
