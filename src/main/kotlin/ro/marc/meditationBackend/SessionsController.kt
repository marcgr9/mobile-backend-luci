package ro.marc.meditationBackend

import org.springframework.web.bind.annotation.*
import ro.marc.meditationBackend.messaging.BusinessPayload
import ro.marc.meditationBackend.dto.ChangeLocationDTO
import ro.marc.meditationBackend.dto.SessionDTO
import ro.marc.meditationBackend.entity.Session

@RestController
class SessionsController(
    private val sessionsService: SessionsService,
    private val sessionsRepo: SessionsRepo,
) {

    @GetMapping("/")
    fun getAll(): BusinessPayload<List<SessionDTO>>
        = BusinessPayload(
            sessionsRepo.findAll().map {
                SessionDTO.from(it)
            }
        )

    @PostMapping("/")
    fun postTransaction(@RequestBody session: SessionDTO) = BusinessPayload(
        SessionDTO.from(
            sessionsRepo.save(
                Session(
                    location = session.location,
                    duration = session.duration,
                )
            )
        )
    )

    @PatchMapping("/{id}")
    fun increaseAmount(@PathVariable(value = "id") id: Long, @RequestBody changeLocationDTO: ChangeLocationDTO): BusinessPayload<SessionDTO>
        = BusinessPayload(sessionsService.updateLocation(id, changeLocationDTO.location))

    @DeleteMapping("/{id}")
    fun chargeback(@PathVariable(value = "id") id: Long): BusinessPayload<Void> {
        sessionsRepo.deleteById(id)
        return BusinessPayload(null)
    }

}