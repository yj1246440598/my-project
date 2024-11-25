package com.enjoy.exceptionHand;

import com.enjoy.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({BindException.class, MethodArgumentNotValidException.class})
    @ResponseBody
    public Result<?> handleValidationExceptions(Exception ex) {
        String errorMessage = null;
        if (ex instanceof BindException) {
            errorMessage = ((BindException) ex).getBindingResult()
                    .getFieldError()
                    .getDefaultMessage();
        } else if (ex instanceof MethodArgumentNotValidException) {
            errorMessage = ((MethodArgumentNotValidException) ex).getBindingResult()
                    .getFieldError()
                    .getDefaultMessage();
        }
        return Result.error(errorMessage);
    }

}
