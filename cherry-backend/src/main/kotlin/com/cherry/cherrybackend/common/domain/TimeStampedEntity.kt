package com.cherry.cherrybackend.common.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class TimeStampedEntity (
    @CreatedDate
    @Column(nullable = false, updatable = false)
    var regDtm: LocalDateTime = LocalDateTime.now(),

    @LastModifiedDate
    @Column(nullable = false)
    var modDtm: LocalDateTime = LocalDateTime.now()
)