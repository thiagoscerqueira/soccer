package br.com.agility.soccerbackend.controller

import br.com.agility.soccerbackend.model.Jogador
import br.com.agility.soccerbackend.service.JogadorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/jogadores")
@CrossOrigin
class JogadorController {

    @Autowired
    lateinit var jogadorService: JogadorService;

    @GetMapping
    fun list(): ResponseEntity<List<Jogador>> {
        return ResponseEntity.ok(jogadorService.list());
    }

    @PostMapping
    fun add(@RequestBody jogador: Jogador): ResponseEntity<Jogador> {
        return ResponseEntity(jogadorService.add(jogador), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody jogador: Jogador): ResponseEntity<Jogador> {
        return ResponseEntity(jogadorService.alter(id, jogador), HttpStatus.ACCEPTED);
    }
}