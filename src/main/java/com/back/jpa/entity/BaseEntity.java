package com.back.jpa.entity;

import java.time.LocalDateTime;

// 모든 entity들의 조상
public abstract class BaseEntity {
    // 엔티티의 식별자를 반환하는 메서드를 하위 클래스에서 구현하도록 정의한다.
    public abstract int getId();

    // 엔티티의 생성 일시를 반환하는 메서드를 하위 클래스에서 구현하도록 정의한다.
    public abstract LocalDateTime getCreateDate();

    // 엔티티의 최종 수정 일시를 반환하는 메서드를 하위 클래스에서 구현하도록 정의한다.
    public abstract LocalDateTime getModifyDate();

    // 현재 객체의 클래스 이름을 패키지명 없이 모델 유형 코드로 반환한다.
    public String getModelTypeCode(){
        return this.getClass().getSimpleName();
    }
}
