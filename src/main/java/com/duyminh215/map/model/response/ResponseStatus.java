package com.duyminh215.map.model.response;

import com.duyminh215.map.constant.ResponseStatusCode;
import com.duyminh215.map.locale.Translator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

/**
 * Format of response status returned to client
 *
 * @author xuatdd
 * @version 1.0
 * @since 2020/03/01
 */

public class ResponseStatus implements Serializable {

    public ResponseStatus() {
    }

    public ResponseStatus(ResponseStatusCode responseStatus) {
        this.code = String.valueOf(responseStatus.getHttpCode().value());
        this.message = Translator.toLocale(responseStatus.getMessage());
    }

    public ResponseStatus(String code, boolean setMessageImplicitly) {
        setCode(code, setMessageImplicitly);
    }

    @JsonProperty("code")
    private String code;

    /**
     * Set the code. this will implicitly set the message based on the locale
     *
     * @param code
     */
    public void setCode(String code) {
        setCode(code, true);
    }

    /**
     * Set the code
     *
     * @param code
     */
    public void setCode(String code, boolean setMessageImplicitly) {
        this.code = code;
        if (setMessageImplicitly) {
            this.message = Translator.toLocale(code);
        }
    }

    public String getCode() {
        return code;
    }

    @JsonProperty("message")
    private String message;

    @Override
    public String toString() {
        return "{" + "\"code\":\"" + code + "\"" + ", \"message\":\"" + message + "\"" + '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
