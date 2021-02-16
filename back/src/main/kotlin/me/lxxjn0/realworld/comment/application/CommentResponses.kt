package me.lxxjn0.realworld.comment.application

import me.lxxjn0.realworld.user.application.ProfileResponse

data class CommentResponse(
    val id: Long?,
    val createdAt: String?,
    val updatedAt: String?,
    val body: String?,
    val author: ProfileResponse?,
)
