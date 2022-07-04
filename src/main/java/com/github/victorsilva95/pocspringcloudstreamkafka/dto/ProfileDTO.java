package com.github.victorsilva95.pocspringcloudstreamkafka.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public record ProfileDTO(@NotEmpty(message = "name is required") String name, @NotEmpty(message = "email is required") @Email(message = "email is not valid") String email) {
}
