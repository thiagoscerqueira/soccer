package br.com.agility.soccercrud.service

import br.com.agility.soccercrud.model.Player
import br.com.agility.soccercrud.repository.PlayerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*

@Service
class PlayerService {

    @Autowired
    lateinit var playerRepository: PlayerRepository;

    fun list(): List<Player> {
        return playerRepository.findByDeletedAtIsNull();
    }

    fun get(id: Long) : Player {
        return playerRepository.findOne(id);
    }

    fun add(player: Player): Player {
        player.createdAt = LocalDateTime.now();
        return playerRepository.save(player);
    }

    fun alter(id: Long, player: Player): Player {
        val playerDB = Optional.ofNullable(playerRepository.findOne(id));
        if (playerDB.isPresent) {
            val safePlayer = playerDB.get().copy(nome = player.nome, email = player.email, telefone = player.telefone);
            return playerRepository.save(safePlayer);
        }

        return Player();
    }

    fun delete(id: Long) {
        val playerDB = Optional.ofNullable(playerRepository.findOne(id));
        if (playerDB.isPresent) {
            val player = playerDB.get();
            player.deletedAt = LocalDateTime.now();
            playerRepository.save(player);
        }
    }
}