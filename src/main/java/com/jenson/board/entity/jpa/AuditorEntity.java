package com.jenson.board.entity.jpa;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class })
@Getter
public abstract class AuditorEntity {

    @Column(nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createAt;
    @Column(insertable = false)
    @LastModifiedDate
    private LocalDateTime updateAt;
}
