package com.example.designpattern

data class Memento(var missionState: String)

class FlightTask(var missionState: String) {
    fun pause(): Memento = Memento(missionState)
    fun resume(memento: Memento) {
        this.missionState = memento.missionState
    }
    override fun toString(): String {
        return "FlightTask(missionState='$missionState')"
    }

    fun switchState(state: String) {
        missionState = state
    }

}

//class MementoBox{
//    var memento : Memento? = null
//}

fun main() {
    var memento: Memento? = null
    val flightTask = FlightTask("takeoff")
    memento = flightTask.pause()
    println(flightTask)
    flightTask.switchState("land")
    println(flightTask)
    flightTask.resume(memento)
    println(flightTask)
}