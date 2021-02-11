package me.lxxjn0.realworld.favorite.domain

import org.springframework.data.jpa.repository.JpaRepository

interface FavoriteRepository : JpaRepository<Favorite, Long>