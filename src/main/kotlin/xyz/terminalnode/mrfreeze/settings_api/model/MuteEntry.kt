package xyz.terminalnode.mrfreeze.settings_api.model

import javax.persistence.*

@Entity
@Table(
    name = "mute_entries",
    uniqueConstraints= [
      UniqueConstraint(columnNames = [ "server_id" , "user_id" ])
    ]
)
open class MuteEntry {
  @get:Id
  @get:Column(name = "id")
  @get:GeneratedValue(strategy = GenerationType.SEQUENCE)
  open var id: Long? = 0

  @get:Column(name = "server_id", nullable = false)
  open var serverId: String? = ""

  @get:Column(name = "user_id", nullable = false)
  open var userId: String? = ""

  @get:Column(name = "is_voluntary", nullable = false)
  open var isVoluntary: Boolean? = false

  @get:Column(name = "muted_until", nullable = true)
  open var mutedUntil: Long? = null

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (other == null || javaClass != other.javaClass) return false
    
    val that = other as MuteEntry
    if (id != that.id) return false
    return true
  }

  override fun hashCode(): Int {
    if (id != null) return id.hashCode()
    return 0
  }
}
