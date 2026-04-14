package com.example.WebsocketDemoApplication.controller;

import com.example.WebsocketDemoApplication.dto.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/send") //send("app/send")
    @SendTo("/topic/messages")
    public Message broadcast(Message message) {
        System.out.println("Servidor recibió: " + message.getContent());
        return message;
    }
}
