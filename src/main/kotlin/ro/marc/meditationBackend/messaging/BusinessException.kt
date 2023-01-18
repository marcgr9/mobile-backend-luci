package ro.marc.meditationBackend.messaging

import ro.marc.backend.messaging.BusinessMessage
import java.lang.RuntimeException

class BusinessException(
    val businessMessage: BusinessMessage
): RuntimeException()

