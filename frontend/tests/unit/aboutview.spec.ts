import {shallowMount} from "@vue/test-utils";
import AboutView from "@/views/AboutView.vue";


describe("AboutView.vue", () => {
  it("renders about page", () => {
    const msg = "Cheeseria App";
    const wrapper = shallowMount(AboutView);
    expect(wrapper.text()).toContain(msg);
  });
});
