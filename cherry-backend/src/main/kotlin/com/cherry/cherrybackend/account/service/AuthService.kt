package com.cherry.cherrybackend.account.service

import com.cherry.cherrybackend.account.controller.request.AuthSignInRequest
import com.cherry.cherrybackend.account.domain.User

interface AuthService {

    fun signInConfirm(request: AuthSignInRequest): User?

}