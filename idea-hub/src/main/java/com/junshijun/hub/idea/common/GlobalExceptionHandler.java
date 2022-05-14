package com.junshijun.hub.idea.common;

import cn.hutool.core.date.DateTime;
import com.junshijun.hub.idea.common.exception.LoginNameExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    private void printLog(HttpServletRequest request, Exception ex) {
        log.error("[Idea Hub Exception: {} {}] --- {}", ex.getMessage(), DateTime.now(), request);
    }

    @ResponseBody
    @ExceptionHandler(value = LoginNameExistException.class)
    public Response LoginNameExistExceptionHandler(HttpServletRequest request, LoginNameExistException ex) {
        printLog(request, ex);
        return Response.fail(ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = BadCredentialsException.class)
    public Response BadCredentialsExceptionHandler(HttpServletRequest request, BadCredentialsException ex) {
        printLog(request, ex);
        return Response.fail(ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = UsernameNotFoundException.class)
    public Response loginNameNotFoundExceptionHandler(HttpServletRequest request, UsernameNotFoundException ex) {
        printLog(request, ex);
        return Response.fail(ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Response MethodArgumentNotValidExceptionHandler(HttpServletRequest request, MethodArgumentNotValidException ex) {
        printLog(request, ex);
        return Response.fail(ex.getMessage());
    }
}
