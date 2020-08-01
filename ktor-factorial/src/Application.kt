package com.synclab.internship

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.http.*
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {

    val kodein = Kodein {
        bind<FactorialService>() with singleton { FactorialService() }
    }

    val factorialService: FactorialService by kodein.instance()

    routing {
        get("/factorial/{number}") {
            call.respondText(
                factorialService.factorial(call.parameters["number"]?.toInt()).toString(),
                contentType = ContentType.Text.Plain)
        }
    }
}

