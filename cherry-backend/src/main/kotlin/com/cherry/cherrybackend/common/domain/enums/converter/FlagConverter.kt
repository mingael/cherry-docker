package com.cherry.cherrybackend.common.domain.enums.converter

import com.cherry.cherrybackend.common.domain.enums.Flag
import javax.persistence.AttributeConverter

class FlagConverter: AttributeConverter<Flag, String> {
    override fun convertToDatabaseColumn(attribute: Flag): String {
        return attribute.code
    }

    override fun convertToEntityAttribute(dbData: String): Flag {
        return Flag.of(dbData)
    }
}