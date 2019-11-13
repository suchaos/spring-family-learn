package com.suchaos.waiter.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * 异常处理
 *
 * @author suchao
 * @date 2019/11/13
 */
@RestControllerAdvice
public class GlobalExceptionControllerAdvice {

    @ExceptionHandler(NullPointerException.class)
    public Map<String, String> nullPointerExceptionHandler(NullPointerException exception) {
        Map<String, String> map = new HashMap<>();
        map.put("message", exception.toString());
        return map;
    }
}
