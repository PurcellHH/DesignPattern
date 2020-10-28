package com.example.designpattern

data class Waypoint(val lat: Double, val lon: Double, var alt: Double)

class Mission() {
    var waypoints: List<Waypoint>? = null
    var maxFlightSpeed: Double? = null
    var autoFlightSpeed: Double = 10.0

    override fun toString(): String {
        return "Mission(waypoints=$waypoints, maxFlightSpeed=$maxFlightSpeed, autoFlightSpeed=$autoFlightSpeed)"
    }
}

class DyMission(
    var waypoints: List<Waypoint>?,
    var maxFlightSpeed: Double?,
    var autoFlightSpeed: Double = 10.0
) {
    private constructor(builder: Builder) : this(
        builder.waypoints,
        builder.maxFlightSpeed,
        builder.autoFlightSpeed
    )

    class Builder {
        var waypoints: List<Waypoint>? = null
        var maxFlightSpeed: Double? = null
        var autoFlightSpeed: Double = 10.0
        fun build() = DyMission(this)
    }

    companion object {
        fun build(block: Builder.() -> Unit) = Builder().apply(block).build()

    }

    override fun toString(): String {
        return "Mission(waypoints=$waypoints, maxFlightSpeed=$maxFlightSpeed, autoFlightSpeed=$autoFlightSpeed)"
    }
}

fun main() {
    //利用apply函数
    var mission = Mission().apply {
        waypoints = listOf(Waypoint(12.0, 31.0, 41.0), Waypoint(22.0, 131.0, 41.0))
        maxFlightSpeed = 15.0
    }
    println(mission)

    var dyMission = DyMission.build {
        waypoints = listOf(Waypoint(12.0, 31.0, 41.0), Waypoint(22.0, 131.0, 41.0))
        maxFlightSpeed = 15.0
    }
    println(dyMission)

    val waypoint = Waypoint(12.0, 31.0, 41.0)
    var waypoint01 = waypoint.copy()
    waypoint01.alt = 231.0
    println(waypoint)
    println(waypoint01)
    println(waypoint)

}