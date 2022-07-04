package com.github.victorsilva95.pocspringcloudstreamkafka.model;

import com.github.victorsilva95.pocspringcloudstreamkafka.dto.ProfileDTO;
import com.github.victorsilva95.pocspringcloudstreamkafka.event.ProfileEvent;
import com.github.victorsilva95.pocspringcloudstreamkafka.event.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.github.victorsilva95.pocspringcloudstreamkafka.event.Status.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Profile extends AbstractAggregateRoot<Profile> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Email(message = "email is not valid")
    private String email;

    private LocalDateTime createdDate;
    private LocalDateTime updateDate;

    public Profile(ProfileDTO profileDTO) {
        this.name = profileDTO.name();
        this.email = profileDTO.email();
    }


    @PrePersist
    public void onPrePersist() {
        this.createdDate = LocalDateTime.now();
    }

    @PostPersist
    public void onPostPersist() {
        registerEvent(new ProfileEvent(id, name, email, CREATED));
    }

    @PreUpdate
    public void onPreUpdate() {
        this.updateDate = LocalDateTime.now();
    }

    @PostUpdate
    public void onPostUpdate() {
        registerEvent(new ProfileEvent(id, name, email, UPDATED));
    }
}
