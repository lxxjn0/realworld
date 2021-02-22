package me.lxxjn0.realworld.comment.domain

import me.lxxjn0.realworld.article.domain.Article
import me.lxxjn0.realworld.common.domain.BaseEntity
import me.lxxjn0.realworld.user.domain.User
import javax.persistence.*

@Entity
@Table(name = "comment")
class Comment(
    @Column(name = "body")
    val body: String,

    @ManyToOne
    @JoinColumn(name = "author_id")
    val author: User,

    @ManyToOne
    @JoinColumn(name = "article_id")
    val article: Article,
) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    val id: Long = 0L
}