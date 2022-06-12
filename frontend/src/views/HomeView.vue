<template>
  <div class="home">
    <Products pageTitle="Welcome to Cheeseria"/>
  </div>
</template>

<script lang="ts">
import {Options, Vue} from "vue-class-component";
import Products from "@/components/Products.vue"; // @ is an alias to /src

@Options({
  components: {
    Products,
  },
})
export default class HomeView extends Vue {
}
</script>
