package com.pragma.messagingservice.infraestructure.input.rest;

import com.pragma.messagingservice.application.handler.IMessageHandler;
import com.pragma.messagingservice.domain.model.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/whatsapp")
@RequiredArgsConstructor
public class WhatsAppController {

    private final IMessageHandler messageHandler;

    @PostMapping("/send")
    public String sendMessage(@RequestBody Message message) {
        return messageHandler.sendMessage(message);
    }
}
