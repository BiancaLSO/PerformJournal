package com.ensemble.pj.exception;

public enum ErrorCode {

    // 400
    BAD_REQUEST(40001),
    OBJECT_ALREADY_EXISTS(40004),
    // 404
    OBJECT_NOT_FOUND(40401),

    // 415
    UNSUPPORTED_FILE_TYPE(41501),

    // 500
    INTERNAL_ERROR(50001);

    public int getCode() {
        return this.code;
    }

    private int code;

    private ErrorCode(int code) {
        this.code = code;
    }
}
