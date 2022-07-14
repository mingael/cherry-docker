package com.cherry.cherrybackend.account.domain

import com.cherry.cherrybackend.common.domain.TimeStampedEntity
import com.cherry.cherrybackend.common.domain.enums.Flag
import com.cherry.cherrybackend.common.domain.enums.converter.FlagConverter
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Convert
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "user")
class User(
    @Column(length = 20)
    var nickname: String,

    @Column(length = 100)
    var password: String,

    @Column(length = 50)
    var email: String,

    @Column(length = 1)
    @Convert(converter = FlagConverter::class)
    var isDelete: Flag = Flag.TRUE,

    @Column(length = 20)
    var username: String = "",

    var lastLoginDtm: LocalDateTime = LocalDateTime.now(),

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L
): TimeStampedEntity()