package com.cherry.cherrybackend.account.repository

import com.cherry.cherrybackend.account.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {

    fun findByEmailAndPassword(email: String, password: String): List<User>


}