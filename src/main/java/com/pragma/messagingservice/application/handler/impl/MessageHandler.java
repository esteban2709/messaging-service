package com.pragma.messagingservice.application.handler.impl;

import com.pragma.messagingservice.application.handler.IMessageHandler;
import com.pragma.messagingservice.domain.api.IMessageServicePort;
import com.pragma.messagingservice.domain.model.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageHandler implements IMessageHandler {

    private final IMessageServicePort messageServicePort;

    @Override
    public String sendMessage(Message message) {
        return messageServicePort.sendMessage(message);
    }
}
