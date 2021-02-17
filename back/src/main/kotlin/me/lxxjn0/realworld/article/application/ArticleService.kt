package me.lxxjn0.realworld.article.application

import me.lxxjn0.realworld.article.domain.Article
import me.lxxjn0.realworld.article.domain.ArticleRepository
import me.lxxjn0.realworld.articletag.application.ArticleTagService
import me.lxxjn0.realworld.articletag.domain.ArticleTagRepository
import me.lxxjn0.realworld.comment.config.Slf4j
import me.lxxjn0.realworld.comment.config.Slf4j.Companion.log
import me.lxxjn0.realworld.favorite.domain.FavoriteRepository
import me.lxxjn0.realworld.follow.domain.FollowRepository
import me.lxxjn0.realworld.tag.application.TagService
import me.lxxjn0.realworld.user.domain.User
import org.springframework.stereotype.Service

@Slf4j
@Service
class ArticleService(
    private val articleRepository: ArticleRepository,
    private val favoriteRepository: FavoriteRepository,
    private val articleTagRepository: ArticleTagRepository,
    private val articleTagService: ArticleTagService,
    private val followRepository: FollowRepository,
    private val tagService: TagService,
) {
    fun create(loginUser: User, request: CreateArticleRequest): ArticleResponse {
        val article = Article(request.title, request.description, request.body, loginUser)
            .also { articleRepository.save(it) }
        log.info("[ArticleService] 게시글 생성 - article : {}", article)
        val tags = request.tagList
            ?.let { tagService.createAllByNames(it) }
            ?: emptyList()
        articleTagService.createAllByTags(article, tags)

        return ArticleResponse(article = article, tagNames = tags.map { it.name })
    }

    fun show(loginUser: User?, slug: String): ArticleResponse {
        val article = articleRepository.findBySlug(slug)
            ?: throw IllegalArgumentException("존재하지 않는 게시글입니다. slug : $slug")
        val favoritesCount = favoriteRepository.countAllByArticle(article)
        val tagNames = articleTagRepository.findAllByArticle(article)
            .map { it.tag.name }
        val favorited = loginUser?.let { favoriteRepository.existsByUserAndArticle(it, article) }
            ?: false
        val following =
            loginUser?.let { followRepository.existsByUserAndFollower(article.author, it) }
                ?: false

        val response = ArticleResponse(article, tagNames, favorited, favoritesCount, following)
        log.info("[ArticleService] 게시글 조회 - article : {}", response)

        return response
    }
}
