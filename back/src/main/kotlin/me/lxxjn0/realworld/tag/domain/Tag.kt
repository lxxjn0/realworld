package me.lxxjn0.realworld.tag.domain

import javax.persistence.*

@Entity
@Table(name = "tag")
class Tag(
    @Column(name = "name")
    val name: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    val id: Long = 0L

    override fun toString(): String {
        return "Tag(name='$name', id=$id)"
    }
}