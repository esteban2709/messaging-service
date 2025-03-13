package com.pragma.messagingservice.domain.spi;

import com.pragma.messagingservice.domain.model.Message;

public interface IWhatsAppClientPort {

    String sendMessage(Message message);
}
