package com.ensemble.pj.exception;

public class UserServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private ErrorCode code;

    public UserServiceException(ErrorCode code, String message) {
        super(message);
        this.code = code;
    }

    public ErrorCode getCode() {
        return code;
    }

}
