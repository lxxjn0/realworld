package me.lxxjn0.realworld.comment.application

import me.lxxjn0.realworld.comment.domain.Comment
import me.lxxjn0.realworld.common.application.BaseResponse
import me.lxxjn0.realworld.user.application.ProfileResponse
import java.time.LocalDateTime

data class CommentResponse(
    val id: Long,
    override val createdAt: LocalDateTime,
    override val updatedAt: LocalDateTime,
    val body: String,
    val author: ProfileResponse,
) : BaseResponse(createdAt, updatedAt) {
    constructor(
        comment: Comment,
        following: Boolean = false,
    ) : this(
        id = comment.id,
        createdAt = comment.createdAt,
        updatedAt = comment.updatedAt,
        body = comment.body,
        author = ProfileResponse(
            username = comment.author.username,
            bio = comment.author.bio,
            image = comment.author.image,
            following = following,
        )
    )

    fun updateFollowing(following: Boolean) {
        this.author.following = following
    }
}

data class CommentsResponse(val comments: List<CommentResponse>)