package br.com.agility.soccerbackend.model

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Jogador   (
        @Id @GeneratedValue
        var id: Long = 0,

        var nome: String = "",
        val email: String = "",
        var createdAt: LocalDateTime? = null,
        val deletedAt: LocalDateTime? = null) {




}