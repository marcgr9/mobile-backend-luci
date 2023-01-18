package ro.marc.meditationBackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MeditationBackendApplication

fun main(args: Array<String>) {
	runApplication<MeditationBackendApplication>(*args)
}
