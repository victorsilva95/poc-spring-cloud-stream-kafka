package com.github.victorsilva95.pocspringcloudstreamkafka.event.consumer;

import com.github.victorsilva95.pocspringcloudstreamkafka.event.ProfileEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@Slf4j
public class ProfileConsumer {


    @Bean
    public Consumer<Message<ProfileEvent>> consumeProfile() {
        return profileEventMessage -> log.info("Received message: {}",profileEventMessage.getPayload());
    }
}
