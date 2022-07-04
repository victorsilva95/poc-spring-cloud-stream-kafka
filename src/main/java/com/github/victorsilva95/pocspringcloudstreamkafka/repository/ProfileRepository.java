package com.github.victorsilva95.pocspringcloudstreamkafka.repository;

import com.github.victorsilva95.pocspringcloudstreamkafka.model.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}
