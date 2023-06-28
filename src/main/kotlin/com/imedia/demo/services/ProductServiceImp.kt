package com.imedia.demo.services

import com.imedia.demo.entities.Product
import com.imedia.demo.repositories.ProductRepository
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Service
@Transactional
class ProductServiceImp(private val productRepository: ProductRepository) : ProductService {

    override fun getAllProducts(): List<Product> {
        return productRepository.findAll()
    }

    override fun getProductById(id: Long): Product {
        return productRepository.findById(id)
            .orElseThrow { NoSuchElementException("Product not found with id: $id") }
    }

    override fun createProduct(product: Product): Product {
        return productRepository.save(product)
    }

    override fun updateProduct(id: Long, product: Product): Product {
        if (!productRepository.existsById(id)) {
            throw NoSuchElementException("Product not found with id: $id")
        }
        product.id = id
        return productRepository.save(product)
    }

    override fun deleteProduct(id: Long) {
        if (!productRepository.existsById(id)) {
            throw NoSuchElementException("Product not found with id: $id")
        }
        productRepository.deleteById(id)
    }

    override fun getProductsBySkus(skus: List<String>): List<Product> {
        return productRepository.findBySkuIn(skus)
    }

    override fun getProductBySku(sku: String): Product {
        return productRepository.findProductBySku(sku) ;
    }
}
