import Products from "@/components/Products.vue";
import {mount} from "@vue/test-utils";
import Product from "@/models/Product";

describe('Products', () => {

  it('should render correctly', () => {
    const wrapper = mount(Products, {
      props: {
        pageTitle: "Test Title"
      },
    });

    wrapper.vm.products = [{
      "id": 0,
      "isSale": false,
      "price": 4.99,
      "productImage": "https://cheese.com/media/img/cheese/GOUDA_SqYJjRh.jpg",
      "productName": "GOUDA",
      "type": "processed",
      "color": "Yellow"
    } as Product];

    wrapper.vm.$nextTick(() => {
      // test that the products are rendered
      expect(wrapper.text()).toContain("Test Title");
      expect(wrapper.findAll('.card').length).toBe(1);
      expect(wrapper.find('.card-text').text()).toContain("GOUDA");
    });

  });
});
