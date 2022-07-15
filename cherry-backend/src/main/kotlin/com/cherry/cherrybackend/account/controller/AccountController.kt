package com.cherry.cherrybackend.account.controller

import com.cherry.cherrybackend.account.controller.request.AccountSignUpRequest
import com.cherry.cherrybackend.account.service.AccountService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/account")
class AccountController(private val accountService: AccountService) {

    @PostMapping("register")
    fun register(request: AccountSignUpRequest): ResponseEntity<Any> {
        if(accountService.register(request) > 0) {
            return ResponseEntity.ok(mapOf("result" to "SUCCESS"))
        }
        return ResponseEntity.ok(mapOf("result" to "FAIL"))
    }

    @PostMapping("leave")
    fun leave(@RequestParam id: Long): ResponseEntity<Any> {
        if(accountService.leave(id)) {
            return ResponseEntity.ok(mapOf("result" to "SUCCESS"))
        }
        return ResponseEntity.ok(mapOf("result" to "FAIL"))
    }

    @PostMapping("permanently-delete")
    fun permanentlyDelete(@RequestParam id: Long): ResponseEntity<Any> {
        if(accountService.permanentlyDelete(id)) {
            return ResponseEntity.ok(mapOf("result" to "SUCCESS"))
        }
        return ResponseEntity.ok(mapOf("result" to "FAIL"))
    }
}