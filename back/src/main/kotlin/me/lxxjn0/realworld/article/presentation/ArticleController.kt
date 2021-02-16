package me.lxxjn0.realworld.article.presentation

import me.lxxjn0.realworld.article.application.ArticleService
import me.lxxjn0.realworld.article.application.CreateArticleRequest
import me.lxxjn0.realworld.user.domain.User
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(ArticleController.URL)
class ArticleController(
    private val articleService: ArticleService,
) {
    @PostMapping
    fun createArticle(loginUser: User, @RequestBody request: CreateArticleRequest) {
    }

    @GetMapping(value = ["/{slug}"])
    fun showArticle(loginUser: User?, @PathVariable slug: String) =
        ResponseEntity.ok(articleService.show(loginUser, slug))

    companion object {
        const val URL = "/api/articles"
    }
}