package com.pragma.messagingservice.application.handler;

import com.pragma.messagingservice.domain.model.Message;

public interface IMessageHandler {

    String sendMessage(Message message);
}
