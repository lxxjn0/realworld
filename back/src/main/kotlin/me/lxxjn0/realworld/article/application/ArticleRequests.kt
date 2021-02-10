package me.lxxjn0.realworld.article.application

data class CreateArticleRequest(
    var title: String,
    var description: String,
    var body: String,
    var tagList: List<String>?
)