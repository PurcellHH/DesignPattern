package com.example.designpattern

interface AbstractHandler {
    val next: AbstractHandler?
    fun handleRequest() : String?
}

class ReplayMissionHandler(override val next: AbstractHandler?) : AbstractHandler {
    override fun handleRequest() : String? {
        println("ReplayMissionHandler")
        return next?.handleRequest()
    }
}

class LoadMissionHandler(override val next: AbstractHandler?) : AbstractHandler {
    override fun handleRequest() : String? {
        println("LoadMissionHandler")
        if (true){
            return "Load Mission Error!!!"
        }
        return next?.handleRequest()
    }
}

class UploadMissionHandler(override val next: AbstractHandler?) : AbstractHandler {
    override fun handleRequest() : String? {
        println("UploadMissionHandler")
        return next?.handleRequest()
    }
}

fun main() {
    var replayMissionHandler = ReplayMissionHandler(LoadMissionHandler(UploadMissionHandler(null)))
    var error = replayMissionHandler.handleRequest()
    println(error)
}