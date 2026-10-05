package com.back.jpa.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@MappedSuperclass // 별도 테이블 없이 이 클래스의 필드 매핑을 자식 엔티티에 상속한다.
@EntityListeners(AuditingEntityListener.class) // 엔티티의 저장·수정 이벤트에 생성·수정 시각을 기록하는 리스너를 연결한다.
@Getter // 필드 값을 읽는 getter 메서드를 자동 생성한다.
public class BaseIdAndTime {
    @Id // 엔티티를 식별하는 기본 키 필드로 지정한다.
    @GeneratedValue(strategy = IDENTITY) // DB의 자동 증가 기능으로 기본 키 값을 생성한다.
    private int id;

    @CreatedDate // JPA Auditing이 엔티티 생성 시각을 자동 기록한다.
    private LocalDateTime createDate;
    @LastModifiedDate // JPA Auditing이 최종 수정 시각을 자동 기록하며, 기본 설정에서는 생성 시에도 기록한다.
    private LocalDateTime modifyDate;
}
