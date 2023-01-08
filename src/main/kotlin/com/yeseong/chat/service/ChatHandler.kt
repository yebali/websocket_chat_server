package com.yeseong.chat.service

import org.springframework.stereotype.Component
import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler

@Component
class ChatHandler : TextWebSocketHandler() {
    val sessions = mutableSetOf<WebSocketSession>()

    // web socket을 통해 client가 보낸 메시지를 처리
    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        println("${session.id} send ${message.payload}")

        sessions.forEach {
            it.sendMessage(message)
        }
    }

    // web socket 연결 후 호출되는 메서드
    override fun afterConnectionEstablished(session: WebSocketSession) {
        sessions.add(session)

        println("${session.id} is connected")
    }

    // web socket 연결 해제 후 호출되는 메서드
    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        sessions.remove(session)

        println("${session.id} is disconnected")
    }
}