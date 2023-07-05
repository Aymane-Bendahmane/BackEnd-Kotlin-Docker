package com.imedia.demo.utilities

import com.imedia.demo.entities.Product
import com.imedia.demo.repositories.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class InitProductData(@Autowired val productRepository: ProductRepository) : CommandLineRunner {
    override fun run(vararg args: String?) {
        val product1 =
            Product(sku = "ABC123", name = "Product 1", description = "Dummy product 1", price = 9.99, stock = 2)
        val product2 =
            Product(sku = "DEF456", name = "Product 2", description = "Dummy product 2", price = 19.99, stock = 50)

        // Save the products to the repository
        productRepository.save(product1)
        productRepository.save(product2)
    }
}