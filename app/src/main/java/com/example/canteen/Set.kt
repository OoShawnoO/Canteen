package com.example.canteen

class Set {
    var id:Int ?= null
    var name:String? = null
    var price:String? = null
    var count:Int = 0
    var Image:Int = 0

    companion object{
        val TABLE = "Set"
        val COL_ID = "id"
        val COL_NAME = "name"
        val COL_PRICE = "price"
        val COL_COUNT = "count"
        val COL_IMAGE = "image"
    }
}