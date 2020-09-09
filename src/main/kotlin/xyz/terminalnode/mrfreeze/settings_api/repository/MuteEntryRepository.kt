package xyz.terminalnode.mrfreeze.settings_api.repository

import org.springframework.data.jpa.repository.JpaRepository
import xyz.terminalnode.mrfreeze.settings_api.model.MuteEntry

interface MuteEntryRepository : JpaRepository<MuteEntry, Long>