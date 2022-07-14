package com.cherry.cherrybackend.account.controller.request

data class AuthSignInRequest(
    val email: String,
    val password: String
)
