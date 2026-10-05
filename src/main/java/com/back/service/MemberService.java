package com.back.service;

import com.back.entity.Member;
import com.back.exception.DomainException;
import com.back.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service // 비즈니스 로직을 담당하는 서비스 클래스를 스프링 빈으로 등록한다.
public class MemberService {
    private final MemberRepository memberRepository;

    // 회원 데이터를 조회하고 저장할 저장소를 주입받는다.
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 저장된 전체 회원 수를 반환한다.
    public long count() {
        return memberRepository.count();
    }

    // 사용자명이 중복되면 예외를 발생시키고, 중복되지 않으면 신규 회원을 저장해 반환한다.
    public Member join(String username, String password, String nickname) {
        findByUsername(username).ifPresent(m -> {
            throw new DomainException("409-1", "이미 존재하는 username 입니다.");
        });

        return memberRepository.save(new Member(username, password, nickname));
    }

    // 저장소에서 사용자명으로 회원을 조회하고 결과를 Optional로 반환한다.
    public Optional<Member> findByUsername(String username) {
        return memberRepository.findByUsername(username);
    }
}
