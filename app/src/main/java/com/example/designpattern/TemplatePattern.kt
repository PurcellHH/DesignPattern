package com.example.designpattern

data class DyiWaypoint(val lat: Double, val lon: Double, var alt: Double)
data class DyiWaypointAction(val actionType: String, val actionParams: String)

open abstract class BaseMision{
    var waypoints: List<DyiWaypoint>? = null
    var waypointActions: List<DyiWaypointAction>? = null
    val missionID: Int? = null
    open fun initMission() {
        buildWaypoints()
        buildWaypointsActions()
    }
    abstract fun buildWaypoints()
    abstract fun buildWaypointsActions()
}

class ChannelMission : BaseMision() {
    override fun buildWaypoints() {
        TODO("Not yet implemented")
    }

    override fun buildWaypointsActions() {
        TODO("Not yet implemented")
    }
}

class GoBackMission : BaseMision() {
    override fun buildWaypoints() {
        TODO("Not yet implemented")
    }

    override fun buildWaypointsActions() {
        TODO("Not yet implemented")
    }
}

fun main() {

}