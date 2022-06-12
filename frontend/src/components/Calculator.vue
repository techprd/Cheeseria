<template>
  <Transition name="modal">
    <div v-if="show" class="modal-mask">
      <div class="modal-wrapper">
        <div class="modal-container">
          <div class="modal-header">
            <slot name="header">
              <p class="card-text">{{ product.productName }}</p>
            </slot>
          </div>
          <div class="modal-body">
            <slot name="body">
              <p class="card-text">Type: {{ product.type }} | {{ product.color }}</p>
              <div class="card-body">
                <p class="card-text">Price: <small class="text-muted">{{ product.price }} / KG </small></p>
              </div>
              <label for="weight">Weight / KG: <input id="weight" v-model="weight"/></label>
              <p class="card-text">Total: ${{ totalPrice(product) }}</p>
            </slot>
          </div>
          <div class="modal-footer">
            <slot name="footer">
              <button class="btn btn-primary" @click="$emit('close')">
                Close
              </button>
            </slot>
          </div>
        </div>
      </div>
    </div>
  </Transition>
</template>

<script lang="ts">
import {Options, Vue} from 'vue-class-component';
import Product from "@/models/Product";

@Options({
  props: {
    show: Boolean,
    product: Object as () => Product,
  },
})
export default class CalculatorView extends Vue {
  public weight = 1;

  /**
   * calculate the total price of the product
   */
  public totalPrice = (product: Product) => {
    return product.price * this.weight;
  };
}
</script>

<style scoped>

.modal-mask {
  position: fixed;
  z-index: 9998;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  display: table;
  transition: opacity 0.3s ease;
}

.modal-wrapper {
  display: table-cell;
  vertical-align: middle;
}

.modal-container {
  width: 300px;
  margin: 0px auto;
  padding: 20px 30px;
  background-color: #fff;
  border-radius: 2px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.33);
  transition: all 0.3s ease;
}

.modal-header h3 {
  margin-top: 0;
  color: #42b983;
}

.modal-body {
  margin: 20px 0;
}

.modal-default-button {
  float: right;
}

.modal-enter-from {
  opacity: 0;
}

.modal-leave-to {
  opacity: 0;
}

.modal-enter-from .modal-container,
.modal-leave-to .modal-container {
  -webkit-transform: scale(1.1);
  transform: scale(1.1);
}
</style>
