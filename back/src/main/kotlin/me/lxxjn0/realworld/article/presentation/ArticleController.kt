package me.lxxjn0.realworld.article.presentation

import me.lxxjn0.realworld.article.application.CreateArticleRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(ArticleController.URL)
class ArticleController {
    @PostMapping
    fun createArticle(@RequestBody request: CreateArticleRequest) {
    }

    companion object {
        const val URL = "/api/articles"
    }
}