package com.andinet.busChat.controller;

import com.andinet.busChat.model.ChatMessageModel;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;

public class ChatController {
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessageModel sendMessage(@Payload ChatMessageModel chatMessageModel) {
        return chatMessageModel;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    //when somebody join chat
    public ChatMessageModel addUser(@Payload ChatMessageModel chatMessageModel, SimpMessageHeaderAccessor headerAccessor) {

// Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessageModel.getSender());
        return chatMessageModel;
    }

}
