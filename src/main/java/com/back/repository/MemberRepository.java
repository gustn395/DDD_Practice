package com.back.repository;

import com.back.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    // 사용자명으로 회원을 조회하고 조회 결과를 Optional로 반환한다.
    Optional<Member> findByUsername(String username);

}
