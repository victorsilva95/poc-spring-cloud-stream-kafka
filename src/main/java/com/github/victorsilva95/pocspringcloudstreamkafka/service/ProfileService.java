package com.github.victorsilva95.pocspringcloudstreamkafka.service;

import com.github.victorsilva95.pocspringcloudstreamkafka.dto.ProfileDTO;
import com.github.victorsilva95.pocspringcloudstreamkafka.model.Profile;
import com.github.victorsilva95.pocspringcloudstreamkafka.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;


    public void createProfile(ProfileDTO profileDTO) {
        Profile profile = new Profile(profileDTO);
        profileRepository.save(profile);
    }
}
