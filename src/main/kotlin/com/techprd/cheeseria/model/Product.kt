package com.techprd.cheeseria.model

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Product Data Object
 */
data class Product(
    val id: Int,
    @JsonProperty("isSale")
    val isSale: Boolean,
    val price: String,
    val productImage: String,
    val productName: String,
    val type: String,
    val color: String
)
