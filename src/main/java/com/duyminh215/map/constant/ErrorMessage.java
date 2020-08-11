package com.duyminh215.map.constant;

import org.springframework.http.HttpStatus;

public enum ErrorMessage {
    // Rule : XXYYY, XX : Controller , YYY auto increment
    // Example : 1 - User Controller,
    // http code : 412 : precodition fail, 403 : forbidden, 500 - Internal Server
    // Exception, HttpStatus.INTERNAL_SERVER_ERROR - Custom error code
    /** COMMON ******/

    SESSION_EXPIRED(4903, "session_expired", HttpStatus.BAD_REQUEST),

    UNSUPPORTED_VERSION(103, "unsupported_version", HttpStatus.PRECONDITION_FAILED),
    /** Invalid checksum key. */
    INVALID_CHECKSUM_KEY(104, "invalid_checksum_key", HttpStatus.PRECONDITION_FAILED),
    INVALID_INPUT_DATA(105, "invalid_input_data", HttpStatus.PRECONDITION_FAILED),
    /**** USER ******/
    /** User exists in system. */
    EXISTED_USER(1001, "existed_user", HttpStatus.INTERNAL_SERVER_ERROR),

    EXISTED_EMAIL(1010, "existed_email", HttpStatus.INTERNAL_SERVER_ERROR),

    /** User doesn't exist in system. */
    USER_NOT_FOUND(1002, "user_not_found", HttpStatus.NOT_FOUND),

    PHONE_TO_TRANSFER_NOT_EXIST(1007, "phone_to_transfer_not_exist", HttpStatus.INTERNAL_SERVER_ERROR),
    /** User suspended */
    USER_SUSPENDED(1003, "user_suspended", HttpStatus.INTERNAL_SERVER_ERROR),
    /** Invalid authorized */
    INVALID_AUTHORIZED(1004, "invalid_authorized", HttpStatus.BAD_REQUEST),
    /** Invalid password */
    PASSWORD_NOT_MATCH(1005, "password_not_match", HttpStatus.INTERNAL_SERVER_ERROR),

    INVALID_EMAIL(1008, "invalid_email", HttpStatus.BAD_REQUEST),

    INVALID_ADDRESS(1009, "invalid_address", HttpStatus.BAD_REQUEST),

    INVALID_FILE(1011, "invalid_file", HttpStatus.BAD_REQUEST),

    INVALID_FULLNAME(1012, "invalid_fullname", HttpStatus.BAD_REQUEST),

    INVALID_USER_IDENTITY(1013, "invalid_identity", HttpStatus.BAD_REQUEST),

    REGISTER_NAME_EMPTY(1016, "register_name_empty", HttpStatus.BAD_REQUEST),

    REGISTER_PASSWORD_EMPTY(1017, "register_password_empty", HttpStatus.BAD_REQUEST),

    REGISTER_PHONE_EMPTY(1018, "register_phone_empty", HttpStatus.BAD_REQUEST),

    AVATAR_CAN_NOT_CHANGE_WITH_IDENTITY_USER(1014, "avatar_can_not_change_with_identity_user", HttpStatus.BAD_REQUEST),

    USER_INFO_CAN_NOT_CHANGE_WITH_IDENTITY_USER(1015, "user_info_can_not_change_with_identity_user",
            HttpStatus.BAD_REQUEST),

    USER_LOCKED_BECAUSE_OF_WRONG_PASS_MANY_TIMES(1006, "user_locked_because_of_wrong_pass_many_times",
            HttpStatus.INTERNAL_SERVER_ERROR),

    IDENTITY_FULL_NAME_EMPTY(1100, "identity_full_name_empty", HttpStatus.BAD_REQUEST),

    IDENTITY_ID_NUMBER_EMPTY(1101, "identity_id_number_empty", HttpStatus.BAD_REQUEST),

    IDENTITY_ID_ISSUE_DATE_EMPTY(1102, "identity_id_issue_date_empty", HttpStatus.BAD_REQUEST),

    IDENTITY_ID_LOCATION_EMPTY(1103, "identity_id_location_empty", HttpStatus.BAD_REQUEST),

    IDENTITY_NATIONALITY_EMPTY(1104, "identity_nationality_empty", HttpStatus.BAD_REQUEST),

    IDENTITY_ID_REGISTERED_ADDRESS_EMPTY(1105, "identity_id_registered_address_empty", HttpStatus.BAD_REQUEST),

    IDENTITY_CURRENT_ADDRESS_EMPTY(1106, "identity_current_address_empty", HttpStatus.BAD_REQUEST),

    IDENTITY_EMAIL_EMPTY(1107, "identity_email_empty", HttpStatus.BAD_REQUEST),

    IDENTITY_PHONE_EMPTY(1108, "identity_phone_empty", HttpStatus.BAD_REQUEST),

    IDENTITY_PHONE_INVALID(1109, "identity_phone_invalid", HttpStatus.BAD_REQUEST),

    IDENTITY_IMAGE_EMPTY(1110, "identity_image_empty", HttpStatus.BAD_REQUEST),

    IDENTITY_APPOINTMENT_ADDRESS_EMPTY(1111, "identity_appointment_address_empty", HttpStatus.BAD_REQUEST),

    IDENTITY_BRANCH_OFFICE_EMPTY(1112, "identity_branch_office_empty", HttpStatus.BAD_REQUEST),

    IDENTITY_REQUEST_APPROINTMENT_TIME_EMPTY(1113, "identity_request_approintment_time_empty", HttpStatus.BAD_REQUEST),

    IDENTITY_REQUEST_APPROINTMENT_TIME_INVALID(1114, "identity_request_approintment_time_invalid",
            HttpStatus.BAD_REQUEST),

    IDENTITY_INFO_EMPTY(1115, "identity_info_empty", HttpStatus.BAD_REQUEST),

    IDENTITY_INFO_EXISTED(1116, "identity_info_existed", HttpStatus.BAD_REQUEST),

    /** OTP *********/
    PHONE_NUMBER_INVALID(2001, "phone_number_invalid", HttpStatus.INTERNAL_SERVER_ERROR),
    OTP_RETRY_TOO_FAST(2002, "otp_retry_too_fast", HttpStatus.INTERNAL_SERVER_ERROR),
    OTP_RETRY_TOO_MANY(2003, "otp_retry_too_many", HttpStatus.INTERNAL_SERVER_ERROR),
    TELCO_MOBILE_NOT_EXIST(2004, "telco_mobile_not_exist", HttpStatus.INTERNAL_SERVER_ERROR),
    UNSUPPORTED_TELCO_MOBILE(2005, "unsupported_telco_mobile", HttpStatus.PRECONDITION_FAILED),
    INVALID_OTP(2006, "invalid_otp", HttpStatus.INTERNAL_SERVER_ERROR),

    BANK_NOT_EXIST(3001, "bank_not_exist", HttpStatus.INTERNAL_SERVER_ERROR),
    INTERNAL_SERVER_ERROR(1, "internal_server_error", HttpStatus.INTERNAL_SERVER_ERROR),

    UNSUPPORTED_SERVICE(4001, "unsupported_service", HttpStatus.PRECONDITION_FAILED),
    SERVICE_NOT_FOUND(4002, "service_not_found", HttpStatus.PRECONDITION_FAILED),

    UNSUPPORTED_PROVIDER(4101, "unsupported_provider", HttpStatus.PRECONDITION_FAILED),
    PROVIDER_NOT_FOUND(4102, "provider_not_found", HttpStatus.PRECONDITION_FAILED),

    UNSUPPORTED_PRODUCT(4201, "unsupported_product", HttpStatus.PRECONDITION_FAILED),
    PRODUCT_NOT_FOUND(4202, "product_not_found", HttpStatus.PRECONDITION_FAILED),

    SHOPPING_CART_EMPTY(4301, "shopping_cart_empty", HttpStatus.PRECONDITION_FAILED),

    EXCEEDED_LIMIT_AMOUNT(4302, "exceeded_limit_amount", HttpStatus.PRECONDITION_FAILED),

    EXCEEDED_LIMIT_AMOUNT_PER_TRANSACTION(4302, "exceeded_limit_amount_per_transaction",
            HttpStatus.PRECONDITION_FAILED),

    EXCEEDED_LIMIT_AMOUNT_PER_DAY(4303, "exceeded_limit_amount_per_day", HttpStatus.PRECONDITION_FAILED),

    MINIMUM_AMOUNT_PER_TRANSACTION(4304, "minimum_amount_per_transaction", HttpStatus.PRECONDITION_FAILED),

    MINIMUM_AMOUNT_PER_DAY(4304, "minimum_amount_per_day", HttpStatus.PRECONDITION_FAILED),

    UNSUPPORTED_TRANSFER_YOURSELF(5001, "unsupported_transfer_yourself", HttpStatus.PRECONDITION_FAILED),

    UNSUPPORTED_TRANSFER_USER_TYPE(5003, "unsupported_transfer_user_type", HttpStatus.PRECONDITION_FAILED),

    TOPUP_SERVICE_NOT_SUPPORTED(4401, "topup_service_not_supported", HttpStatus.PRECONDITION_FAILED),

    ORDER_NOT_EXIST(4501, "order_not_exist", HttpStatus.PRECONDITION_FAILED),

    INSUFFICIENT_FUND(5002, "insufficient_fund", HttpStatus.PRECONDITION_FAILED),

    CAN_NOT_CALCULATE_CASH_AND_PROMOTION(1200, "can_not_calculate_cash_and_promotion", HttpStatus.PRECONDITION_FAILED),

    /*** ORDER CONTROLLER: Code 04 ***/
    CUSTOMER_CODE_NOT_FOUND(4001, "customer_code_not_found", HttpStatus.INTERNAL_SERVER_ERROR),

    INVOICE_PAID(4002, "invoice_paid", HttpStatus.INTERNAL_SERVER_ERROR),

    OK(200, "OK", HttpStatus.OK),;

    /** The Http code. */
    private HttpStatus httpCode;

    /** The error code. */
    private int errorCode;

    /** The message. */
    private String message;

    /**
     * Instantiates a new error message.
     * 
     * @param pCode    the code
     * @param pMessage the message
     */
    ErrorMessage(int pCode, String pMessage, HttpStatus pHttpCode) {
        errorCode = pCode;
        message = pMessage;
        httpCode = pHttpCode;
    }

    /**
     * Gets the code.
     * 
     * @return the code
     */
    public int getCode() {
        return errorCode;
    }

    public HttpStatus getHttpCode() {
        return httpCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the message.
     * 
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    public void setHttpCode(HttpStatus pHttpCode) {
        this.httpCode = pHttpCode;
    }
}
