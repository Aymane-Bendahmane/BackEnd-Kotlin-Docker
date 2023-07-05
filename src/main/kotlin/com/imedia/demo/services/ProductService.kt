package com.imedia.demo.services

import com.imedia.demo.dtos.ProductDto
import com.imedia.demo.entities.Product

interface ProductService {
    fun getAllProducts(): List<ProductDto>
    fun getProductById(id: Long): ProductDto
    fun createProduct(productDto: ProductDto): ProductDto
    fun updateProduct(id: Long, productDto: ProductDto): ProductDto
    fun deleteProduct(id: Long)
    fun getProductsBySkus(skus: List<String>): List<ProductDto>
    fun getProductBySku(sku: String): ProductDto

}
