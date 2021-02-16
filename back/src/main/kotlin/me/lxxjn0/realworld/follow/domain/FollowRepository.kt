package me.lxxjn0.realworld.follow.domain

import me.lxxjn0.realworld.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface FollowRepository : JpaRepository<Follow, Long> {

    fun existsByUserAndFollower(user: User, follower: User): Boolean

}