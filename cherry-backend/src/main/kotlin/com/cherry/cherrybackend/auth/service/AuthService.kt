package com.cherry.cherrybackend.auth.service

import com.cherry.cherrybackend.auth.controller.request.AuthSignInRequest
import com.cherry.cherrybackend.account.domain.User

interface AuthService {

    fun signInConfirm(request: AuthSignInRequest): User?

    fun signOut(): Boolean
}