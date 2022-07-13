package com.cherry.cherrybackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class CherryBackendApplication

fun main(args: Array<String>) {
	runApplication<CherryBackendApplication>(*args)
}
