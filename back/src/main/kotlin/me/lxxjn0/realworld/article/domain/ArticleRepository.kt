package me.lxxjn0.realworld.article.domain

import org.springframework.data.jpa.repository.JpaRepository

interface ArticleRepository : JpaRepository<Article, String> {
}