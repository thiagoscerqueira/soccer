package br.com.agility.soccerbackend.repository

import br.com.agility.soccerbackend.model.PagamentoJogador
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface PagamentoJogadorRepository : JpaRepository<PagamentoJogador, Long> {

    @Query("select p from PagamentoJogador p join fetch p.jogador jogador where p.anoMesReferencia=:anoMesReferencia")
    fun list(@Param("anoMesReferencia") anoMesReferencia: LocalDate): List<PagamentoJogador>;
}