package me.lxxjn0.realworld.article.presentation

import me.lxxjn0.realworld.article.application.ArticleCreateRequest
import me.lxxjn0.realworld.article.application.ArticleResponse
import me.lxxjn0.realworld.article.application.ArticleService
import me.lxxjn0.realworld.article.application.ArticleUpdateRequest
import me.lxxjn0.realworld.comment.config.Slf4j
import me.lxxjn0.realworld.comment.config.Slf4j.Companion.log
import me.lxxjn0.realworld.user.domain.User
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Slf4j
@RestController
@RequestMapping(ArticleController.URL)
class ArticleController(
    private val articleService: ArticleService,
) {
    @PostMapping
    fun create(
        loginUser: User,
        @RequestBody request: ArticleCreateRequest,
    ): ResponseEntity<ArticleResponse> {
        log.info("[ArticleController] 게시글 생성 요청 - url : {}, user : {}, request : {}", URL,
            loginUser.username, request)
        return ResponseEntity.ok(articleService.create(loginUser, request))
    }

    @GetMapping(value = ["/{slug}"])
    fun show(
        loginUser: User?,
        @PathVariable slug: String,
    ): ResponseEntity<ArticleResponse> {
        log.info("[ArticleController] 게시글 조회 요청 - url : {}, user : {}", "$URL/$slug",
            loginUser?.username)
        return ResponseEntity.ok(articleService.show(loginUser, slug))
    }

    @PutMapping(value = ["/{slug}"])
    fun update(
        loginUser: User,
        @PathVariable slug: String,
        request: ArticleUpdateRequest,
    ): ResponseEntity<ArticleResponse> {
        log.info("[ArticleController] 게시글 수정 요청 - url : {}, user : {}, request : {}",
            "$URL/$slug", loginUser.username, request)
        return ResponseEntity.ok(articleService.update(loginUser, slug, request))
    }

    companion object {
        const val URL = "/api/articles"
    }
}