package com.hy.hynote.domain;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass // BaseTimeEntity를 상속할 경우 createdDate, modifiedDate도 칼럼으로 인식하게 함
@EntityListeners(AuditingEntityListener.class) //BaseTimeEntity에 Auditing 기능을 포함시킴 //Application 파일에도 @EnableJpaAuditing @이 필요
public abstract class BaseTimeEntity { //왜 abstract class?:

    @CreatedDate //Entity가 생성되어 저장될 때 시간이 자동 저장됨
    private LocalDateTime createdDate;

    @LastModifiedDate //변경될 때 시간이 자동 저장됨
    private LocalDateTime modifiedDate;
}
