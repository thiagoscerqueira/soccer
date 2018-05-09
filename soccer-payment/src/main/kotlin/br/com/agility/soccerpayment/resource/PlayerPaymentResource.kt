package br.com.agility.soccerpayment.resource

import br.com.agility.soccerpayment.model.PlayerPayment
import br.com.agility.soccerpayment.service.PlayerPaymentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.YearMonth
import javax.validation.Valid

@RestController
@RequestMapping("/players")
@CrossOrigin
class PlayerPaymentResource {

    @Autowired
    lateinit var playerPaymentService: PlayerPaymentService;

    @GetMapping
    fun list(@RequestParam("yearMonthISO") @DateTimeFormat(pattern = "yyyy-MM") yearMonth: YearMonth): ResponseEntity<List<PlayerPayment>> {
        return ResponseEntity.ok(playerPaymentService.list(yearMonth));
    }

    @PostMapping
    fun add(@RequestBody @Valid playerPayment: PlayerPayment): ResponseEntity<PlayerPayment> {
        return ResponseEntity.status(HttpStatus.CREATED).body(playerPaymentService.add(playerPayment));
    }

    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody playerPayment: PlayerPayment): ResponseEntity<PlayerPayment> {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(playerPaymentService.alter(id, playerPayment));
    }
}