package com.pragma.messagingservice.domain.usecase;

import com.pragma.messagingservice.domain.api.IMessageServicePort;
import com.pragma.messagingservice.domain.model.Message;
import com.pragma.messagingservice.domain.spi.IWhatsAppClientPort;

public class MessageUseCase implements IMessageServicePort {

    private final IWhatsAppClientPort whatsAppClientPort;

    public MessageUseCase(IWhatsAppClientPort whatsAppClientPort) {
        this.whatsAppClientPort = whatsAppClientPort;
    }

    @Override
    public String sendMessage(Message message) {
        return whatsAppClientPort.sendMessage(message);
    }
}
