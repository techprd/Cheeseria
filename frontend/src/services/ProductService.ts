import Product from "@/models/Product";

export default class ProductService {
  /**
   * calculate if the product should show on the page
   * based on the filter value set from dropdown values
   * @param product
   * @param filterValue: filter value selected by user
   * @return true if filter level is all or filterValue is part of product type
   */
  public static canShowProduct(product: Product, filterValue: string) {
    if (filterValue === "all") {
      return true;
    } else if (filterValue === "isSale") {
      return product.isSale;
    } else if (filterValue === product.color) {
      return true;
    } else if (filterValue === product.type) {
      return true;
    }
    return false;
  }
}
