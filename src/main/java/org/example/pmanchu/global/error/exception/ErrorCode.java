package org.example.pmanchu.global.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    USER_NOT_FOUND(400,"일치하는 유저를 찾을 수 없습니다."),
    PROJECT_NOT_FOUND(400,"일치하는 프로젝트를 찾을 수 없습니다."),
    INTERNAL_SERVER_ERROR(500, "서버 에러가 발생했습니다."),
    EXPIRED_TOKEN(401,"만료된 토큰입니다."),
    INVALID_TOKEN(401,"허가되지 않은 토큰입니다."),
    INVALID_CODE(401,"잘못된 코드입니다. "),
    NO_PERMISSION(403,"권한이 없습니다");
    private final int httpStatus;
    private final String message;
}