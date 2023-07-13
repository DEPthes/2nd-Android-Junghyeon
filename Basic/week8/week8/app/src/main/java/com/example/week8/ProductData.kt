package com.example.week8

import java.io.Serializable

data class ProductData(
    val id: Long,
    val title: String,
    val description: String,
    val price: Int,
    val brand: String,
    val category: String,
    val discountPercentage: Double,
    val rating: Double,
    val stock: Int,
    val thumbnail: String,
    val images: List<String>,
) : Serializable
