package me.lxxjn0.realworld.article.presentation

import me.lxxjn0.realworld.article.application.ArticleResponse
import me.lxxjn0.realworld.article.application.ArticleService
import me.lxxjn0.realworld.article.application.CreateArticleRequest
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
    fun createArticle(loginUser: User, @RequestBody request: CreateArticleRequest) {
    }

    @GetMapping(value = ["/{slug}"])
    fun showArticle(loginUser: User?, @PathVariable slug: String): ResponseEntity<ArticleResponse> {
        log.info("[ArticleController] 게시글 조회 | url : $URL/$slug, user : ${loginUser?.username}")
        return ResponseEntity.ok(articleService.show(loginUser, slug))
    }

    companion object {

        const val URL = "/api/articles"

    }

}