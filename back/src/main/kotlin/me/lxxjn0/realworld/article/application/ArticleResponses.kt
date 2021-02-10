package me.lxxjn0.realworld.article.application

import me.lxxjn0.realworld.tag.application.TagsResponse
import me.lxxjn0.realworld.user.application.ProfileResponse

data class ArticleResponse(
    var slug: String?,
    var title: String?,
    var description: String?,
    var body: String?,
    var tags: TagsResponse?,
    var createdAt: String?,
    var updatedAt: String?,
    var favorited: Boolean?,
    var favoritesCount: Int?,
    var author: ProfileResponse?
)

data class ArticlesResponse(
    var articles: List<ArticleResponse>?,
    var articlesCount: Long?
)