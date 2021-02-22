package me.lxxjn0.realworld.comment.presentation

import me.lxxjn0.realworld.comment.application.CommentRequest
import me.lxxjn0.realworld.comment.application.CommentResponse
import me.lxxjn0.realworld.comment.application.CommentService
import me.lxxjn0.realworld.common.config.Slf4j
import me.lxxjn0.realworld.common.config.Slf4j.Companion.log
import me.lxxjn0.realworld.user.domain.User
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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

    companion object {
        const val URL = "/api/articles/{slug}/comments"
    }
}