package com.duyminh215.map.service;

import com.duyminh215.map.constant.HeaderContants;
import com.duyminh215.map.exception.BusinessException;
import com.duyminh215.map.exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class PartnerConnectionService {

    private static final Logger mlogger = LogManager.getLogger(PartnerConnectionService.class);
    private static final String REQUEST = "REST REQUEST: URL[{}], HTTP-METHOD[{}], HTTP-HEADERS[{}], REQUEST-BODY[{}]";
    private static final String RESPONSE = "REST RESPONSE: STATUS[{}], MESSAGE[{}], BODY[{}]";
    private final RestTemplate restTemplate;

    @Autowired
    public PartnerConnectionService(RestTemplate prestTemplate) {
        this.restTemplate = prestTemplate;
    }

    public <T> ResponseEntity process(HttpMethod phttpMethod, String pstrURL, HttpHeaders phttpHeaders,
                                      Object prequestBody, Class<T> presponseType) {
        if (phttpHeaders == null) {
            phttpHeaders = new HttpHeaders();
        }
        phttpHeaders.set(HeaderContants.X_REQUEST_ID, UUID.randomUUID().toString());
        phttpHeaders.set(HeaderContants.TIMESTAMP,
                ZonedDateTime.now()
                        .format(DateTimeFormatter.ofPattern(HeaderContants.TIMESTAMP_DATE_PATTERN)));
        mlogger.info(REQUEST, pstrURL, phttpMethod, phttpHeaders, prequestBody);
        try {
            ResponseEntity vresponseEntity = restTemplate
                    .exchange(pstrURL, phttpMethod, new HttpEntity<>(prequestBody, phttpHeaders),
                            presponseType);
            HttpStatus vhttpStatus = vresponseEntity.getStatusCode();
            mlogger.info(RESPONSE, vhttpStatus.value(), vhttpStatus.getReasonPhrase(),
                    vresponseEntity.getBody());
            return vresponseEntity;

        } catch (HttpClientErrorException | HttpServerErrorException ex) {
            mlogger.error(ex.getMessage(), ex);
            throw new BusinessException(String.valueOf(HttpStatus.NO_CONTENT.value()),
                    ex.getMessage());

        } catch (ResourceAccessException ex) {
            mlogger.error(ex.getMessage(), ex);
            mlogger.debug("Connection timed out!");
            if (ex.getCause() instanceof CustomException) {
                String responseMessageStr = ex.getCause().getMessage();
                throw new BusinessException(ex.getMessage(), ex);
            }
            throw new BusinessException(String.valueOf(HttpStatus.BAD_REQUEST.value()),
                    ex.getMessage());
        }
    }

}
