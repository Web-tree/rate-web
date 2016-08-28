package org.webtree.rate.web.utils;

import org.springframework.http.HttpStatus;
import org.webtree.rate.web.model.ApiResponse;
import org.webtree.rate.web.model.ApiResponseStatus;

import static org.webtree.rate.web.model.ApiResponseStatus.getOkStatus;

/**
 * @author Max
 *         Created on 7/25/2016.
 */
public final class ResponseUtils {
    private ResponseUtils() {
    }

    public static <T> ApiResponse<T> createOkResponse() {
        return new ApiResponse<>(getOkStatus());
    }

    public static <T> ApiResponse<T> wrapResponse(T data) {
        return new ApiResponse<>(getOkStatus(), data);
    }

    public static <T> ApiResponse<T> wrapResponse(HttpStatus status, String message) {
        return new ApiResponse<>(new ApiResponseStatus(status, message));
    }

    public static <T> ApiResponse<T> wrapResponse(HttpStatus status, String message, T data) {
        return new ApiResponse<>(new ApiResponseStatus(status, message), data);
    }

    public static <T> ApiResponse<T> wrapResponse(HttpStatus status, T data) {
        return new ApiResponse<>(new ApiResponseStatus(status), data);
    }
}
