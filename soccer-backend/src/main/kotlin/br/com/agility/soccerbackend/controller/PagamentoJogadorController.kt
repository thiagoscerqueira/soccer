package br.com.agility.soccerbackend.controller

import br.com.agility.soccerbackend.model.PagamentoJogador
import br.com.agility.soccerbackend.service.PagamentoJogadorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RestController
@RequestMapping("/pagamentos-jogadores")
class PagamentoJogadorController {

    @Autowired
    lateinit var pagamentoJogadorService: PagamentoJogadorService;

    @GetMapping
    fun list(@RequestParam("anoMesReferencia") anoMesReferencia: LocalDate): List<PagamentoJogador> {
        return pagamentoJogadorService.list(anoMesReferencia);
    }

    @PostMapping
    fun add(@RequestBody pagamentoJogador: PagamentoJogador): PagamentoJogador {
        return pagamentoJogadorService.add(pagamentoJogador);
    }

    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody pagamentoJogador: PagamentoJogador): PagamentoJogador? {
        return pagamentoJogadorService.alter(id, pagamentoJogador);
    }
}