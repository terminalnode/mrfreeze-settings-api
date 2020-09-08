package xyz.terminalnode.mrfreeze.settings_api.controller

import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import xyz.terminalnode.mrfreeze.settings_api.model.Mute
import xyz.terminalnode.mrfreeze.settings_api.repository.MuteRepository

@RestController
@RequestMapping("/api/v1/mutes")
class MuteControllerV1(private val muteRepository: MuteRepository) {
  @GetMapping
  fun allMutes(): List<Mute> {
    return muteRepository.findAll()
  }

  @GetMapping("/id/{id}")
  fun getMuteById(@PathVariable id: Long): Mute? {
    return muteRepository.findByIdOrNull(id)
  }
}