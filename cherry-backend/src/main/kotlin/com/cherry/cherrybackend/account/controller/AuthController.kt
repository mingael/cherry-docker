package com.cherry.cherrybackend.account.controller

import com.cherry.cherrybackend.account.controller.request.AuthSignInRequest
import com.cherry.cherrybackend.account.service.AuthService
import org.apache.tomcat.util.http.ResponseUtil
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpServletRequest

@Controller
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