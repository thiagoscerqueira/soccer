package br.com.agility.soccercrud.model

import org.hibernate.annotations.DynamicUpdate
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
@DynamicUpdate
data class Player   (
        @Id @GeneratedValue
        var id: Long = 0,

        var nome: String = "",
        val email: String = "",
        val telefone: String = "",

        var createdAt: LocalDateTime? = null,

        var deletedAt: LocalDateTime? = null) {}