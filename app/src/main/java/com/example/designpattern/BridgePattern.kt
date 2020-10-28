package com.example.designpattern

interface Brand{
    fun sale()
}

class Lenovo : Brand{
    override fun sale() {
        println("Lenovo sale")
    }
}

class Dell : Brand{
    override fun sale() {
        println("Dell sale")
    }
}

open class PC(val brand: Brand){
    open fun sale(){
        brand.sale()
    }
}

class Desktop(brand: Brand) : PC(brand){
    override fun sale() {
        super.sale()
        println("出售台式电脑")
    }
}
class Laptop (brand: Brand) : PC(brand){
    override fun sale() {
        super.sale()
        println("出售笔记本")
    }
}

fun main() {
    var desktop = Desktop(Dell())
    desktop.sale()

    var laptop = Laptop(Lenovo())
    laptop.sale()
}