package xyz.terminalnode.mrfreeze.settings_api.repository

import org.springframework.data.jpa.repository.JpaRepository
import xyz.terminalnode.mrfreeze.settings_api.model.MuteEntry
import xyz.terminalnode.mrfreeze.settings_api.model.UserServerKey

interface MuteEntryRepository : JpaRepository<MuteEntry, UserServerKey> {
  fun findAllByUserServerKeyServerId(serverId: String?): List<MuteEntry>
  fun findAllByUserServerKeyUserId(userId: String?): List<MuteEntry>
  fun findAllByMutedUntilLessThan(unixTime: Long): List<MuteEntry>
  fun findAllByMutedUntilIsNull(): List<MuteEntry>
}