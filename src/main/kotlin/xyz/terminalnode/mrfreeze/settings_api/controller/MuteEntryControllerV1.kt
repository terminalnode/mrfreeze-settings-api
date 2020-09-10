package xyz.terminalnode.mrfreeze.settings_api.controller

import org.springframework.web.bind.annotation.*
import xyz.terminalnode.mrfreeze.settings_api.model.MuteEntry
import xyz.terminalnode.mrfreeze.settings_api.repository.MuteEntryRepository
import java.util.*

@RestController
@RequestMapping("/api/v1/mute_entries")
class MuteEntryControllerV1(
    private val muteEntryRepository: MuteEntryRepository
) {
  
  @PostMapping
  fun create(@RequestBody muteEntry: MuteEntry): MuteEntry {
    muteEntry.id = 0
    return muteEntryRepository.save(muteEntry)
  }

  @GetMapping
  fun getAll(): List<MuteEntry> {
    return muteEntryRepository.findAll()
  }

  @GetMapping("/id/{id}")
  fun getById(@PathVariable id: Long): MuteEntry? {
    val entry = muteEntryRepository.findById(id)
    
    if (entry.isPresent) {
      return entry.get()
    }
    throw IllegalArgumentException("No mute entry with that ID exists.")
  }
  
  @GetMapping("/uid/{userId}")
  fun getByUserId(@PathVariable userId: String): List<MuteEntry> {
    return muteEntryRepository.findAllByUserId(userId)
  }

  @GetMapping("/sid/{serverId}")
  fun getByServerId(@PathVariable serverId: String): List<MuteEntry> {
    return muteEntryRepository.findAllByServerId(serverId)
  }

  @PutMapping
  fun update(@RequestBody muteEntry: MuteEntry): MuteEntry {
    val id: Long = muteEntry.id
        ?: throw java.lang.IllegalArgumentException("A mute entry ID is required.")
    val dbEntry: Optional<MuteEntry> = muteEntryRepository.findById(id);

    if (dbEntry.isPresent) {
      return muteEntryRepository.save(muteEntry)
    }
    throw IllegalArgumentException("No mute entry with that ID exists.")
  }
  
  @DeleteMapping("/id/{id}")
  fun deleteById(@PathVariable id: Long): MuteEntry {
    val dbEntry: Optional<MuteEntry> = muteEntryRepository.findById(id);

    if (dbEntry.isPresent) {
      muteEntryRepository.delete(dbEntry.get())
      return dbEntry.get()
    }
    throw IllegalArgumentException("No mute entry with that ID exists.")
  }
}