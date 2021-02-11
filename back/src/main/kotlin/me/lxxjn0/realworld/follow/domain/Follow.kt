package me.lxxjn0.realworld.follow.domain

import me.lxxjn0.realworld.user.domain.User
import javax.persistence.*

@Entity
@Table(name = "follow")
class Follow(
    user: User,
    follower: User,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column("follow_id")
    var id: Long? = null

    @ManyToOne
    @JoinColumn(name = "user_id")
    var user: User = user

    @ManyToOne
    @JoinColumn(name = "follower_id")
    var follower: User = user
}