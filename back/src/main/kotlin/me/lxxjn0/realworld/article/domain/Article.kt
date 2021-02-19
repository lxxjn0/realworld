package me.lxxjn0.realworld.article.domain

import me.lxxjn0.realworld.common.domain.BaseEntity
import me.lxxjn0.realworld.user.domain.User
import javax.persistence.*

@Entity
@Table(name = "article")
class Article(
    @Column(name = "title")
    var title: String,

    @Column(name = "description")
    var description: String,

    @Lob
    @Column(name = "body")
    var body: String,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    val author: User,
) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    val id: Long = 0L

    @Column(name = "slug")
    var slug: String

    init {
        this.slug = parseSlug(title)
    }

    fun update(title: String?, description: String?, body: String?) {
        title?.let {
            this.title = it
            this.slug = parseSlug(it)
        }
        description?.let { this.description = it }
        body?.let { this.body = body }
    }

    private fun parseSlug(title: String) =
        title.replace(regex = whitespaceRegex, replacement = SLUG_DELIMITER)

    companion object {
        private const val SLUG_DELIMITER = "-"

        private val whitespaceRegex = Regex("""\s""")
    }
}