package com.example.designpattern

object Singleton {
    fun method() {
        println("Singleton-------method")
    }
}

class Singleton01 {
    private constructor()

    companion object {
        //val instance:Singleton01 = Singleton01()
        //懒加载  lazy线程安全
        val instance01: Singleton01 by lazy { Singleton01() }
    }

    fun method() {
        println("Singleton01-------method")
    }
}


fun main() {
    Singleton.method()

    Singleton01.instance01.method()
}