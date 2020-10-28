package com.example.designpattern

interface Computer {
    val name: String
}

interface Phone {
    val name: String
}

class ComputerA(override val name: String = "ComputerA") : Computer {
    init {
        println(name)
    }
}

class ComputerB(override val name: String = "ComputerB") : Computer {
    init {
        println(name)
    }
}

class PhoneA(override val name: String = "PhoneA") : Phone {
    init {
        println(name)
    }
}

class PhoneB(override val name: String = "PhoneB") : Phone {
    init {
        println(name)
    }
}

interface Factory {
    fun makeComputer(): Computer
    fun makePhone(): Phone
}

class FactoryA : Factory {
    override fun makeComputer() = ComputerA()
    override fun makePhone() = PhoneA()
}

class FactoryB : Factory {
    override fun makeComputer() = ComputerB()
    override fun makePhone() = PhoneB()
}

fun main() {
    var factory: Factory = FactoryA()
    factory.makeComputer()
    factory.makePhone()
    factory = FactoryB()
    factory.makeComputer()
    factory.makePhone()
}