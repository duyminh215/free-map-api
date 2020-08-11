package com.duyminh215.map.exception;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "error")
public class ErrorResponse {
    public ErrorResponse(int code, String message, List<String> details) {
        super();
        this.code = code;
        this.message = message;
        this.details = details;
    }

    private int code;
    // General message about error
    private String message;

    // errors in API request processing
    private List<String> details;

    // Setters and Getters are omitted

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}