package com.example.designpattern

interface Target {
    fun request()
}

interface Adaptee {
    fun ask()
}

class Adapter(val wrapper: Adaptee) : Target {
    override fun request() {
        wrapper.ask()
    }
}

fun main() {
}