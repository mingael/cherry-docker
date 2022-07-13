package com.cherry.cherrybackend.account.service

import com.cherry.cherrybackend.account.controller.request.AccountSignUpRequest
import com.cherry.cherrybackend.account.domain.User
import com.cherry.cherrybackend.account.repository.UserRepository
import com.querydsl.core.QueryFactory
import org.springframework.stereotype.Service

@Service
class AccountService(private val userRepository: UserRepository) {

    fun register(request: AccountSignUpRequest): Long {
        val user = User(
            email = request.email,
            password = request.password,
            nickname = request.nickname)
        return userRepository.save(user).id
    }

    fun leave(id: Long): Boolean {
        userRepository.deleteById(id)

        if(userRepository.findById(id).isEmpty) {
           return true
        }
        return false
    }
}