package me.lxxjn0.realworld.user.application

data class UserResponse(
    var email: String?,
    var token: String?,
    var username: String?,
    var bio: String?,
    var image: String?,
)

data class ProfileResponse(
    var username: String?,
    var bio: String?,
    var image: String?,
    var following: Boolean?,
)