package xyz.terminalnode.mrfreeze.settings_api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SettingsApiApplication

fun main(args: Array<String>) {
	runApplication<SettingsApiApplication>(*args)
}
