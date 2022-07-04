package com.github.victorsilva95.pocspringcloudstreamkafka.event;

public record ProfileEvent(Long id, String name, String email, Status status) {

}
