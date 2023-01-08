package com.yeseong.chat.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthController {
    @GetMapping("/health")
    fun getChatString(): String {
        return "health is good"
    }
}