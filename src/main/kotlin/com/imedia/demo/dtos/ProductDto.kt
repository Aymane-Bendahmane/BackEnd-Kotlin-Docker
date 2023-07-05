package com.imedia.demo.dtos;


data class ProductDto(
        var sku: String,
        var name: String,
        var description: String,
        var price: Double,
        var stock: Int
){
    constructor() : this("", "", "", 0.0, 0)

}
