package com.ceo1

import io.ktor.server.application.*
import io.ktor.server.http.content.staticResources
import io.ktor.server.routing.Routing

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureSerialization()
    configureRouting()
}

// static files and images
fun Routing.staticFiles() {
    staticResources("/static", "static")
}