package org.example.pmanchu.global.error;

import org.example.pmanchu.global.error.exception.ErrorCode;
import org.example.pmanchu.global.error.exception.PmanchuException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class PmanchuExceptionHandler {

    @ExceptionHandler(PmanchuException.class)
    public ResponseEntity<ErrorResponse> customExceptionHandling(PmanchuException e) {
        final ErrorCode errorCode = e.getErrorCode();

        return new ResponseEntity<>(
                ErrorResponse.builder()
                        .status(errorCode.getHttpStatus())
                        .message(errorCode.getMessage())
                        .build(),
                HttpStatus.valueOf(errorCode.getHttpStatus())
        );
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<?> bindExceptionHandling(BindException e) {
        Map<String, String> errorList = new HashMap<>();
        for (FieldError error : e.getFieldErrors()) {
            errorList.put(error.getField(),
                    error.getDefaultMessage());
        }

        return new ResponseEntity<>(errorList, HttpStatus.BAD_REQUEST);
    }
}