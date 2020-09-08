package xyz.terminalnode.mrfreeze.settings_api.model

import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "mutes")
data class Mute(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long = 0,

    @Column(name = "server_id", nullable = false)
    val serverId: String,

    @Column(name = "user_id", nullable = false)
    val userId: String,

    @Column(name = "is_voluntary", nullable = false)
    val isVoluntary: Boolean = false,

    @Column(name = "muted_until", nullable = true)
    val mutedUntil: Timestamp? = null
)
