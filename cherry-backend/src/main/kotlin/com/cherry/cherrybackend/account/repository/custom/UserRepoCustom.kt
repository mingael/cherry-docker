package com.cherry.cherrybackend.account.repository.custom

import com.cherry.cherrybackend.common.domain.enums.Flag
import java.time.LocalDateTime

interface UserRepoCustom {

    fun updateLastLoginDtm(id: Long)

    fun leave(id: Long): Boolean
}