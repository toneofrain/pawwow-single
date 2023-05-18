package dev.saintho.pawwow.domain.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.util.StringUtils;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String profileImage;
    @Column(nullable = false)
    private String briefDescription;
    @Column(nullable = false)
    private String detailDescription;
    @Column(nullable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private PetType type;
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime modifiedAt;

    public boolean hasId() {
        return id != null;
    }

    @Builder
    private Pet(String name, String profileImage, String briefDescription, String detailDescription, PetType type) {
        validateName(name);
        validateProfileImage(profileImage);
        validateBriefDescription(briefDescription);
        validateDetailDescription(detailDescription);

        this.name = name;
        this.profileImage = profileImage;
        this.briefDescription = briefDescription;
        this.detailDescription = detailDescription;
        this.type = type;
    }

    private void validateName(String name) {
        if (!StringUtils.hasText(name) || name.length() > 255) {
            throw new IllegalArgumentException("Pet Name Must Have A Text With A Length Less Than 256");
        }
    }

    private void validateProfileImage(String profileImage) {
        if (!StringUtils.hasText(profileImage) || profileImage.length() > 255) {
            throw new IllegalArgumentException(
                "ProfileImage Must Be A Filename With An Image Extension and a Length Less Than 256");
        }
    }

    private void validateBriefDescription(String briefDescription) {
        if (!StringUtils.hasText(briefDescription) || briefDescription.length() > 255) {
            throw new IllegalArgumentException("Brief Description Must Have A Text With A Length Less Than 256");
        }
    }

    private void validateDetailDescription(String detailDescription) {
        if (!StringUtils.hasText(detailDescription) || detailDescription.length() > 255) {
            throw new IllegalArgumentException("Detail Description Must Have A Text With A Length Less Than 256");
        }
    }
}
