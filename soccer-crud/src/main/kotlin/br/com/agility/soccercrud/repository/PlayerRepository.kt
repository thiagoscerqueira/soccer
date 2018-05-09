package br.com.agility.soccercrud.repository

import br.com.agility.soccercrud.model.Player
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PlayerRepository : JpaRepository<Player, Long> {

    fun findByDeletedAtIsNull() : List<Player>
}