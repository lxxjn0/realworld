package me.lxxjn0.realworld.common.application

import com.fasterxml.jackson.annotation.JsonFormat
import me.lxxjn0.realworld.common.utils.RESPONSE_TIME_FORMAT
import me.lxxjn0.realworld.common.utils.SEOUL_TIME_ZONE
import java.time.LocalDateTime

abstract class BaseResponse(
    @JsonFormat(
        pattern = RESPONSE_TIME_FORMAT,
        shape = JsonFormat.Shape.STRING,
        locale = SEOUL_TIME_ZONE,
    )
    open val createdAt: LocalDateTime,

    @JsonFormat(
        pattern = RESPONSE_TIME_FORMAT,
        shape = JsonFormat.Shape.STRING,
        locale = SEOUL_TIME_ZONE,
    )
    open val updatedAt: LocalDateTime,
)