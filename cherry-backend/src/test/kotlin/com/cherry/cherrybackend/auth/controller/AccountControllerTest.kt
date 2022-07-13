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
class AccountControllerTest @Autowired constructor(val mvc: MockMvc) {

    @Test
    fun register() {
        val username = ""
        val password = ""
        val email = ""
        mvc.perform(post("/account/register")
            .param("nickname", username)
            .param("password", password)
            .param("email", email))
            .andExpect(status().isOk)
    }

    @Test
    fun leave() {
        register()

        val id = 1
        mvc.perform(post("/account/leave")
            .param("id", id.toString()))
            .andExpect(status().isOk)
            .andReturn()
    }
}