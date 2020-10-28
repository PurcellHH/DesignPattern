package com.example.designpattern

data class CloudTask(var currentState: BaseState?){
    fun turnBack() {
        currentState = currentState?.turnBack()
    }

    fun takeoff() {
        currentState = currentState?.takeoff()
    }
}

abstract class BaseState(val flightTask: CloudTask) {
    abstract val state: String
    open fun turnBack(): BaseState {
        println("当前状态${state},不支持返航")
        return this
    }

    open fun takeoff(): BaseState {
        println("当前状态${state},不支持起飞")
        return this
    }
}

class AvailableState(flightTask: CloudTask) : BaseState(flightTask) {
    override val state: String = "available"

    override fun takeoff(): BaseState {
        println("当前状态${state},正在起飞")
        return TakingOffState(flightTask)
    }

}

class TakingOffState(flightTask: CloudTask) : BaseState(flightTask) {
    override val state: String = "takingoff"

    override fun turnBack(): BaseState {
        println("当前状态${state},正在返航")
        return ReturnningState(flightTask)
    }
}

class ReturnningState(flightTask: CloudTask) : BaseState(flightTask) {
    override val state: String = "returnning"
}

fun main() {
    val flightTask = CloudTask(null)
    flightTask.currentState = AvailableState(flightTask)
    flightTask.turnBack()
    flightTask.takeoff()
    flightTask.turnBack()
    flightTask.takeoff()
}