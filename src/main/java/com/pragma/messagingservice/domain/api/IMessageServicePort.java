package com.pragma.messagingservice.domain.api;

import com.pragma.messagingservice.domain.model.Message;

public interface IMessageServicePort {

    String sendMessage(Message message);

}
