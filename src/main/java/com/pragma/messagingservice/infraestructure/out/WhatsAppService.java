package com.pragma.messagingservice.infraestructure.out;

import com.pragma.messagingservice.domain.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class WhatsAppService {
    private final String ACCESS_TOKEN = "EAAaMk1QgjKMBO9ccvnpKCoihTZB7kZBtymhnVA8n7XqC4veu8mXlFDcMJocXbCkG7Fe3Ee4z2ZBfrITS3OKRewxH03WJVkY0vlLi7ERgjlHIof8lyiXKeqCTlZBEz0LlhLOVDPCjzoTMHk4TEF0QNxMVBwBYizYMRlTF1hzi7eodiaJd5a41Cwjk3ANkitoYAJkwBZBP3M9XU8w7plUHv7YuOxO7KrExZCffoZD";
    private final String PHONE_NUMBER_ID = "596490826881628";

    private final String API_URL = "https://graph.facebook.com/v22.0/" + PHONE_NUMBER_ID + "/messages";

    public String sendMessage(Message message) {
        RestTemplate restTemplate = new RestTemplate();
        log.info(message.toString());
        // Crear headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + ACCESS_TOKEN);
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
        ResponseEntity<String> response = restTemplate.exchange(API_URL, HttpMethod.POST, request, String.class);
        log.info(response.getBody()); // Muestra el error en consola
        return response.getBody();
    }
}
