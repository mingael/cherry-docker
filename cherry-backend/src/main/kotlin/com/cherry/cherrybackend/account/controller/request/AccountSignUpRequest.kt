package com.cherry.cherrybackend.account.controller.request

data class AccountSignUpRequest(
    var email: String,
    var nickname: String,
    var password: String
)