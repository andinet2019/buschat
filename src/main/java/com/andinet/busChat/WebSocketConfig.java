package com.andinet.busChat;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


    @Configuration
    //enable the WebSocket Server
    //WebSocketMessageBrokerConfigurer  is to establish webSocket connection
    @EnableWebSocketMessageBroker
    public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
 //STOMP is a messaging protocol that defines the rules and format for data exchanging
 //helps to send message to particular user cuz webSocket doesnot have that functionality
        @Override
        public void registerStompEndpoints(StompEndpointRegistry registry) {
            registry.addEndpoint("/ws").withSockJS();
        }
//broadcasting message from another user to appear in consecutive user
        @Override
        public void configureMessageBroker(MessageBrokerRegistry registry) {
            registry.setApplicationDestinationPrefixes("/app");
            registry.enableSimpleBroker("/topic");
        }
    }

