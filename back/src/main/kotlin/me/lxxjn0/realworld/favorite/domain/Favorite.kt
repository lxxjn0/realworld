package me.lxxjn0.realworld.favorite.domain

import me.lxxjn0.realworld.article.domain.Article
import me.lxxjn0.realworld.user.domain.User
import javax.persistence.*

@Entity
@Table(name = "favorite")
class Favorite(
    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User,

    @ManyToOne
    @JoinColumn(name = "article_id")
    val article: Article,
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "favorite_id")
    val id: Long = 0L

}