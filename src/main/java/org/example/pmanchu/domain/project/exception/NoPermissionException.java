package org.example.pmanchu.domain.project.exception;

import org.example.pmanchu.global.error.exception.ErrorCode;
import org.example.pmanchu.global.error.exception.PmanchuException;

public class NoPermissionException extends PmanchuException {
    public static final PmanchuException EXCEPTION = new NoPermissionException();

    public NoPermissionException() {
        super(ErrorCode.NO_PERMISSION);
    }
}
