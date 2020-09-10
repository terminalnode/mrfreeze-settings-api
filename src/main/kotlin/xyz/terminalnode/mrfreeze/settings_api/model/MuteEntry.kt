package xyz.terminalnode.mrfreeze.settings_api.model

import com.fasterxml.jackson.annotation.JsonUnwrapped
import javax.persistence.*

@Entity
@Table(
    name = "mute_entries",
    indexes = [
      Index(name = "MUTE_ENTRY_IDX_1", columnList = "muted_until"),
      Index(name = "MUTE_ENTRY_IDX_2", columnList = "is_voluntary")
    ]
)
open class MuteEntry {
  @get:EmbeddedId
  @get:JsonUnwrapped
  open var userServerKey: UserServerKey? = null

  @get:Column(name = "is_voluntary", nullable = false)
  open var isVoluntary: Boolean? = false

  @get:Column(name = "muted_until", nullable = true)
  open var mutedUntil: Long? = null


  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (other == null || javaClass != other.javaClass) return false
    
    val that = other as MuteEntry
    if (userServerKey != that.userServerKey) return false
    return true
  }


  override fun hashCode(): Int {
    return userServerKey.hashCode()
  }
}

