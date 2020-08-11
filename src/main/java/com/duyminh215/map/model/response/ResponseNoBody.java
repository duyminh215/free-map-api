package com.duyminh215.map.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Format of response(no body) returned to client
 *
 * @param <T>
 * @author xuatdd
 * @version 1.0
 * @since 2020/03/01
 */
@Getter
@Setter
public class ResponseNoBody<T> {

    @JsonProperty("status")
    private ResponseStatus status;

    @Override
    public String toString() {
        return "{" + "status=" + status + '}';
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

}