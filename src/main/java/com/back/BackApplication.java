package com.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication // 스프링 부트의 자동 설정과 컴포넌트 스캔을 활성화한다.
@EnableJpaAuditing // 엔티티의 생성·수정 시각 등을 자동 기록하는 JPA Auditing을 활성화한다.
public class BackApplication {

	// 스프링 부트 애플리케이션을 시작한다.
	public static void main(String[] args) {
		SpringApplication.run(BackApplication.class, args);
	}

}
