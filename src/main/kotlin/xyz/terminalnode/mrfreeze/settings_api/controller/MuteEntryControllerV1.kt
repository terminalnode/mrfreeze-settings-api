package xyz.terminalnode.mrfreeze.settings_api.controller

import org.springframework.web.bind.annotation.*
import xyz.terminalnode.mrfreeze.settings_api.model.MuteEntry
import xyz.terminalnode.mrfreeze.settings_api.model.UserServerKey
import xyz.terminalnode.mrfreeze.settings_api.repository.MuteEntryRepository

@RestController
@RequestMapping("/api/v1/mute_entries")
class MuteEntryControllerV1(
    private val muteEntryRepository: MuteEntryRepository
) {
  
  fun getByUserServerKey(serverId: String, userId: String): MuteEntry {
    val key = UserServerKey()
    key.userId = userId
    key.serverId = serverId
    val muteEntry = muteEntryRepository.findById(key)

    if (muteEntry.isEmpty) {
      throw IllegalArgumentException("No mute entry with that ID exists.")
    }
    return muteEntry.get()
  }
  
  fun deleteByUserServerKey(serverId: String, userId: String): MuteEntry {
    val muteEntry = getByUserServerKey(serverId, userId)
    muteEntryRepository.delete(muteEntry)
    return muteEntry
  }
  
  fun getEntryOrNull(muteEntry: MuteEntry): MuteEntry? {
    val key: UserServerKey = muteEntry.userServerKey
        ?: throw IllegalArgumentException("Missing user and/or server.")

    if (key.serverId == null || key.userId == null) {
      throw IllegalArgumentException("Missing user and/or server.")
    }

    val dbEntry = muteEntryRepository.findById(key)
    if (dbEntry.isPresent) return dbEntry.get()
    return null
  }
  
  @PostMapping
  fun create(@RequestBody muteEntry: MuteEntry): MuteEntry {
    getEntryOrNull(muteEntry)
    return muteEntryRepository.save(muteEntry)
  }

  @GetMapping
  fun getAll(): List<MuteEntry> {
    return muteEntryRepository.findAll()
  }

  @GetMapping("/server/{sid}/user/{uid}")
  fun getBySidUid(@PathVariable sid: String, @PathVariable uid: String): MuteEntry {
    return getByUserServerKey(sid, uid)
  }

  @GetMapping("/user/{uid}/server/{sid}")
  fun getByUidSid(@PathVariable sid: String, @PathVariable uid: String): MuteEntry {
    return getByUserServerKey(sid, uid)
  }

  @GetMapping("/uid/{userId}")
  fun getByUserId(@PathVariable userId: String): List<MuteEntry> {
    return muteEntryRepository.findAllByUserServerKeyUserId(userId)
  }

  @GetMapping("/sid/{serverId}")
  fun getByServerId(@PathVariable serverId: String): List<MuteEntry> {
    return muteEntryRepository.findAllByUserServerKeyServerId(serverId)
  }

  @GetMapping("/due/now")
  fun getMuteEntriesThatAreDue(): List<MuteEntry> {
    return muteEntryRepository.findAllByMutedUntilLessThan(System.currentTimeMillis() / 1000)
  }

  @GetMapping("/due/never")
  fun getMuteEntriesThatAreNeverDue(): List<MuteEntry> {
    return muteEntryRepository.findAllByMutedUntilIsNull()
  }

  @PutMapping
  fun update(@RequestBody muteEntry: MuteEntry): MuteEntry {
    if (getEntryOrNull(muteEntry) == null) {
      throw IllegalArgumentException("No mute entry with that server and user exists.")
    }

    return muteEntryRepository.save(muteEntry)
  }
  
  @DeleteMapping("/server/{sid}/user/{uid}")
  fun deleteBySidUid(@PathVariable sid: String, @PathVariable uid: String): MuteEntry {
    return deleteByUserServerKey(sid, uid)
  }

  @DeleteMapping("/user/{uid}/server/{sid}")
  fun deleteByUidSid(@PathVariable sid: String, @PathVariable uid: String): MuteEntry {
    return deleteByUserServerKey(sid, uid)
  }
}