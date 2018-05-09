package br.com.agility.soccerpayment.repository

import br.com.agility.soccerpayment.model.PlayerPayment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.time.YearMonth

@Repository
interface PlayerPaymentRepository : JpaRepository<PlayerPayment, Long> {

    @Query("select p from PlayerPayment p where p.yearAndMonth=:yearAndMonth")
    fun list(@Param("yearAndMonth") yearMonth: YearMonth): List<PlayerPayment>;
}