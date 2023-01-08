package com.yeseong.chat.config

import com.yeseong.chat.service.ChatHandler
import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.WebSocketConfigurer
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry

@Configuration
@EnableWebSocket
class WebSocketConfig(
    private val chatHandler: ChatHandler,
) : WebSocketConfigurer {
    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        // "ws://localhost:8080/chat"을 통해 web socket에 연결 가능하도록 설정
        registry.addHandler(chatHandler, "/chat")
            .setAllowedOrigins("*")
    }
}