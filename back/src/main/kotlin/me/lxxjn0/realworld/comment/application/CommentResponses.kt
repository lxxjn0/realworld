package me.lxxjn0.realworld.comment.application

import me.lxxjn0.realworld.user.application.ProfileResponse

data class CommentResponse(
    var id: Long?,
    var createdAt: String?,
    var updatedAt: String?,
    var body: String?,
    var author: ProfileResponse?,
)
