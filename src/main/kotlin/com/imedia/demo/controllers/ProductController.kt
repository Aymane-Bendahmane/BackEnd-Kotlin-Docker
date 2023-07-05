package com.imedia.demo.controllers

import com.imedia.demo.dtos.ProductDto
import com.imedia.demo.services.ProductServiceImp
import org.springframework.web.bind.annotation.*

/**
 * Controller class for managing product-related operations.
 */
@RestController
class ProductController(private val productServiceImp: ProductServiceImp) {

    /**
     * Retrieves a list of all products.
     *
     * @return the list of all products
     */
    @GetMapping("/products/all")
    fun getAllProducts(): List<ProductDto> {
        return productServiceImp.getAllProducts()
    }

    /**
     * Creates a new product.
     *
     * @param product the product to create
     * @return the created product
     */
    @PostMapping("/product")
    fun createProduct(@RequestBody productDto: ProductDto): ProductDto {
        return productServiceImp.createProduct(productDto)
    }

    /**
     * Deletes a product by its ID.
     *
     * @param id the ID of the product to delete
     */
    @DeleteMapping("/product/{id}")
    fun deleteProduct(@PathVariable id: Long) {
        productServiceImp.deleteProduct(id)
    }

    /**
     * Retrieves a list of products based on the provided SKUs.
     *
     * @param skus the list of SKUs to search for
     * @return the list of products matching the SKUs
     */
    @GetMapping("/products")
    fun getProductsBySkus(@RequestParam skus: List<String>): List<ProductDto> {
        return productServiceImp.getProductsBySkus(skus)
    }

    /**
     * Retrieves a product by its SKU.
     *
     * @param sku the SKU of the product to retrieve
     * @return the product with the specified SKU
     */
    @GetMapping("/product/{sku}")
    fun getProductsBySku(@PathVariable sku: String): ProductDto {
        return productServiceImp.getProductBySku(sku)
    }

    /**
     * Updates an existing product.
     *
     * @param id the ID of the product to update
     * @param product the updated product data
     * @return the updated product
     */
    @PutMapping("/product/{id}")
    fun updateProduct(@PathVariable id: Long, @RequestBody productDto: ProductDto): ProductDto {
        return productServiceImp.updateProduct(id, productDto)
    }
}
