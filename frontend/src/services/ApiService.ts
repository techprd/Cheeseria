import axios from "axios";
import Product from "@/models/Product";

export default class ApiService {
  /**
   * call the backend API and get a list of products via AJAX call
   */
  public static async getProducts() {
    return await axios.get<Product[]>("/api/products");
  }
}
