package com.pragma.messagingservice.domain.usecase;

import com.pragma.messagingservice.domain.model.Message;
import com.pragma.messagingservice.domain.spi.IWhatsAppClientPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class MessageUseCaseTest {

    @Mock
    private IWhatsAppClientPort whatsAppClientPort;

    private MessageUseCase messageUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        messageUseCase = new MessageUseCase(whatsAppClientPort);
    }

    @Test
    void sendMessage() {
        Message message = new Message();
        message.setTo("123456789");
        message.setMessage("Hello, World!");

        when(whatsAppClientPort.sendMessage(any(Message.class))).thenReturn("Message sent");

        String result = messageUseCase.sendMessage(message);

        assertEquals("Message sent", result);
    }
}