package com.techprd.cheeseria.controllers

import io.kotest.core.spec.style.FunSpec
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@SpringBootTest
@AutoConfigureMockMvc
class ApiControllerTest(
    private var mockMvc: MockMvc,
) : FunSpec({

    test("/api/products") {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/products"))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(
                MockMvcResultMatchers.content().json(
                    "[\n" +
                            "  {\n" +
                            "    \"id\": 0,\n" +
                            "    \"isSale\": false,\n" +
                            "    \"price\": \"4.99\",\n" +
                            "    \"productImage\": \"https://cheese.com/media/img/cheese/GOUDA_SqYJjRh.jpg\",\n" +
                            "    \"productName\": \"GOUDA\",\n" +
                            "    \"type\": \"processed\",\n" +
                            "    \"color\": \"Yellow\"\n" +
                            "  }\n" +
                            "]\n"
                )
            )
    }
})
