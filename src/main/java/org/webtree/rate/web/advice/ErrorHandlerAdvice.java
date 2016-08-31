package org.webtree.rate.web.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.webtree.rate.web.exception.WTException;
import org.webtree.rate.web.model.ApiResponse;
import org.webtree.rate.web.model.ApiResponseType;

import static org.webtree.rate.web.utils.ResponseUtils.wrap;

/**
 * @author Max
 *         Created on 8/28/2016.
 */
@ControllerAdvice
@ResponseBody
public class ErrorHandlerAdvice {
    @ExceptionHandler(Exception.class)
    public ApiResponse handleErrors(Exception e) {
        return wrap(ApiResponseType.SERVER_ERROR, e.getMessage());
    }

    @ExceptionHandler(WTException.class)
    public ApiResponse handleWTErrors(WTException e) {
        return wrap(e.getType(), e.getMessage());
    }
}
