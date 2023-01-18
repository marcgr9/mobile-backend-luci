package ro.marc.meditationBackend

import org.springframework.stereotype.Service
import ro.marc.meditationBackend.dto.SessionDTO

@Service
class SessionsService(
    private val sessionsRepo: SessionsRepo
) {

    fun updateLocation(id: Long, location: String): SessionDTO {
        sessionsRepo.updateLocation(id, location)

        return SessionDTO.from(
            sessionsRepo.getReferenceById(id)
        )
    }

}