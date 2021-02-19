package me.lxxjn0.realworld.articletag.application

import me.lxxjn0.realworld.article.domain.Article
import me.lxxjn0.realworld.articletag.domain.ArticleTag
import me.lxxjn0.realworld.articletag.domain.ArticleTagRepository
import me.lxxjn0.realworld.common.config.Slf4j
import me.lxxjn0.realworld.common.config.Slf4j.Companion.log
import me.lxxjn0.realworld.tag.domain.Tag
import org.springframework.stereotype.Service

@Slf4j
@Service
class ArticleTagService(private val articleTagRepository: ArticleTagRepository) {
    fun create(article: Article, tag: Tag): ArticleTag {
        val articleTag = ArticleTag(article, tag)
            .also { articleTagRepository.save(it) }

        log.info("[ArticleTagService] 게시글 태그 생성 - articleTag : {}", articleTag)
        return articleTag
    }

    fun createAllByTags(article: Article, tags: List<Tag>): List<ArticleTag> {
        val articleTags = tags.map { ArticleTag(article, it) }
            .also { articleTagRepository.saveAll(it) }

        log.info("[ArticleTagService] 전체 게시글 태그 생성 - articleTags size : {}, articleTags : {}",
            articleTags.size, articleTags)
        return articleTags
    }
}