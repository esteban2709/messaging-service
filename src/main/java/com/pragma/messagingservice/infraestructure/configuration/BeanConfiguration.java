package com.pragma.messagingservice.infraestructure.configuration;

import com.pragma.messagingservice.domain.api.IMessageServicePort;
import com.pragma.messagingservice.domain.spi.IWhatsAppClientPort;
import com.pragma.messagingservice.domain.usecase.MessageUseCase;
import com.pragma.messagingservice.infraestructure.out.client.adapter.WhatsAppClientAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public IWhatsAppClientPort whatsAppClientPort(){
        return new WhatsAppClientAdapter();
    }

    @Bean
    public IMessageServicePort messageService() {
        return new MessageUseCase(whatsAppClientPort());
    }
}
