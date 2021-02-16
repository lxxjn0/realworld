package me.lxxjn0.realworld.article.domain

import me.lxxjn0.realworld.common.domain.BaseEntity
import me.lxxjn0.realworld.user.domain.User
import javax.persistence.*

@Entity
@Table(name = "article")
class Article(
    @Column(name = "title")
    val title: String,

    @Column(name = "description")
    val description: String,

    @Lob
    @Column(name = "body")
    val body: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    val author: User,
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    val id: Long = 0L

    @Column(name = "slug")
    val slug: String = parseSlug(title)

    private fun parseSlug(title: String) =
        title.replace(regex = whitespaceRegex, replacement = SLUG_DELIMITER)

    companion object {
        private const val SLUG_DELIMITER = "-"

        private val whitespaceRegex = Regex("""\s""")
    }

}