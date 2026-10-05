package com.back.entity;

import com.back.jpa.entity.BaseIdAndTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity // 이 클래스를 DB 테이블과 매핑되는 JPA 엔티티로 지정한다.
@NoArgsConstructor // JPA가 객체를 생성할 때 사용할 매개변수 없는 생성자를 생성한다.
public class Member extends BaseIdAndTime {
    @Column(unique = true) // username 컬럼에 중복 값을 허용하지 않는 유니크 제약조건을 지정한다.
    private String username;
    private String password;
    private String nickname;

    // 사용자명, 비밀번호, 닉네임으로 회원 객체를 생성한다.
    public Member(String username, String password, String nickname) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
    }
}
