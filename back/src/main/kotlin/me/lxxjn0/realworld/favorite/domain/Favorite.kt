package me.lxxjn0.realworld.favorite.domain

import me.lxxjn0.realworld.article.domain.Article
import me.lxxjn0.realworld.user.domain.User
import javax.persistence.*

@Entity
@Table(name = "favorite")
class Favorite(
    user: User,
    article: Article,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "favorite_id")
    var id: Long? = null

    @ManyToOne
    @JoinColumn(name = "user_id")
    var user: User = user

    @ManyToOne
    @JoinColumn(name = "article_id")
    var article: Article = article
}