package br.com.agility.soccerbackend.controller

import br.com.agility.soccerbackend.model.Jogador
import br.com.agility.soccerbackend.service.JogadorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/jogadores")
class JogadorController {

    @Autowired
    lateinit var jogadorService: JogadorService;

    @GetMapping
    fun list(): List<Jogador> {
        return jogadorService.list();
    }

    @PostMapping
    fun add(@RequestBody jogador: Jogador): Jogador {
        return jogadorService.add(jogador);
    }

    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody jogador: Jogador): Jogador {
        return jogadorService.alter(id, jogador);
    }
}