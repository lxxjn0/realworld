package me.lxxjn0.realworld.article.domain

import me.lxxjn0.realworld.common.domain.BaseEntity
import me.lxxjn0.realworld.user.domain.User
import javax.persistence.*

@Entity
class Article(
    slug: String,
    title: String,
    description: String,
    body: String,
    author: User
) : BaseEntity() {
    @Id
    @Column(name = "slug")
    var slug: String = slug
        private set

    @Column(name = "title")
    var title: String = title
        private set

    @Column(name = "description")
    var description: String = description
        private set

    @Lob
    @Column(name = "body")
    var body: String = body
        private set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    var author: User = author
        private set
}