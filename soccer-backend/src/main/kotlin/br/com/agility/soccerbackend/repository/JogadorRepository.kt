package br.com.agility.soccerbackend.repository

import br.com.agility.soccerbackend.model.Jogador
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JogadorRepository : JpaRepository<Jogador, Long> {
}