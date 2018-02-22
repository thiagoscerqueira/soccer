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

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): ResponseEntity<Jogador> {
        val jogador: Jogador? = jogadorService.get(id);
        if (jogador == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(jogador);
    }

    @PostMapping
    fun add(@RequestBody jogador: Jogador): ResponseEntity<Jogador> {
        return ResponseEntity.status(HttpStatus.CREATED).body(jogadorService.add(jogador));
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody jogador: Jogador): ResponseEntity<Jogador> {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(jogadorService.alter(id, jogador));
    }
}