package org.example.pmanchu.global.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PmanchuException extends RuntimeException {
    private final ErrorCode errorCode;
}