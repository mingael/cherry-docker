package com.cherry.cherrybackend.account.controller

import com.cherry.cherrybackend.account.controller.request.AuthSignInRequest
import com.cherry.cherrybackend.account.service.AuthService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController (private val authService: AuthService) {

    @PostMapping("sign-in-confirm")
    fun singIn(request: AuthSignInRequest): ResponseEntity<Any> {
        val auth = authService.signInConfirm(request)
        if(auth != null) {
            return ResponseEntity.ok(auth)
        }

        return ResponseEntity.ok(mapOf("result" to "FAIL"))
    }

}