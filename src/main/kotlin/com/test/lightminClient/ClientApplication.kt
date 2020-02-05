package com.test.lightminClient

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.runApplication
import org.tuxdevelop.spring.batch.lightmin.client.classic.annotation.EnableLightminClientClassic
import org.tuxdevelop.spring.batch.lightmin.repository.annotation.EnableLightminJdbcConfigurationRepository


@SpringBootApplication
@EnableLightminClientClassic
@EnableLightminJdbcConfigurationRepository
class ClientApplication

fun main(args: Array<String>) {
    SpringApplicationBuilder()
            .sources(ClientApplication::class.java)
            .profiles("client")
            .run(*args)
    //runApplication<ClientApplication>(*args)
}