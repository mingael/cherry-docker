package com.cherry.cherrybackend.account.service

import com.cherry.cherrybackend.account.controller.request.AccountSignUpRequest
import com.cherry.cherrybackend.account.domain.User
import com.cherry.cherrybackend.account.repository.UserRepository
import com.querydsl.core.QueryFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service


interface AccountService {

    fun register(request: AccountSignUpRequest): Long

    fun leave(id: Long): Boolean

    fun permanentlyDelete(id: Long): Boolean
}