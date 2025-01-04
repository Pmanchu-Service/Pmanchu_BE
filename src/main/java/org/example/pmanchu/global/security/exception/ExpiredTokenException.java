package org.example.pmanchu.global.security.exception;

import org.example.pmanchu.global.error.exception.ErrorCode;
import org.example.pmanchu.global.error.exception.PmanchuException;

public class ExpiredTokenException extends PmanchuException {
 public static final PmanchuException EXCEPTION = new ExpiredTokenException();

    public ExpiredTokenException() {
        super(ErrorCode.EXPIRED_TOKEN);
    }
}
