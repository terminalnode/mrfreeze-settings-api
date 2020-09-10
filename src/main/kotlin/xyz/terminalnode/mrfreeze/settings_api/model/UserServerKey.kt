package xyz.terminalnode.mrfreeze.settings_api.model

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
open class UserServerKey : Serializable {
  @Column(name = "server_id", nullable = false)
  open var serverId: String? = null

  @Column(name = "user_id", nullable = false)
  open var userId: String? = null
  
  
  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (other == null || javaClass != other.javaClass) return false

    val that = other as UserServerKey
    if (serverId != that.serverId) return false
    if (userId != that.userId) return false
    return true
  }


  override fun hashCode(): Int {
    val prime = 31
    val sidHash: Int = serverId.hashCode() * prime
    val uidHash: Int = userId.hashCode() * prime
    return sidHash * uidHash
  }
}