import Product from "@/models/Product";
import ProductService from "@/services/ProductService";

describe("ProductService", () => {

  const product = {} as Product;
  product.type = "type";
  product.color = "color";
  product.isSale = true;

  it("canShowProduct should return true if filterValue is all", () => {
    const filterValue = "all";
    expect(ProductService.canShowProduct(product, filterValue)).toBe(true);
  });

  it("canShowProduct should return true if filterValue is isSale", () => {
    const filterValue = "isSale";
    expect(ProductService.canShowProduct(product, filterValue)).toBe(true);
  });

  it("canShowProduct should return true if filterValue is product.color", () => {
    const filterValue = "color";
    expect(ProductService.canShowProduct(product, filterValue)).toBe(true);
  });

  it("canShowProduct should return true if filterValue is product.type", () => {
    const filterValue = "type";
    expect(ProductService.canShowProduct(product, filterValue)).toBe(true);
  });

  it("canShowProduct should return false if filterValue is not product.type", () => {
    const filterValue = "type2";
    expect(ProductService.canShowProduct(product, filterValue)).toBe(false);
  });

});
