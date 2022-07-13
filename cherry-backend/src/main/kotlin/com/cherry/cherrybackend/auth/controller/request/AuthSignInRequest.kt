package com.cherry.cherrybackend.auth.controller.request

data class AuthSignInRequest(
    val email: String,
    val password: String
)
