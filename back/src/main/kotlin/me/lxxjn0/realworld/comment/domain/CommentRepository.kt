package me.lxxjn0.realworld.comment.domain

import me.lxxjn0.realworld.article.domain.Article
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository : JpaRepository<Comment, Long> {
    fun findAllByArticle(article: Article): List<Comment>
}