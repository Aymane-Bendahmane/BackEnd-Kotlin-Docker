package com.imedia.demo.services

import com.imedia.demo.entities.Product

interface ProductService {
    fun getAllProducts(): List<Product>
    fun getProductById(id: Long): Product
    fun createProduct(product: Product): Product
    fun updateProduct(id: Long, product: Product): Product
    fun deleteProduct(id: Long)
    fun getProductsBySkus(skus: List<String>): List<Product>
    fun getProductBySku(sku: String): Product

}
