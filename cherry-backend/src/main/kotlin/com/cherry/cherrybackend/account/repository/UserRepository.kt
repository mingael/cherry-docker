package com.cherry.cherrybackend.account.repository

import com.cherry.cherrybackend.account.domain.User
import com.cherry.cherrybackend.common.domain.enums.Flag
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {

    fun findByEmailAndIsDelete(email: String, isDelete: Flag = Flag.TRUE): User?

    fun findByIdAndIsDelete(id: Long, isDelete: Flag = Flag.TRUE): User?
}