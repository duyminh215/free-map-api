package com.duyminh215.map.constant;

import org.springframework.http.HttpStatus;

import com.duyminh215.map.locale.Translator;

public enum ResponseStatusCode {

    SUCCESS(HttpStatus.OK, "msg.success"), SUCCESS_CANCEL_VTP_SERVICE(HttpStatus.OK, "msg.success_cancel_vtp_service"),
    BUSINESS_ERROR(HttpStatus.BAD_REQUEST, "error.msg.business_error"),
    VALIDATION_ERROR(HttpStatus.BAD_REQUEST, "error.msg.validation_error"),
    INTERNAL_GENERAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "error.msg.internal_general_server_error"),
    ID_NO_IS_REQUIRED(HttpStatus.BAD_REQUEST, "error.msg.id_no_is_required"),
    DO_NOT_HAVE_PERMISSION(HttpStatus.UNAUTHORIZED, "error.msg.do_not_have_permission"),
    NO_CONTENT(HttpStatus.NO_CONTENT, "error.msg.no_content"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "error.msg.bad_request"),
    REGISTER_SUCCESS(HttpStatus.OK, "msg.success.register"),
    REGISTER_SUCCESS_APPROVED(HttpStatus.OK, "msg.success.register.approved");
    ;

    // Adds more response codes here

    private String message;
    private HttpStatus httpCode;

    ResponseStatusCode(HttpStatus httpCode, String message) {
        this.httpCode = httpCode;
        this.message = Translator.toLocale(message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = Translator.toLocale(message);
    }

    public HttpStatus getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(HttpStatus httpCode) {
        this.httpCode = httpCode;
    }

    @Override
    public String toString() {
        return "ResponseStatus{" + "code='" + httpCode + '\'' + "message='" + Translator.toLocale(message) + '\'' + '}';
    }

}