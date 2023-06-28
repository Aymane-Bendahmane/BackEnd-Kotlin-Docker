package com.imedia.demo.repositories


import com.imedia.demo.entities.Product
import org.springframework.data.jpa.repository.JpaRepository
interface ProductRepository  : JpaRepository<Product, Long> {
    fun findBySkuIn(skus: List<String>): List<Product>
    fun findProductBySku(sku:String):Product
}
