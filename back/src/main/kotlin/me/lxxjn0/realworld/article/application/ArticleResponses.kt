package me.lxxjn0.realworld.article.application

import me.lxxjn0.realworld.article.domain.Article
import me.lxxjn0.realworld.common.application.BaseResponse
import me.lxxjn0.realworld.user.application.ProfileResponse
import java.time.LocalDateTime

data class ArticleResponse(
    val slug: String,
    val title: String,
    val description: String,
    val body: String,
    val tagList: List<String>,
    override val createdAt: LocalDateTime,
    override val updatedAt: LocalDateTime,
    val favorited: Boolean,
    val favoritesCount: Long,
    val author: ProfileResponse,
) : BaseResponse(createdAt, updatedAt) {
    constructor(
        article: Article,
        tagNames: List<String>,
        favorited: Boolean = false,
        favoritesCount: Long = 0L,
        following: Boolean = false,
    ) : this(
        slug = article.slug,
        title = article.title,
        description = article.description,
        body = article.body,
        tagList = tagNames,
        createdAt = article.createdAt,
        updatedAt = article.updatedAt,
        favorited = favorited,
        favoritesCount = favoritesCount,
        author = ProfileResponse(
            username = article.author.username,
            bio = article.author.bio,
            image = article.author.image,
            following = following
        )
    )
}

data class ArticlesResponse(
    var articles: List<ArticleResponse>?,
    var articlesCount: Long?,
)