package com.solarisgroup.demo.demo.entity;

import jakarta.persistence.Convert;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @CreatedDate
    @Convert(converter = Jsr310JpaConverters.InstantConverter.class)
    private Instant createdAt;

    @LastModifiedDate
    @Convert(converter = Jsr310JpaConverters.InstantConverter.class)
    private Instant updatedAt;
}
