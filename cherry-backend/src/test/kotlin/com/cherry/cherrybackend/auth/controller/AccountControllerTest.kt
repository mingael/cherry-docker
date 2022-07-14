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
class AccountControllerTest @Autowired constructor(val mvc: MockMvc) {

    private val username = "username"
    private val password = "pa1Fw#rd"
    private val email = "email@gmail.com"

    @Test
    fun register() {
        mvc.perform(post("/account/register")
            .param("nickname", username)
            .param("password", password)
            .param("email", email))
            .andExpect(status().isOk)
            .andDo(MockMvcResultHandlers.print())
    }

    @Test
    fun registerOver() {
        register()
        register()
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

    @Test
    fun permanentlyDelete() {
        register()

        val id = 1
        mvc.perform(post("/account/permanently-delete")
            .param("id", id.toString()))
            .andExpect(status().isOk)
            .andReturn()
    }

}