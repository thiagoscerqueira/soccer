package br.com.agility.soccerbackend.service

import br.com.agility.soccerbackend.model.PagamentoJogador
import br.com.agility.soccerbackend.repository.JogadorRepository
import br.com.agility.soccerbackend.repository.PagamentoJogadorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.function.Consumer

@Service
class PagamentoJogadorService {

    @Autowired
    lateinit var pagamentoJogadorRepository: PagamentoJogadorRepository;

    @Autowired
    lateinit var jogadorRepository: JogadorRepository;

    fun list(anoMesReferencia: LocalDate): List<PagamentoJogador> {
        var listaPagamentos = pagamentoJogadorRepository.list(anoMesReferencia);

        var listaJogadoresSemPagamento = jogadorRepository.findAll()
                .filter { i -> !listaPagamentos.map { j -> j.jogador }.contains(i) };

        listaJogadoresSemPagamento.forEach(
                Consumer { i ->
                    listaPagamentos.plus(PagamentoJogador(anoMesReferencia = anoMesReferencia, jogador = i))
                });

        return listaPagamentos;
    }

    fun add(pagamentoJogador: PagamentoJogador): PagamentoJogador {
        pagamentoJogador.createdAt = LocalDateTime.now();
        return pagamentoJogadorRepository.save(pagamentoJogador);
    }

    fun alter(id: Long, pagamentoJogador: PagamentoJogador): PagamentoJogador? {
        if (pagamentoJogadorRepository.exists(id)) {
            val safePagamentoJogador = pagamentoJogador.copy(id);
            return pagamentoJogadorRepository.save(safePagamentoJogador);
        }

        return PagamentoJogador();
    }

    fun delete(pagamentoJogador: PagamentoJogador) {
        if (pagamentoJogadorRepository.exists(pagamentoJogador.id)) {
            pagamentoJogadorRepository.delete(pagamentoJogador);
        }
    }
}