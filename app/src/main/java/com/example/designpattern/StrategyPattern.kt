package com.example.designpattern

interface LogStrategy {
    fun <T : Any?> log(msg: T)
}

class FileLogStrategy : LogStrategy {
    override fun <T> log(msg: T) {
        println("输出到文件--$msg")
    }
}

class UILogStrategy : LogStrategy {
    override fun <T> log(msg: T) {
        println("输出到UI--$msg")
    }
}

class ConsoleLogStrategy : LogStrategy {
    override fun <T> log(msg: T) {
        println("输出到控制台--$msg")
    }
}

class LogCenter(var logStrategy: LogStrategy) {
    fun <T> log(msg: T) {
        logStrategy.log(msg)
    }
}

fun main() {
    var logCenter = LogCenter(FileLogStrategy())
    logCenter.log("Hello Strategy Pattern")
    logCenter.logStrategy = UILogStrategy()
    logCenter.log("Hello Strategy Pattern")
    logCenter.logStrategy = ConsoleLogStrategy()
    logCenter.log("Hello Strategy Pattern")
}