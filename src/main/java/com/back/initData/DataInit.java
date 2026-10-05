package com.back.initData;

import com.back.entity.Member;
import com.back.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

@Configuration // @Bean 메서드를 통해 스프링 빈을 등록하는 설정 클래스로 지정한다.
@Slf4j // 로그를 출력할 수 있는 SLF4J log 필드를 자동 생성한다.
public class DataInit {
    private final DataInit self;
    private final MemberService memberService;

    // 트랜잭션 적용을 위한 자기 자신의 프록시와 회원 서비스를 주입받는다.
    public DataInit(@Lazy /* 지연 조회 프록시를 주입하여 self 의존성을 실제 사용 시점에 해결한다. */ DataInit self, MemberService memberService) {
        this.self = self;
        this.memberService = memberService;
    }

    // 애플리케이션 시작 시 기본 회원 초기화를 실행하는 빈을 등록한다.
    @Bean // 반환하는 ApplicationRunner 객체를 스프링이 관리하는 빈으로 등록한다.
    public ApplicationRunner baseInitDataRunner() {
        return args -> {
            self.makeBaseMembers();
        };
    }

    // 등록된 회원이 없으면 기본 계정 여섯 개를 하나의 트랜잭션으로 생성한다.
    @Transactional // 메서드 실행을 하나의 트랜잭션으로 묶고, 기본적으로 런타임 예외나 Error 발생 시 롤백한다.
    public void makeBaseMembers() {
        if (memberService.count() > 0) return;

        Member systemMember = memberService.join("system", "1234", "시스템");
        Member holdingMember = memberService.join("holding", "1234", "홀딩");
        Member adminMember = memberService.join("admin", "1234", "관리자");
        Member user1Member = memberService.join("user1", "1234", "유저1");
        Member user2Member = memberService.join("user2", "1234", "유저2");
        Member user3Member = memberService.join("user3", "1234", "유저3");
    }
}
