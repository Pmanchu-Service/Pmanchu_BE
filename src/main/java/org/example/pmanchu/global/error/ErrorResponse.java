package org.example.pmanchu.global.error;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ErrorResponse {
    private final int status;
    private final String message;

    @Builder
    ErrorResponse(int status,String code,String message) {
        this.status = status;
        this.message = message;
      }

}
