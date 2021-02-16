package me.lxxjn0.realworld.follow.domain

import me.lxxjn0.realworld.user.domain.User
import javax.persistence.*

@Entity
@Table(name = "follow")
class Follow(
    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User,

    @ManyToOne
    @JoinColumn(name = "follower_id")
    val follower: User,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "follow_id")
    val id: Long = 0L
}