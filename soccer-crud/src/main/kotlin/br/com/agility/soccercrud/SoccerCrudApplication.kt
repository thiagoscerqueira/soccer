package br.com.agility.soccercrud

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication



@SpringBootApplication
class SoccerCrudApplication

fun main(args: Array<String>) {
    SpringApplication.run(SoccerCrudApplication::class.java, *args)
}