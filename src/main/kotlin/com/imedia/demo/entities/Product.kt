package com.imedia.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    var id: Long = 0,
    val sku: String,
    val name: String,
    val description: String,
    val price: Double,
    val stock: Int


){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true

        other as Product

        if (id != other.id) return false
        if (sku != other.sku) return false
        if (name != other.name) return false
        if (description != other.description) return false
        if (price != other.price) return false
        if (stock != other.stock) return false

        return true
    }
    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + sku.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + price.hashCode()
        result = 31 * result + stock
        return result
    }
}
