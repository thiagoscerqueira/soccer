package br.com.agility.soccerpayment.service

import br.com.agility.soccerpayment.model.PlayerPayment
import br.com.agility.soccerpayment.repository.PlayerPaymentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.YearMonth
import java.util.*

@Service
class PlayerPaymentService {

    @Autowired
    lateinit var playerPaymentRepository: PlayerPaymentRepository;

    fun list(yearMonth: YearMonth): List<PlayerPayment> {
        return playerPaymentRepository.list(yearMonth);
    }

    fun add(playerPayment: PlayerPayment): PlayerPayment {
        playerPayment.createdAt = LocalDateTime.now();
        return playerPaymentRepository.save(playerPayment);
    }

    fun alter(id: Long, playerPayment: PlayerPayment): PlayerPayment {
        val playerPaymentOpt = Optional.ofNullable(playerPaymentRepository.findOne(id));
        if (playerPaymentOpt.isPresent) {
            val playerPaymentDB = playerPaymentOpt.get();
            playerPaymentDB.amount = playerPayment.amount;
            return playerPaymentRepository.save(playerPaymentDB);
        }

        return PlayerPayment();
    }

    fun delete(playerPayment: PlayerPayment) {
        if (playerPaymentRepository.exists(playerPayment.id)) {
            playerPaymentRepository.delete(playerPayment);
        }
    }
}