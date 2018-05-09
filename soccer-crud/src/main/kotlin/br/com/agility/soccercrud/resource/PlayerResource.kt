package br.com.agility.soccercrud.resource

import br.com.agility.soccercrud.model.Player
import br.com.agility.soccercrud.service.PlayerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/players")
@CrossOrigin
class PlayerResource {

    @Autowired
    lateinit var playerService: PlayerService;

    @GetMapping
    fun list(): ResponseEntity<List<Player>> {
        return ResponseEntity.ok(playerService.list());
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): ResponseEntity<Player> {
        val player: Player? = playerService.get(id);
        if (player == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(player);
    }

    @PostMapping
    fun add(@RequestBody player: Player): ResponseEntity<Player> {
        return ResponseEntity.status(HttpStatus.CREATED).body(playerService.add(player));
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody player: Player): ResponseEntity<Player> {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(playerService.alter(id, player));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun delete(@PathVariable id: Long) {
        playerService.delete(id);
    }
}