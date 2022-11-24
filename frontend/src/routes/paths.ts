import axios from "axios";

const baseBackendUrl = process.env.REACT_APP_BACKEND_URL;

export const backendUrls = {
  resourceListUrl: baseBackendUrl + "/resources",
};
export async function getResources() {
  const data = await axios.get(backendUrls.resourceListUrl);
  return data;
}
