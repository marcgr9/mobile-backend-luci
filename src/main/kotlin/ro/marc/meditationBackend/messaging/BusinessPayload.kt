package ro.marc.meditationBackend.messaging

data class BusinessPayload<T>(
    val payload: T?,
)
