package com.techprd.cheeseria

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CheeseriaApplication

fun main(args: Array<String>) {
    runApplication<CheeseriaApplication>(*args)
}
