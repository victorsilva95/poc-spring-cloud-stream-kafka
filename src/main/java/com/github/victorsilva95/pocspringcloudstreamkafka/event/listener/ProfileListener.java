package com.github.victorsilva95.pocspringcloudstreamkafka.event.listener;

import com.github.victorsilva95.pocspringcloudstreamkafka.event.ProfileEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.ErrorMessage;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import java.nio.charset.StandardCharsets;

@Component
@Slf4j
@RequiredArgsConstructor
public class ProfileListener {

    private final StreamBridge bridge;

    @TransactionalEventListener
    public void handleProfileActions(ProfileEvent profileEvent) {
        log.info("======= Handiling profileEvent =======");
       final Message<ProfileEvent> profileEventMessageBuilder = MessageBuilder.withPayload(profileEvent)
                .setHeader(KafkaHeaders.MESSAGE_KEY, profileEvent.id().toString()).build();

        bridge.send("produceProfile-out-0", profileEventMessageBuilder);

    }

    @ServiceActivator(inputChannel = "errorChannel")
    public void handleErrors(final ErrorMessage em) {
        log.error("encountered exception" + em.toString());
    }
}
