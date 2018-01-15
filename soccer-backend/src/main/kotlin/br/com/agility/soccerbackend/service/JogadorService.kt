package br.com.agility.soccerbackend.service

import br.com.agility.soccerbackend.model.Jogador
import br.com.agility.soccerbackend.repository.JogadorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class JogadorService {

    @Autowired
    lateinit var jogadorRepository: JogadorRepository;

    fun list(): List<Jogador> {
        return jogadorRepository.findAll();
    }

    fun add(jogador: Jogador): Jogador {
        jogador.createdAt = LocalDateTime.now();
        return jogadorRepository.save(jogador);
    }

    fun alter(id: Long, jogador: Jogador): Jogador {
        if (jogadorRepository.exists(id)) {
            val safeJogador = jogador.copy(id);
            return jogadorRepository.save(safeJogador);
        }

        return Jogador();
    }

    fun delete(id: Long) {
        if (jogadorRepository.exists(id)) {
            jogadorRepository.delete(id);
        }
    }
}