package com.cherry.cherrybackend.account.service

import com.cherry.cherrybackend.account.controller.request.AccountSignUpRequest
import com.cherry.cherrybackend.account.domain.User
import com.cherry.cherrybackend.account.repository.UserRepository
import com.cherry.cherrybackend.account.repository.custom.UserRepoCustom
import com.cherry.cherrybackend.account.util.PasswordProvider
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.util.ObjectUtils

@Service
@Transactional(readOnly = true)
class AccountServiceImpl(
    private val userRepository: UserRepository
): AccountService {

    override fun register(request: AccountSignUpRequest): Long {
        if(!PasswordProvider.regexConfirm(request.password)) {
            return 0
        }

        if(!ObjectUtils.isEmpty(userRepository.findByEmailAndIsDelete(request.email))) {
            return 0
        }

        val user = User(
            email = request.email,
            password = PasswordProvider.encrypt(request.password),
            nickname = request.nickname)
        return userRepository.save(user).id
    }

    @Transactional
    override fun leave(id: Long): Boolean {
        if(ObjectUtils.isEmpty(userRepository.findByIdAndIsDelete(id))) {
            return false
        }
        return userRepository.leave(id)
    }

    override fun permanentlyDelete(id: Long): Boolean {
        userRepository.deleteById(id)
        if(userRepository.findById(id).isEmpty) {
            return true
        }
        return false
    }
}