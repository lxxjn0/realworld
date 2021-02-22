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
    fun create(article: Article, tag: Tag) =
        ArticleTag(article, tag).also { articleTagRepository.save(it) }
            .also { log.info("[ArticleTagService] 게시글 태그 생성 - articleTag : {}", it) }

    fun createAllByTags(article: Article, tags: List<Tag>) =
        tags.map { ArticleTag(article, it) }
            .also { articleTagRepository.saveAll(it) }
            .also {
                log.info("[ArticleTagService] 전체 게시글 태그 생성 - articleTags size : {}, articleTags : {}",
                    it.size, it)
            }
}