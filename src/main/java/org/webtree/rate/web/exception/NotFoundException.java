package org.webtree.rate.web.exception;

import lombok.Getter;
import org.webtree.rate.web.model.ApiResponseType;

import static org.webtree.rate.web.model.ApiResponseType.NOT_FOUND;

/**
 * @author Max
 *         Created on 8/28/2016.
 */
public class NotFoundException extends WTException {
    @Getter
    private ApiResponseType type = NOT_FOUND;
    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }

    public NotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
