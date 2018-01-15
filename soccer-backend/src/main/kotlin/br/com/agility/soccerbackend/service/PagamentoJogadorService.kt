package br.com.agility.soccerbackend.service

import br.com.agility.soccerbackend.model.PagamentoJogador
import br.com.agility.soccerbackend.repository.JogadorRepository
import br.com.agility.soccerbackend.repository.PagamentoJogadorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDate
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

    fun save(pagamentoJogador: PagamentoJogador) {
        pagamentoJogadorRepository.save(pagamentoJogador);
    }

    fun delete(pagamentoJogador: PagamentoJogador) {
        if (pagamentoJogadorRepository.exists(pagamentoJogador.id)) {
            pagamentoJogadorRepository.delete(pagamentoJogador);
        }
    }
}