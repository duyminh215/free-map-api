package com.duyminh215.map.exception;

public class ExceptionStatusResponse {

    private ErrorResponse status;

    public ExceptionStatusResponse(ErrorResponse status) {
        this.status = status;
    }

    public ErrorResponse getStatus() {
        return status;
    }

    public void setStatus(ErrorResponse status) {
        this.status = status;
    }
}
