package com.cherry.cherrybackend.account.util

import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder

class PasswordProvider {

    companion object {
        private val passwordEncoder: PasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()

        private val PASSWORD_REGEX = """^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$&?])[\w@#$&?]{8,15}$""".toRegex()

        /**
         * 암호화
         * @param passwd 비밀번호
         */
        fun encrypt(passwd: String): String {
            return passwordEncoder.encode(passwd)
        }

        fun verity(rawPasswd: String, encPasswd: String): Boolean {
            if(rawPasswd.isBlank()) {
                return false
            }
            if(!regexConfirm(rawPasswd)) {
                return false
            }
            if(!matches(rawPasswd, encPasswd)) {
                return false
            }
            return true
        }

        fun regexConfirm(rawPasswd: String): Boolean {
            return PASSWORD_REGEX.matches(rawPasswd)
        }

        private fun matches(rawPasswd: String, encPasswd: String): Boolean {
            return passwordEncoder.matches(rawPasswd, encPasswd)
        }

    }
}