package com.duyminh215.map.model.response;

import java.util.Collection;
import java.util.stream.Collectors;

import com.duyminh215.map.constant.ResponseStatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseFactory {

    /**
     * Format of response returned to client in case success
     *
     * @param data
     * @param clazz
     * @return
     * @author xuatdd
     * @version 1.0
     * @since 2020/03/01
     */
    public ResponseEntity<?> success(Object data, Class<?> clazz) {
        GeneralResponse<Object> responseObject = new GeneralResponse<>();
        ResponseStatus responseStatus = new ResponseStatus(ResponseStatusCode.SUCCESS);
        responseObject.setStatus(responseStatus);
        if (data instanceof Collection) {
            responseObject.setData(((Collection) data).stream().collect(Collectors.toList()));
        } else {
            responseObject.setData(clazz.cast(data));
        }
        return ResponseEntity.ok(responseObject);
    }

    public ResponseEntity<?> success(Object data) {
        GeneralResponse<Object> responseObject = new GeneralResponse<>();
        ResponseStatus responseStatus = new ResponseStatus(ResponseStatusCode.SUCCESS);
        responseObject.setStatus(responseStatus);
        responseObject.setData(data);
        return ResponseEntity.ok(responseObject);
    }

    public ResponseEntity<?> successMesasge(ResponseStatusCode responseStatusCode, Object data, Class<?> clazz) {
        GeneralResponse<Object> responseObject = new GeneralResponse<>();
        ResponseStatus responseStatus = new ResponseStatus(responseStatusCode);
        responseObject.setStatus(responseStatus);
        if (data instanceof Collection) {
            responseObject.setData(((Collection) data).stream().collect(Collectors.toList()));
        } else {
            responseObject.setData(clazz.cast(data));
        }
        return ResponseEntity.ok(responseObject);
    }

    /**
     * Format of response returned to client in case fail
     *
     * @param data
     * @param clazz
     * @return
     * @author xuatdd
     * @version 1.0
     * @since 2020/03/01
     */
    public ResponseEntity<?> fail(Object data, Class<?> clazz, ResponseStatusCode responseStatusEnum) {
        GeneralResponse<Object> responseObject = new GeneralResponse<>();
        ResponseStatus responseStatus = new ResponseStatus(responseStatusEnum);
        responseObject.setStatus(responseStatus);
        if (data instanceof Collection) {
            responseObject.setData(((Collection) data).stream().collect(Collectors.toList()));
        } else {
            responseObject.setData(clazz.cast(data));
        }
        return ResponseEntity.status(responseStatusEnum.getHttpCode()).body(responseObject);
    }

    /**
     * Format of response returned to client in case success
     *
     * @param clazz
     * @return
     * @author xuatdd
     * @version 1.0
     * @since 2020/03/01
     */
    public ResponseEntity<?> success(Class<?> clazz) {
        ResponseNoBody<Object> responseObject = new ResponseNoBody<>();
        ResponseStatus responseStatus = new ResponseStatus(ResponseStatusCode.SUCCESS);
        responseObject.setStatus(responseStatus);
        return ResponseEntity.ok(responseObject);
    }

    /**
     * Format of response returned to client in case fail
     *
     * @param clazz
     * @return
     * @author xuatdd
     * @version 1.0
     * @since 2020/03/01
     */
    public ResponseEntity<?> fail(Class<?> clazz, ResponseStatusCode responseStatusEnum) {
        ResponseNoBody<Object> responseObject = new ResponseNoBody<>();
        ResponseStatus responseStatus = new ResponseStatus(responseStatusEnum);
        responseObject.setStatus(responseStatus);
        return ResponseEntity.status(responseStatusEnum.getHttpCode()).body(responseObject);
    }

    /**
     * Format of response returned to client in case fail
     *
     * @return
     * @author xuatdd
     * @version 1.0
     * @since 2020/03/01
     */
    public ResponseEntity<?> failBusiness(String code, String message) {
        GeneralResponse<Object> responseObject = new GeneralResponse<>();
        ResponseStatus responseStatus = new ResponseStatus();
        responseStatus.setCode(code);
        responseStatus.setMessage(message);
        responseObject.setStatus(responseStatus);
        return ResponseEntity.status(HttpStatus.OK).body(responseObject);
    }

}
