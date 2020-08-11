package com.duyminh215.map.exception;

public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = -2777373325976335319L;
    private String errorCode;
    private String message;

    /**
     * Construct a new instance of {@code RestClientException} with the given
     * message.
     *
     * @param msg the message
     */
    public BusinessException(String msg) {
        super(msg);
        this.message = msg;
    }

    /**
     * Construct a new instance of {@code RestClientException} with the given
     * message and exception.
     *
     * @param msg the message
     * @param ex  the exception
     */
    public BusinessException(String msg, Throwable ex) {
        super(msg, ex);
        this.message = msg;
    }

    /**
     * Construct a new instance of {@code RestClientException} with the given
     * message and exception.
     * 
     * @param errorCode the message
     * @param msg       the message
     * @param ex        the exception
     */
    public BusinessException(String errorCode, String msg, Throwable ex) {
        super(msg, ex);
        this.errorCode = errorCode;
        this.message = msg;
    }

    /**
     * Construct a new instance of {@code RestClientException} with the given
     * message and exception.
     * 
     * @param errorCode the message
     * @param msg       the message
     */
    public BusinessException(String errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
        this.message = msg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
