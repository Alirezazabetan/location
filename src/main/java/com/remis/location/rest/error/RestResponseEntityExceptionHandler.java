package com.remis.location.rest.error;

import com.remis.location.rest.exception.LocationDoesNotExistException;
import com.remis.location.rest.exception.LocationIsExistException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { LocationIsExistException.class})
    protected ResponseEntity<Object> locationIsExist(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "{" +
                "\"message\": \"The location is exist\"," +
                "\"code\": \"400\"" +
                "}";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        return handleExceptionInternal(ex, bodyOfResponse,
                httpHeaders, HttpStatus.OK, request);
    }

    @ExceptionHandler(value = { LocationDoesNotExistException.class})
    protected ResponseEntity<Object> locationDoesNotExist(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "{" +
                "\"message\": \"The location does not exist\"," +
                "\"code\": \"400\"" +
                "}";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        return handleExceptionInternal(ex, bodyOfResponse,
                httpHeaders, HttpStatus.OK, request);
    }
}