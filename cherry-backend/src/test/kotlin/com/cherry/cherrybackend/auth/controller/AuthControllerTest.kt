package com.cherry.cherrybackend.auth.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class AuthControllerTest @Autowired constructor (val mvc: MockMvc) {

    @Test
    fun signIn() {
        val email = ""
        val password = ""

        mvc.perform(post("/auth/sign-in-confirm")
            .param("email", email)
            .param("password", password))
            .andExpect(status().isOk)
    }
}