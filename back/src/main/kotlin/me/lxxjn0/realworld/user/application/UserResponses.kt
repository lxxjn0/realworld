package me.lxxjn0.realworld.user.application

data class UserResponse(
    val email: String,
    val token: String,
    val username: String,
    val bio: String,
    val image: String,
)

data class ProfileResponse(
    val username: String,
    val bio: String,
    val image: String,
    var following: Boolean,
)