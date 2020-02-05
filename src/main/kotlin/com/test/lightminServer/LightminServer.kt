package com.test.lightminServer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.runApplication
import org.tuxdevelop.spring.batch.lightmin.server.annotation.EnableLightminServer



@EnableLightminServer
@SpringBootApplication
class LightminServer

fun main(args: Array<String>) {
    SpringApplicationBuilder()
            .sources(LightminServer::class.java)
            .profiles("server")
            .run(*args)
    //runApplication<LightminServer>(*args)
}
