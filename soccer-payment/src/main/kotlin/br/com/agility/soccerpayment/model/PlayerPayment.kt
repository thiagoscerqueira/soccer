package br.com.agility.soccerpayment.model

import org.hibernate.annotations.DynamicUpdate
import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.YearMonth
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.NotNull

@Entity
@DynamicUpdate
data class PlayerPayment(
        @Id @GeneratedValue
        val id: Long = 0,

        @get: NotNull
        val yearAndMonth: YearMonth? = null,

        @get: NotNull
        val idPlayer: Long? = null,

        @get: NotNull
        var amount: BigDecimal? = null,

        var createdAt: LocalDateTime? = null,
        val deletedAt: LocalDateTime? = null) {
}