package ro.marc.meditationBackend.dto

import ro.marc.meditationBackend.entity.Session

data class SessionDTO(
    val id: Long?,
    val location: String,
    val duration: Int,
) {

    companion object {

        fun from(session: Session) = SessionDTO(
            session.id,
            session.location,
            session.duration,
        )

    }

}
