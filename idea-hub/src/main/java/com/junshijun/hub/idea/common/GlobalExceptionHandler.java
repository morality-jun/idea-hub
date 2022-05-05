package com.junshijun.hub.idea.common;

import com.junshijun.hub.idea.common.exception.LoginNameExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    private void printLog(HttpServletRequest request) {
        log.error("Idea Hub Exception: " + request);
    }

    @ResponseBody
    @ExceptionHandler(value = LoginNameExistException.class)
    public Response LoginNameExistExceptionHandler(HttpServletRequest request, LoginNameExistException ex) {
        printLog(request);
        return Response.fail(ex.getMessage());
    }
}
