package me.lxxjn0.realworld.article.application

import me.lxxjn0.realworld.tag.domain.Tag

data class CreateArticleRequest(
    val _title: String,
    val _description: String,
    val _body: String,
    val _tagList: List<String>?,
) {
    val title: String = _title
    val description: String = _description
    val body: String = _body
    val tagList: List<Tag>? by lazy { _tagList?.map { Tag(it) } }
}