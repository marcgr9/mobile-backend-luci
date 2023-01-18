package ro.marc.meditationBackend

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import ro.marc.meditationBackend.entity.Session

@Repository
interface SessionsRepo: JpaRepository<Session, Long> {

    @Transactional
    @Modifying
    @Query(
        nativeQuery = true,
        value =
        """
            UPDATE sessions SET location = :location WHERE id = :id
        """
    )
    fun updateLocation(id: Long, location: String)

}
