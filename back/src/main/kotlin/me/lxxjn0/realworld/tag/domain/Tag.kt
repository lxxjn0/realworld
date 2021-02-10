package me.lxxjn0.realworld.tag.domain

import javax.persistence.*

@Entity
class Tag(name: String) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    var id: Long? = null

    @Column(name = "name")
    var name: String = name
}