package org.webtree.rate.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.webtree.rate.web.serilization.HttpStatusSerializer;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.MOVED_PERMANENTLY;


/**
 * @author Max
 *         Created on 8/28/2016.
 */
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ApiResponseType {
    OK(0, HttpStatus.OK),
    NOT_FOUND(1, HttpStatus.NOT_FOUND),
    SERVER_ERROR(2, INTERNAL_SERVER_ERROR),
    BAD_REQUEST(3, HttpStatus.BAD_REQUEST),
    MOVED(4, MOVED_PERMANENTLY),
    FOUND(5, HttpStatus.FOUND),
    ;
    private int code;
    @JsonSerialize(using = HttpStatusSerializer.class)
    private HttpStatus httpStatus;
    private final static Map<HttpStatus, ApiResponseType> MAP_BY_HTTP_STATUS = new HashMap<>();
    ApiResponseType(int code, HttpStatus status) {
        this.code = code;
        this.httpStatus = status;
    }

    public static ApiResponseType resolveType(HttpStatus status) {
        if (MAP_BY_HTTP_STATUS.containsKey(status)) {
            return MAP_BY_HTTP_STATUS.get(status);
        }
        if (status.is2xxSuccessful()) {
            return OK;
        }
        if (status.is3xxRedirection()) {
            return FOUND;
        }
        if (status.is4xxClientError()) {
            return BAD_REQUEST;
        }
        if (status.is5xxServerError()) {
            return SERVER_ERROR;
        }
        throw new NotImplementedException();
    }

    static {
        for (ApiResponseType type : ApiResponseType.values()) {
            Assert.isTrue(!MAP_BY_HTTP_STATUS.containsValue(type));
            MAP_BY_HTTP_STATUS.put(type.getHttpStatus(), type);
        }
    }
}
