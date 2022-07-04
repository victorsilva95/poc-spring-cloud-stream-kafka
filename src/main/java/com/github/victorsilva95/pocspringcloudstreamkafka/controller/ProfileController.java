package com.github.victorsilva95.pocspringcloudstreamkafka.controller;

import com.github.victorsilva95.pocspringcloudstreamkafka.dto.ProfileDTO;
import com.github.victorsilva95.pocspringcloudstreamkafka.service.ProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/profile")
public class ProfileController {

    private final ProfileService profileService;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void createProfile(@RequestBody @Valid ProfileDTO profileDTO) {
        log.info("received profile: {}", profileDTO);
        profileService.createProfile(profileDTO);
    }
}
