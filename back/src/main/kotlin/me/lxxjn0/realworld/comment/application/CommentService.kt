package me.lxxjn0.realworld.comment.application

import me.lxxjn0.realworld.article.domain.ArticleRepository
import me.lxxjn0.realworld.comment.domain.Comment
import me.lxxjn0.realworld.comment.domain.CommentRepository
import me.lxxjn0.realworld.common.config.Slf4j
import me.lxxjn0.realworld.common.config.Slf4j.Companion.log
import me.lxxjn0.realworld.user.domain.User
import org.springframework.stereotype.Service

@Slf4j
@Service
class CommentService(
    private val articleRepository: ArticleRepository,
    private val commentRepository: CommentRepository,
) {
    fun create(loginUser: User, slug: String, request: CommentRequest): CommentResponse {
        val article = articleRepository.findBySlug(slug)
            ?: throw IllegalArgumentException("[ArticleService] 존재하지 않는 게시글입니다 - slug : $slug")
        val comment = Comment(request.body, loginUser, article).let { commentRepository.save(it) }
        log.info("[CommentService] 댓글 생성 - comment : {}", comment)

        return CommentResponse(comment)
    }
}