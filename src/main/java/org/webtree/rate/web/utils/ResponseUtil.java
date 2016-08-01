package org.webtree.rate.web.utils;

import org.webtree.rate.web.model.ApiResponse;
import org.webtree.rate.web.model.ApiResponseStatus;

import static org.webtree.rate.web.model.ApiResponseStatus.*;

/**
 * @author Max
 *         Created on 7/25/2016.
 */
public final class ResponseUtil {
    private ResponseUtil() {
    }

    public static <T> ApiResponse<T> createOkResponse() {
        return new ApiResponse<>(getOkStatus());
    }

    public static <T> ApiResponse<T> wrapResponse(T data) {
        return new ApiResponse<>(getOkStatus(), data);
    }

    public static <T> ApiResponse<T> wrapResponse(ApiStatusCode code, String message) {
        return new ApiResponse<>(new ApiResponseStatus(code, message));
    }

    public static <T> ApiResponse<T> wrapResponse(ApiStatusCode code, String message, T data) {
        return new ApiResponse<>(new ApiResponseStatus(code, message), data);
    }
}
