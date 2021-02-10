package me.lxxjn0.realworld.articletag.domain

import org.springframework.data.jpa.repository.JpaRepository

interface ArticleTagRepository : JpaRepository<ArticleTag, Long> {
}