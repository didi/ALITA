package com.alita.handler;

import com.alita.common.ServiceResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Lydia
 * @version V1.0
 * @since 2019-12-02 11:34:24
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ServiceResponse<String> methodArgumentNotValidExceptionHandler(HttpServletRequest request,
                                                                          MethodArgumentNotValidException e) {
//        log.error(LogBuilders.generalLog(e.getMessage(), e));
        String msg = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return ServiceResponse.failOf(10001, msg, null);
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ServiceResponse<String> runtimeExceptionHandler(HttpServletRequest request, Exception e) {
//        log.error(LogBuilders.generalLog(e.getMessage(), e));
        return ServiceResponse.failOf(10001, e.getMessage(), null);
    }

    @ExceptionHandler(value = Exception.class)
    public ServiceResponse<String> exceptionHandler(HttpServletRequest request, Exception e) {
//        log.error(LogBuilders.generalLog(e.getMessage(), e));
        return ServiceResponse.failOf(10001, e.getMessage(), null);
    }

}
