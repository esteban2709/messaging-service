package com.pragma.messagingservice.infraestructure.input.rest;

import com.pragma.messagingservice.domain.model.Message;
import com.pragma.messagingservice.infraestructure.out.WhatsAppService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/whatsapp")
public class WhatsAppController {

    private final WhatsAppService whatsappService;

    public WhatsAppController(WhatsAppService whatsappService) {
        this.whatsappService = whatsappService;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestBody Message message) {
        return whatsappService.sendMessage(message);
    }
}
