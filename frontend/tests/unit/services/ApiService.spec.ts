import ApiService from "@/services/ApiService";
import axios from "axios";

describe("ApiService", () => {
  it("getProducts should call /api/products", () => {
    const spy = jest.spyOn(ApiService, "getProducts");
    // spy on axios get method
    const spyAxiosGet = jest.spyOn(axios, "get");
    ApiService.getProducts();
    expect(spy).toHaveBeenCalled();
    expect(spyAxiosGet).toHaveBeenCalledWith("/api/products");
  });
});
