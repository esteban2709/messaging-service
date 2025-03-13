package com.pragma.messagingservice.infraestructure.out.client.adapter;

import com.pragma.messagingservice.domain.model.Message;
import com.pragma.messagingservice.domain.spi.IWhatsAppClientPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class WhatsAppClientAdapter implements IWhatsAppClientPort {

    @Value("${whatsapp.access.token}")
    private String accessToken;

    @Value("${whatsapp.api.url}")
    private String apiUrl;

    @Override
    public String sendMessage(Message message) {
        RestTemplate restTemplate = new RestTemplate();
        log.info(message.toString());
        // Crear headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        headers.set("Content-Type", "application/json");

        // Crear body de la petición
        Map<String, Object> body = new HashMap<>();
        body.put("messaging_product", "whatsapp");
        body.put("to", message.getTo());
        body.put("type", "text");

        Map<String, String> text = new HashMap<>();
        text.put("body", message.getMessage());
        body.put("text", text);

        // Enviar la petición
        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.POST, request, String.class);
        log.info(response.getBody()); // Muestra el error en consola
        return response.getBody();
    }
}
