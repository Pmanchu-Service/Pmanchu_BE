package org.example.pmanchu.domain.user.exception;

import org.example.pmanchu.global.error.exception.ErrorCode;
import org.example.pmanchu.global.error.exception.PmanchuException;

public class InvalidCodeException extends PmanchuException {
    public static final PmanchuException EXCEPTION = new InvalidCodeException();

    public InvalidCodeException() {
        super(ErrorCode.INVALID_CODE);
    }
}
