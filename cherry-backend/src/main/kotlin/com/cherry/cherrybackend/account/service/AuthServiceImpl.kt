package com.cherry.cherrybackend.account.service

import com.cherry.cherrybackend.account.controller.request.AuthSignInRequest
import com.cherry.cherrybackend.account.domain.User
import com.cherry.cherrybackend.account.repository.UserRepository
import com.cherry.cherrybackend.account.repository.custom.UserRepoCustom
import com.cherry.cherrybackend.account.util.PasswordProvider
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.util.ObjectUtils

@Service
class AuthServiceImpl(
        private val userRepository: UserRepository,
        private val userRepoCustom: UserRepoCustom
): AuthService {

    @Transactional
    override fun signInConfirm(request: AuthSignInRequest): User? {

        val user = userRepository.findByEmailAndIsDelete(request.email)
        if(ObjectUtils.isEmpty(user) || user == null) {
            return null
        }

        if(!PasswordProvider.verity(request.password, user.password)) {
            return null
        }

        userRepoCustom.updateLastLoginDtm(user.id)

        return user
    }

}