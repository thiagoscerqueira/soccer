package br.com.agility.soccerbackend.controller

import br.com.agility.soccerbackend.model.PagamentoJogador
import br.com.agility.soccerbackend.service.PagamentoJogadorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RestController
@RequestMapping("/pagamentos-jogadores")
@CrossOrigin
class PagamentoJogadorController {

    @Autowired
    lateinit var pagamentoJogadorService: PagamentoJogadorService;

    @GetMapping
    fun list(@RequestParam("anoMesReferencia") anoMesReferencia: LocalDate): ResponseEntity<List<PagamentoJogador>> {
        return ResponseEntity.ok(pagamentoJogadorService.list(anoMesReferencia));
    }

    @PostMapping
    fun add(@RequestBody pagamentoJogador: PagamentoJogador): ResponseEntity<PagamentoJogador> {
        return ResponseEntity.status(HttpStatus.CREATED).body(pagamentoJogadorService.add(pagamentoJogador));
    }

    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody pagamentoJogador: PagamentoJogador): ResponseEntity<PagamentoJogador> {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(pagamentoJogadorService.alter(id, pagamentoJogador));
    }
}