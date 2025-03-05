package com.ceo1

import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.statuspages.StatusPages
import io.ktor.server.response.respondText
import io.ktor.server.routing.*
import kotlinx.html.*

class MainTemplate(val titleText:String) :Template<HTML>{
    val content = Placeholder<FlowContent>()
    override fun HTML.apply(){
        head{
            title(titleText)
            // Include Tailwind CSS
            link(rel = "stylesheet", href = "https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css")
            // Include HTMX
            script(src = "https://unpkg.com/htmx.org@1.9.2") {}
        }
        body{
            div(classes = "flex h-screen p-20") {
                div(classes = "flex-col") {
                    h1(classes = "relative size-32 font-mono text-2xl font-bold") { +"QR GEN" }
                    hr()
                    ul(classes = "m-4") {
                        li(classes = "ml-2 my-8") {
                            a(href = "#") { +"Website" }
                        }
                        li(classes = "ml-2 my-8") {
                            a(href = "#") { +"Text Message" }
                        }
                        li(classes = "ml-2 my-8") {
                            a(href = "#") { +"Image" }
                        }
                        li(classes = "ml-2 my-8") {
                            a(href = "#") { +"Google Docs" }
                        }
                        li(classes = "ml-2 my-8") {
                            a(href = "#") { +"FaceBook" }
                        }
                        li(classes = "ml-2 my-8") {
                            a(href = "#") { +"Youtube" }
                        }
                        li(classes = "ml-2 my-8") {
                            a(href = "#") { +"SnapChat" }
                        }
                        li(classes = "ml-2 my-8") {
                            a(href = "#") { +"X" }
                        }
                    }
                }
                div(classes = "flex-col"){
                    insert(content)
                }
            }

        }
    }
}

fun Application.configureRouting() {
    install(StatusPages){
        exception<Exception>{ call, cause ->
            call.respondText("App as illegal state as ${cause.message}")
        }
    }
    routing {
        get("/") {
            val title = "QR GENERATOR"
            call.respondHtmlTemplate(MainTemplate(title)) {
                content {

                }
            }
        }
        // Static plugin. To access `/static`
        staticResources("/static", "static")
    }
}

