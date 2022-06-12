<template>
  <div>
    <h1>{{ pageTitle }}</h1>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <div class="right">
          <ul class="navbar-nav right" style="width: 30%">
            <li class="nav-item right">
              <select v-model="filterValue" class="form-control nav-link">
                <option>all</option>
                <option>isSale</option>
                <option>processed</option>
                <option>brined</option>
                <option>White</option>
                <option>Yellow</option>
              </select>
            </li>
          </ul>
          <a class="navbar-brand right" href="#" style="width: 20%">Filter By:</a>
        </div>
      </div>
    </nav>
    <div class="album py-5 bg-light">
      <div class="container">
        <div class="row">
          <div
            v-for="product in (filteredProducts || products)"
            class="col-md-3"
            v-bind:key="product.id">
            <div class="card mb-4 shadow-sm">
              <i class="icon ion-md-heart salesIcon" v-if="product.isSale">On Sale</i>
              <img :src="product.productImage" :alt="product.productName">
              <div class="card-body">
                <p class="card-text">{{ product.productName }}</p>
                <p class="card-text">{{ product.type }} | {{ product.color }}</p>
                <small class="text-muted">${{ product.price }} / KG </small>
                <small class="text-muted">
                  <button type="button" class="btn btn-info" @click="openCalculator(product)">
                    <i class="icon ion-md-calculator"></i>
                  </button>
                </small>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <Teleport to="body">
      <!-- use the modal component, pass in the prop -->
      <CalculatorView :show="showModal" @close="showModal = false" :product="selectedProduct"></CalculatorView>
    </Teleport>
  </div>
</template>

<script lang="ts">
import {Options, Vue} from "vue-class-component";
import {computed} from 'vue';
import ApiService from "@/services/ApiService";
import ProductService from "@/services/ProductService";
import Product from "@/models/Product";
import CalculatorView from "@/components/Calculator.vue";

@Options({
  props: {
    pageTitle: String,
  },
  components: {CalculatorView},
})
export default class Products extends Vue {
  public filterValue = "all";
  public products: Product[] = [];
  public showModal = false
  public selectedProduct: Product | null = null;

  /**
   * when the component is mounted (before rendering)
   * get all products via backend API
   */
  async mounted() {
    const {data, status} = await ApiService.getProducts();
    if (status === 200) {
      this.products = data as Product[];
    } else {
      console.error("Error getting products");
    }
  }

  /**
   * filter the products based on the filterValue
   */
  public filteredProducts = computed(() => {
    return this.products.filter(product => {
      return this.canShowProduct(product);
    });
  });

  /**
   * calculate if the product should show on the page
   * based on the filter value set from dropdown values
   * @param product
   * @return true if filter level is all or filterValue is part of product type
   */
  canShowProduct(product: Product) {
    return ProductService.canShowProduct(product, this.filterValue);
  }

  openCalculator(product: Product) {
    this.selectedProduct = product;
    this.showModal = true;
  }
}
</script>

<style scoped lang="scss">

.collapse:not(.show) {
  display: block;
}

.salesIcon {
  position: absolute;
  color: #f3ff5e;
  margin-left: 10px;
  font-weight: bold;
}

.right {
  float: right;
  width: 100%;
}

h3 {
  margin: 40px 0 0;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
