package com.duyminh215.map.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Format of response returned to client
 *
 * @param <T>
 * @author xuatdd
 * @version 1.0
 * @since 2020/03/01
 */

@Getter
@Setter
public class GeneralResponse<T> {

    @JsonProperty("status")
    private ResponseStatus status;

    @JsonProperty("data")
    private T data;

    @Override
    public String toString() {
        return "{" + "status=" + status + ", data=" + data + '}';
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}