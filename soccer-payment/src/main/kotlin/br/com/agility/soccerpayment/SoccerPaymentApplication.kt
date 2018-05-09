package br.com.agility.soccerpayment

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class SoccerBackendApplication

fun main(args: Array<String>) {
    SpringApplication.run(SoccerBackendApplication::class.java, *args)
}