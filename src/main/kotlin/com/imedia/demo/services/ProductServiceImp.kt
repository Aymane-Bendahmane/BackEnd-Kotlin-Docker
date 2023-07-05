package com.imedia.demo.services

import com.imedia.demo.dtos.ProductDto
import com.imedia.demo.entities.Product
import com.imedia.demo.mappers.ProductMapper
import com.imedia.demo.repositories.ProductRepository
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

/**
 * Implementation of the ProductService interface that provides operations for managing products.
 */
@Service
@Transactional
class ProductServiceImp(private val productRepository: ProductRepository) : ProductService {

    /**
     * Retrieves all products.
     *
     * @return the list of all products
     */
    override fun getAllProducts(): List<ProductDto> {
        val products  =  productRepository.findAll()
        return ProductMapper.INSTANCE.productListToDtoList(products)
    }

    /**
     * Retrieves a product by its ID.
     *
     * @param id the ID of the product to retrieve
     * @return the product with the specified ID
     * @throws NoSuchElementException if no product is found with the specified ID
     */
    override fun getProductById(id: Long): ProductDto {
        val product =  productRepository.findById(id)
                .orElseThrow { NoSuchElementException("Product not found with id: $id") }

        return ProductMapper.INSTANCE.productToDto(product)
    }

    /**
     * Creates a new product.
     *
     * @param product the product to create
     * @return the created product
     */
    override fun createProduct(productDto: ProductDto): ProductDto {
        val product =  productRepository.save(ProductMapper.INSTANCE.dtoToProduct(productDto))
        return ProductMapper.INSTANCE.productToDto(product)
    }

    /**
     * Updates an existing product.
     *
     * @param id the ID of the product to update
     * @param product the updated product data
     * @return the updated product
     * @throws NoSuchElementException if no product is found with the specified ID
     */
    override fun updateProduct(id: Long, productDto: ProductDto): ProductDto {
        val product = productRepository.findById(id)
                .orElseThrow { NoSuchElementException("Product not found with id: $id") }
                .apply {
                    name = productDto.name
                    description = productDto.description
                    price = productDto.price
                    stock = productDto.stock
                }
        return ProductMapper.INSTANCE.productToDto(productRepository.save(product))
    }


    /**
     * Deletes a product by its ID.
     *
     * @param id the ID of the product to delete
     * @throws NoSuchElementException if no product is found with the specified ID
     */
    override fun deleteProduct(id: Long) {
        if (!productRepository.existsById(id)) {
            throw NoSuchElementException("Product not found with id: $id")
        }
        productRepository.deleteById(id)
    }

    /**
     * Retrieves a list of products based on the provided SKUs.
     *
     * @param skus the list of SKUs to search for
     * @return the list of products matching the SKUs
     */
    override fun getProductsBySkus(skus: List<String>): List<ProductDto> {
        val products:List<Product> = productRepository.findBySkuIn(skus)
        return ProductMapper.INSTANCE.productListToDtoList(products)
    }

    /**
     * Retrieves a product by its SKU.
     *
     * @param sku the SKU of the product to retrieve
     * @return the product with the specified SKU
     */
    override fun getProductBySku(sku: String): ProductDto {
        val product:Product =  productRepository.findProductBySku(sku)
        return ProductMapper.INSTANCE.productToDto(product)
    }
}
