package org.example.pmanchu.global.security.exception;

import org.example.pmanchu.global.error.exception.ErrorCode;
import org.example.pmanchu.global.error.exception.PmanchuException;

public class InvalidTokenException extends PmanchuException {
    public final static PmanchuException EXCEPTION = new InvalidTokenException();

    public InvalidTokenException() {
        super(ErrorCode.INVALID_TOKEN);
    }
}
