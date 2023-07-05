package com.imedia.demo.mappers


import com.imedia.demo.dtos.ProductDto
import com.imedia.demo.entities.Product
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

@Mapper
interface ProductMapper {
    fun productToDto(product: Product): ProductDto
    fun dtoToProduct(productDto: ProductDto): Product
    fun productListToDtoList(products: List<Product>): List<ProductDto>

    companion object {
        val INSTANCE: ProductMapper = Mappers.getMapper(ProductMapper::class.java)
    }
}
