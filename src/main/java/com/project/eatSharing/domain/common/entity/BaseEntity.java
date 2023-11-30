package com.project.eatSharing.domain.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.hibernate.type.YesNoConverter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)// @createDate, @modifyDate 자동 사용하기 위해 추가
public abstract class BaseEntity {
    @Column(name = "DEL_AT")
    @Convert(converter = YesNoConverter.class)
    private boolean delAt;                // 삭제여부

    @CreatedDate
    @Column(name = "CREATE_DATE")
    private LocalDateTime createDate;     // 생성일자

    @CreatedBy
    @Column(name = "CREATE_BY")
    private String createBy;              // 생성자

    @LastModifiedDate
    @Column(name = "MODIFY_DATE")
    private LocalDateTime modifyDate;     // 수정일자

    @LastModifiedBy
    @Column(name = "MODIFY_BY")
    private String modifyBy;              // 수정자
}
