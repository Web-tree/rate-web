package org.webtree.rate.web.exception;

import lombok.Getter;
import org.webtree.rate.web.model.ApiResponseType;

import static org.webtree.rate.web.model.ApiResponseType.SERVER_ERROR;

/**
 * @author Max
 *         Created on 8/28/2016.
 */
public abstract class WTException extends RuntimeException {
    @Getter
    private ApiResponseType type = SERVER_ERROR;
    public WTException() {
    }

    public WTException(String message) {
        super(message);
    }

    public WTException(String message, Throwable cause) {
        super(message, cause);
    }

    public WTException(Throwable cause) {
        super(cause);
    }

    public WTException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
