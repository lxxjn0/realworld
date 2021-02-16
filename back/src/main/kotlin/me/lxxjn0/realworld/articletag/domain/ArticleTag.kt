package me.lxxjn0.realworld.articletag.domain

import me.lxxjn0.realworld.article.domain.Article
import me.lxxjn0.realworld.tag.domain.Tag
import javax.persistence.*

@Entity
class ArticleTag(
    @ManyToOne
    @JoinColumn(name = "article_id")
    val article: Article,

    @ManyToOne
    @JoinColumn(name = "tag_id")
    val tag: Tag,
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_tag_id")
    val id: Long = 0L

}