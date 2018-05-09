package br.com.agility.soccercrud.resource

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/home")
class HomeResource {

    @GetMapping
    fun home(): String {
        return "Olá, mundo!"
    }
}