package com.cherry.cherrybackend.common.domain.enums

import com.fasterxml.jackson.annotation.JsonFormat
import java.util.*

@JsonFormat
enum class Flag(val code: String) {
    TRUE("y"),
    FALSE("n");

    companion object {
        fun of(dbData: String): Flag {
            return Arrays.stream(Flag.values())
                .filter { it.code == dbData }
                .findAny()
                .orElse(FALSE)
        }
    }
}