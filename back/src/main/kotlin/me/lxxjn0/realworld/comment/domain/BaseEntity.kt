package me.lxxjn0.realworld.comment.domain

import java.time.LocalDateTime

open class BaseEntity(
    val createdAt: LocalDateTime = LocalDateTime.now(),
    var updatedAt: LocalDateTime = LocalDateTime.now(),
)