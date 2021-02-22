package me.lxxjn0.realworld.comment.application

import me.lxxjn0.realworld.article.application.ArticleService
import me.lxxjn0.realworld.comment.domain.Comment
import me.lxxjn0.realworld.comment.domain.CommentRepository
import me.lxxjn0.realworld.common.config.Slf4j
import me.lxxjn0.realworld.common.config.Slf4j.Companion.log
import me.lxxjn0.realworld.follow.domain.FollowRepository
import me.lxxjn0.realworld.user.domain.User
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Slf4j
@Service
class CommentService(
    private val commentRepository: CommentRepository,
    private val articleService: ArticleService,
    private val followRepository: FollowRepository,
) {
    @Transactional
    fun create(loginUser: User, slug: String, request: CommentRequest): CommentResponse {
        val article = articleService.showBySlug(slug)
        val comment = Comment(request.body, loginUser, article).let { commentRepository.save(it) }
        log.info("[CommentService] 댓글 생성 - comment : {}", comment)

        return CommentResponse(comment)
    }

    @Transactional(readOnly = true)
    fun showAllByArticle(loginUser: User?, slug: String): CommentsResponse {
        val article = articleService.showBySlug(slug)
        val comments = commentRepository.findAllByArticle(article)

        val commentResponses =
            if (loginUser == null) comments.map { CommentResponse(it) }
            else comments.map { comment ->
                val following = followRepository.existsByUserAndFollower(comment.author, loginUser)
                CommentResponse(comment, following)
            }

        return CommentsResponse(commentResponses).also {
            log.info("[CommentService] 게시글 댓글 조회 - loginUser : {}, slug : {}, response : {}",
                loginUser, slug, it)
        }
    }
}