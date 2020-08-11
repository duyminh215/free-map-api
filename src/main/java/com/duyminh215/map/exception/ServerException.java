package com.duyminh215.map.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.duyminh215.map.constant.ErrorMessage;

public class ServerException extends ResponseStatusException {

    private static final long serialVersionUID = 1L;
    /** The error message. */
    private final ErrorMessage errorMessage;

    private final Object args;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message = null;

    /**
     * Instantiates a new epic exception.
     * 
     * @param pErrorMessage the error message
     */
    public ServerException(ErrorMessage pErrorMessage) {
        super(HttpStatus.NOT_FOUND, pErrorMessage.getMessage());
        errorMessage = pErrorMessage;
        args = null;
    }

    public ServerException(ErrorMessage pErrorMessage, Object... pArgs) {
        super(HttpStatus.NOT_FOUND, pErrorMessage.getMessage());
        // pErrorMessage.setMessage(messagesApi.get(Lang.forCode(lang),
        // pErrorMessage.getMessage(), args));
        errorMessage = pErrorMessage;
        args = pArgs;
    }

    // TODO handler should log out the cause
    public ServerException(ErrorMessage pErrorMessage, Throwable cause) {
        super(HttpStatus.NOT_FOUND, pErrorMessage.getMessage());
        errorMessage = pErrorMessage;
        args = null;
    }

    public ServerException() {
        super(HttpStatus.NOT_FOUND);
        errorMessage = null;
        args = null;
    }

    /**
     * Gets the error message.
     * 
     * @return the code
     */
    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }

    public Object getArgs() {
        return args;
    }
}
