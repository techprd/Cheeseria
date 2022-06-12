package com.techprd.cheeseria.controllers

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.techprd.cheeseria.model.Product
import org.springframework.core.io.ResourceLoader
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.io.IOException

/**
 * Api Controller to return products as json to be consumed by frontend single page app
 * this could have been an H2 database if I had more time
 * Author: Ali Shirzad
 */
@RestController
class ApiController(val resourceLoader: ResourceLoader) {
    /**
     * Gets the products.json file and returns the content as a json payload
     *
     * @return json payload containing products
     * @throws IOException throws if the json file does not exists
     */
    @get:Throws(IOException::class)
    @get:GetMapping(value = ["/api/products"], produces = ["application/json"])
    val products: Array<Product>?
        get() {
            val productsJsonFile = resourceLoader.getResource("classpath:products.json")
            val jsonMapper = jacksonObjectMapper()
            return jsonMapper.readValue(productsJsonFile.inputStream)
        }
}
