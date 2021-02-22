package me.lxxjn0.realworld.comment.presentation

import me.lxxjn0.realworld.comment.application.CommentRequest
import me.lxxjn0.realworld.comment.application.CommentResponse
import me.lxxjn0.realworld.comment.application.CommentService
import me.lxxjn0.realworld.comment.application.CommentsResponse
import me.lxxjn0.realworld.common.config.Slf4j
import me.lxxjn0.realworld.common.config.Slf4j.Companion.log
import me.lxxjn0.realworld.user.domain.User
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Slf4j
@RestController
@RequestMapping(value = [CommentController.URL])
class CommentController(
    private val commentService: CommentService,
) {
    @PostMapping
    fun create(
        loginUser: User,
        @PathVariable slug: String,
        request: CommentRequest,
    ): ResponseEntity<CommentResponse> {
        log.info("[CommentController] 댓글 생성 요청 - url : {}, user : {}, request : {}", URL,
            loginUser, request)
        return ResponseEntity.ok(commentService.create(loginUser, slug, request))
    }

    @GetMapping
    fun showAllByArticle(
        loginUser: User?,
        @PathVariable slug: String,
    ): ResponseEntity<CommentsResponse> {
        log.info("[CommentController] 댓글 생성 요청 - url : {}, user : {}, request : {}", URL,
            loginUser)
        return ResponseEntity.ok(commentService.showAllByArticle(loginUser, slug))
    }

    companion object {
        const val URL = "/api/articles/{slug}/comments"
    }
}