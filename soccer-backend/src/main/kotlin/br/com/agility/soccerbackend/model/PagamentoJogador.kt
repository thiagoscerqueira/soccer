package br.com.agility.soccerbackend.model

import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class PagamentoJogador(
        @Id @GeneratedValue
        val id: Long = 0,

        val anoMesReferencia: LocalDate? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "idJogador", referencedColumnName = "id")
        val jogador: Jogador? = null,

        val valor: BigDecimal = BigDecimal.ZERO,
        var createdAt: LocalDateTime? = null,
        val deletedAt: LocalDateTime? = null) {
}