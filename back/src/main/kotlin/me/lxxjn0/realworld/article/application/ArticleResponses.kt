package me.lxxjn0.realworld.article.application

import me.lxxjn0.realworld.article.domain.Article
import me.lxxjn0.realworld.user.application.ProfileResponse

data class ArticleResponse(
    val slug: String,
    val title: String,
    val description: String,
    val body: String,
    val tagList: List<String>,
    val createdAt: String,
    val updatedAt: String,
    val favorited: Boolean,
    val favoritesCount: Long,
    val author: ProfileResponse,
) {
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
        createdAt = article.createdAt.toString(),
        updatedAt = article.updatedAt.toString(),
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