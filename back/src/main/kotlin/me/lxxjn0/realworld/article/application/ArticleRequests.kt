package me.lxxjn0.realworld.article.application

data class ArticleCreateRequest(
    val title: String,
    val description: String,
    val body: String,
    val tagList: List<String>?,
)

data class ArticleUpdateRequest(
    val title: String?,
    val description: String?,
    val body: String?,
)