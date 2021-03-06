package org.webtree.rate.web.utils;

import org.webtree.rate.web.model.ApiResponse;
import org.webtree.rate.web.model.ApiResponseStatus;
import org.webtree.rate.web.model.ApiResponseType;

import java.util.Collection;

import static org.webtree.rate.web.model.ApiResponseType.NOT_FOUND;
import static org.webtree.rate.web.model.ApiResponseType.OK;

/**
 * @author Max
 *         Created on 7/25/2016.
 */
public final class ResponseUtils {
    private ResponseUtils() {
    }

    public static <T> ApiResponse<T> ok() {
        return new ApiResponse<>(newStatus());
    }

    public static <T> ApiResponse<T> ok(T data) {
        return new ApiResponse<>(newStatus(), data);
    }

    public static <T> ApiResponse<T> wrap(ApiResponseType status, String message) {
        return new ApiResponse<>(newStatus(status, message));
    }

    public static <T> ApiResponse<T> wrap(ApiResponseType status, String message, T data) {
        return new ApiResponse<>(newStatus(status, message), data);
    }

    public static <T> ApiResponse<T> wrap(ApiResponseType status, T data) {
        return new ApiResponse<>(newStatus(status), data);
    }

    public static <T> ApiResponse<T> wrap(ApiResponseType status) {
        return new ApiResponse<>(newStatus(status));
    }

    public static <T> ApiResponse<T> okOrNotFound(String notFoundMessage, T data) {
        if (data == null || (data instanceof Collection && ((Collection) data).isEmpty())) {
            return wrap(NOT_FOUND, notFoundMessage);
        } else {
            return ok(data);
        }
    }

    private static ApiResponseStatus newStatus(ApiResponseType status, String message) {
        return new ApiResponseStatus(status, message);
    }

    private static ApiResponseStatus newStatus(ApiResponseType status) {
        return new ApiResponseStatus(status);
    }

    private static ApiResponseStatus newStatus() {
        return new ApiResponseStatus(OK);
    }
}
