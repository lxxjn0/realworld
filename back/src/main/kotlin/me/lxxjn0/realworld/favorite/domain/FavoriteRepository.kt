package me.lxxjn0.realworld.favorite.domain

import me.lxxjn0.realworld.article.domain.Article
import me.lxxjn0.realworld.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface FavoriteRepository : JpaRepository<Favorite, Long> {
    fun countAllByArticle(article: Article): Long

    fun existsByUserAndArticle(user: User, article: Article): Boolean
}