package com.cherry.cherrybackend.account.repository.custom

import com.cherry.cherrybackend.account.domain.QUser
import com.cherry.cherrybackend.common.domain.enums.Flag
import com.cherry.cherrybackend.common.infra.config.CustomQuerydslRepositorySupport
import org.apache.catalina.User
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
class UserRepositoryImpl: UserRepoCustom, CustomQuerydslRepositorySupport(User::class.java) {

    val user: QUser = QUser.user

    override fun updateLastLoginDtm(id: Long) {
        query.update(user)
                .set(user.lastLoginDtm, LocalDateTime.now())
                .where(user.id.eq(id))
                .execute()
    }

    override fun leave(id: Long): Boolean {
        val result: Long = query.update(user)
                .set(user.isDelete, Flag.FALSE)
                .where(user.id.eq(id))
                .execute()

        if(result > 0) return true
        return false
    }
}