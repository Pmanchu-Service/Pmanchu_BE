package org.example.pmanchu.domain.user.exception;

import org.example.pmanchu.global.error.exception.ErrorCode;
import org.example.pmanchu.global.error.exception.PmanchuException;

public class UserNotFoundException extends PmanchuException {
    public static final PmanchuException EXCEPTION = new UserNotFoundException();

    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
