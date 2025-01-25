package org.example.pmanchu.domain.project.exception;

import org.example.pmanchu.global.error.exception.ErrorCode;
import org.example.pmanchu.global.error.exception.PmanchuException;

public class ProjectNotFoundException extends PmanchuException {
    public static final PmanchuException EXCEPTION = new ProjectNotFoundException();

    public ProjectNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
