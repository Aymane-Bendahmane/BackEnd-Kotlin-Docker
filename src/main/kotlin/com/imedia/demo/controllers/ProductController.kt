package  com.imedia.demo.controllers

import com.imedia.demo.entities.Product
import com.imedia.demo.services.ProductServiceImp
import org.springframework.web.bind.annotation.*

@RestController
class ProductController(private val productServiceImp: ProductServiceImp) {

    @GetMapping("")
    fun getAllProducts(): List<Product> {
        return productServiceImp.getAllProducts()
    }

    @PostMapping("/product")
    fun createProduct(@RequestBody product: Product): Product {
        return productServiceImp.createProduct(product)
    }

    @DeleteMapping("/product/{id}")
    fun deleteProduct(@PathVariable id: Long) {
        productServiceImp.deleteProduct(id)
    }

    @GetMapping("/products")
    fun getProductsBySkus(@RequestParam skus: List<String>): List<Product> {
        return productServiceImp.getProductsBySkus(skus)
    }

    @GetMapping("/product/{sku}")
    fun getProductsBySku(@PathVariable sku: String): Product {
        return productServiceImp.getProductBySku(sku)
    }

    @PutMapping("/product/{id}")
    fun updateProduct(@PathVariable id: Long, @RequestBody product: Product): Product {
        return productServiceImp.updateProduct(id, product)
    }
}
