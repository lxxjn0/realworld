package me.lxxjn0.realworld.articletag.domain

import me.lxxjn0.realworld.article.domain.Article
import me.lxxjn0.realworld.tag.domain.Tag
import javax.persistence.*

@Entity
class ArticleTag(article: Article, tag: Tag) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_tag_id")
    var id: Long? = null

    @ManyToOne
    @JoinColumn(name = "article_id")
    var article: Article = article

    @ManyToOne
    @JoinColumn(name = "tag_id")
    var tag: Tag = tag
}