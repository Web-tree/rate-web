package org.webtree.rate.web.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.net.HttpURLConnection;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
public class ApiResponseStatus {
    private int code;
    @JsonInclude(Include.NON_EMPTY)
    private String message;

    public static enum ApiStatusCode {
        // General codes
        OK(HttpURLConnection.HTTP_OK),
        UNAUTHORIZED(HttpURLConnection.HTTP_UNAUTHORIZED),
        PRECONDITION(HttpURLConnection.HTTP_PRECON_FAILED),
        FORBIDDEN(HttpURLConnection.HTTP_FORBIDDEN),
        ERROR(HttpURLConnection.HTTP_INTERNAL_ERROR);
        private int code;

        ApiStatusCode(int code) {
            this.code = code;
        }

        public int getCode() {

            return code;
        }
    }

    public static ApiResponseStatus getOkStatus() {
        return new ApiResponseStatus(ApiStatusCode.OK);
    }

    public static ApiResponseStatus getErrorStatus() {
        return new ApiResponseStatus(ApiStatusCode.ERROR);
    }

    public static ApiResponseStatus getStatus(ApiStatusCode code) {
        return new ApiResponseStatus(code);
    }

    public ApiResponseStatus(ApiStatusCode code, String message) {
        this.code = code.getCode();
        this.message = message;
    }

    public ApiResponseStatus(ApiStatusCode code) {
        this.code = code.getCode();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
