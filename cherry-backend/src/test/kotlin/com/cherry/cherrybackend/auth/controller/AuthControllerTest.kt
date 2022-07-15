package com.cherry.cherrybackend.auth.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class AuthControllerTest @Autowired constructor (val mvc: MockMvc) {

    @Test
    fun singInConfirm() {
        val username = "username"
        val password = "1$2E34d5"
        val email = "email@gmail.com"

        mvc.perform(
            post("/account/register")
                .param("nickname", username)
                .param("password", password)
                .param("email", email))
            .andExpect(status().isOk)
            .andDo(MockMvcResultHandlers.print())

        mvc.perform(
            post("/auth/sign-in-confirm")
                .param("email", email)
                .param("password", password))
            .andExpect(status().isOk)
    }
}