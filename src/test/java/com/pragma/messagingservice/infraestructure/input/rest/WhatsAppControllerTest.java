package com.pragma.messagingservice.infraestructure.input.rest;

import com.pragma.messagingservice.application.handler.IMessageHandler;
import com.pragma.messagingservice.domain.model.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WhatsAppController.class)
class WhatsAppControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private IMessageHandler messageHandler;

    private Message message;

    @BeforeEach
    void setUp() {
        message = new Message();
        message.setTo("123456789");
        message.setMessage("Hello, World!");
    }

    @Test
    void sendMessage() throws Exception {
        when(messageHandler.sendMessage(any(Message.class))).thenReturn("Message sent");

        mockMvc.perform(post("/api/v1/whatsapp/send")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"to\":\"123456789\",\"message\":\"Hello, World!\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Message sent"));
    }
}