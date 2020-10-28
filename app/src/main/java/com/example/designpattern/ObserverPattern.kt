package com.example.designpattern

interface Observer {
    fun <T : Any?> update(msg: T)
}

class ObserverA(private val id: Int = 0) : Observer {
    override fun <T> update(msg: T) {
        println("接收消息，观察者$id:$msg")
    }
}

class Subject {

    //存放观察者
    private  var observers =  ArrayList<Observer>()
    //订阅观察者
    fun attach(ob: Observer) {
        observers.add(ob)
    }
    //设置数据
    fun <T : Any?> setMsg(msg: T) {
        this.notify(msg)
    }
    //更新数据
    private fun <T : Any?> notify(msg: T) {
        for (iOb in this.observers) {
            iOb.update(msg)
        }
    }
}

fun main() {
    var subject = Subject().apply {
        attach(ObserverA(0))
        attach(ObserverA(1))
        attach(ObserverA(2))
        attach(ObserverA(3))
    }
    with(subject){
        setMsg("hello")
        setMsg("kotlin")
        setMsg("design")
        setMsg("pattern")
    }
}