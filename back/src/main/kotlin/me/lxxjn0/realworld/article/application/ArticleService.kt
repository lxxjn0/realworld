package me.lxxjn0.realworld.article.application

import me.lxxjn0.realworld.article.domain.ArticleRepository
import me.lxxjn0.realworld.articletag.domain.ArticleTagRepository
import me.lxxjn0.realworld.comment.config.Slf4j
import me.lxxjn0.realworld.favorite.domain.FavoriteRepository
import me.lxxjn0.realworld.follow.domain.FollowRepository
import me.lxxjn0.realworld.user.domain.User
import org.springframework.stereotype.Service

@Slf4j
@Service
class ArticleService(
    private val articleRepository: ArticleRepository,
    private val favoriteRepository: FavoriteRepository,
    private val articleTagRepository: ArticleTagRepository,
    private val followRepository: FollowRepository,
) {

    fun show(loginUser: User?, slug: String): ArticleResponse {
        val article = articleRepository.findBySlug(slug)
            ?: throw IllegalArgumentException("존재하지 않는 게시글입니다. slug : $slug")
        val favoritesCount = favoriteRepository.countAllByArticle(article)
        val tags = articleTagRepository.findAllByArticle(article)
            .map { it.tag.name }
        val favorited = loginUser?.let { favoriteRepository.existsByUserAndArticle(it, article) }
            ?: false
        val following =
            loginUser?.let { followRepository.existsByUserAndFollower(article.author, it) }
                ?: false

        return ArticleResponse(
            article = article,
            tags = tags,
            favorited = favorited,
            favoritesCount = favoritesCount,
            following = following
        )
    }

}
