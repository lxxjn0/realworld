package me.lxxjn0.realworld.article.application

data class CreateArticleRequest(
    val title: String,
    val description: String,
    val body: String,
    val tagList: List<String>?,
)