package com.imedia.demo.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import com.imedia.demo.entities.Product
import com.imedia.demo.services.ProductServiceImp
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.mock.web.MockHttpServletResponse
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.RequestBuilder
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import com.fasterxml.jackson.core.type.TypeReference


@WebMvcTest(ProductController::class)
class ProductControllerTests {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var productServiceImp: ProductServiceImp

    private val objectMapper = ObjectMapper()


    @Test
    fun testGetProductsBySku() {
        val sku = "ABC123"
        val product = Product(sku = sku, name = "Product 1", description = "Dummy product", price = 9.99, stock = 3)

        `when`(productServiceImp.getProductBySku(sku)).thenReturn(product)


        val requestBuilder: RequestBuilder = MockMvcRequestBuilders.get("/product/$sku")
        val result: MvcResult = mockMvc.perform(requestBuilder).andReturn()
        val response: MockHttpServletResponse = result.response

        val responseProduct: Product = objectMapper.readValue(response.contentAsString  , object : TypeReference<Product>() {})

        assertEquals(HttpStatus.OK.value(), response.status)
        assertEquals(MediaType.APPLICATION_JSON_VALUE, response.contentType)
        assertTrue(product == responseProduct)
    }

    @Test
    fun testUpdateProduct() {
        val productId = 18L
        val product = Product(
            sku = "ABC123",
            name = "Product 1",
            description = "Updated product",
            price = 19.99,
            stock = 55
        )

        `when`(productServiceImp.updateProduct(productId, product)).thenReturn(product)

        val requestBuilder: RequestBuilder = MockMvcRequestBuilders.put("/product/$productId")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(product))

        val result: MvcResult = mockMvc.perform(requestBuilder).andReturn()
        val response: MockHttpServletResponse = result.response

        val responseProduct: Product = objectMapper.readValue(response.contentAsString,object : TypeReference<Product>() {})

        assertEquals(HttpStatus.OK.value(), response.status)
        assertEquals(MediaType.APPLICATION_JSON_VALUE, response.contentType)
        assertTrue(product == responseProduct)
    }
}
