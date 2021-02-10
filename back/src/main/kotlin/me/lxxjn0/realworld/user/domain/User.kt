package me.lxxjn0.realworld.user.domain

import me.lxxjn0.realworld.common.domain.BaseEntity
import javax.persistence.*

@Entity
class User(
    email: String,
    password: String,
    username: String,
    bio: String,
    image: String
) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    var id: Long? = null
        private set

    @Column(name = "email")
    var email: String = email
        private set

    @Column(name = "password")
    var password: String = password
        private set

    @Column(name = "username")
    var username: String = username
        private set

    @Column(name = "bio")
    var bio: String = bio
        private set

    @Column(name = "image")
    var image: String = image
        private set
}