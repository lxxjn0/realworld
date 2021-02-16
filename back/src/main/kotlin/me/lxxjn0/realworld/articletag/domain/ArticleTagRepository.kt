package me.lxxjn0.realworld.articletag.domain

import me.lxxjn0.realworld.article.domain.Article
import org.springframework.data.jpa.repository.JpaRepository

interface ArticleTagRepository : JpaRepository<ArticleTag, Long> {
    fun findAllByArticle(article: Article): List<ArticleTag>
}