package com.cherry.cherrybackend.auth.service

import com.cherry.cherrybackend.auth.controller.request.AuthSignInRequest
import com.cherry.cherrybackend.account.domain.User
import com.cherry.cherrybackend.account.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.util.ObjectUtils

@Service
class AuthServiceImpl(private val userRepository: UserRepository): AuthService {

    override fun signInConfirm(request: AuthSignInRequest): User? {
        
        val user = userRepository.findByEmailAndPassword(request.email, request.password)
        if(ObjectUtils.isEmpty(user))
        {
            return null
        }
        return user[0]
    }

    override fun signOut(): Boolean {
        return true
    }


}