package com.back.exception;

import lombok.Getter;

@Getter // 필드 값을 읽는 getter 메서드를 자동 생성한다.
public class DomainException extends RuntimeException {
    private final String resultCode;
    private final String msg;

    // 결과 코드와 오류 설명을 저장하고 예외 메시지를 구성한다.
    public DomainException(String resultCode, String msg) {
        super(resultCode + " : " + msg);
        this.resultCode = resultCode;
        this.msg = msg;
    }
}
