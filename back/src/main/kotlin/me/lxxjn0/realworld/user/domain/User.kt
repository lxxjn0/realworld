package me.lxxjn0.realworld.user.domain

import me.lxxjn0.realworld.common.domain.BaseEntity
import javax.persistence.*

@Entity
@Table(name = "user")
class User(
    @Column(name = "email")
    val email: String,

    @Column(name = "password")
    val password: String,

    @Column(name = "username")
    val username: String,

    @Column(name = "bio")
    val bio: String,

    @Column(name = "image")
    val image: String,
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    val id: Long = 0L

    override fun toString(): String {
        return "User(email='$email', password='$password', username='$username', bio='$bio', " +
                "image='$image', id=$id)"
    }
}