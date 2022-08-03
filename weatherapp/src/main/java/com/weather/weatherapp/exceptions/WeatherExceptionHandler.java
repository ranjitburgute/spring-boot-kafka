package com.weather.weatherapp.exceptions;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.weather.weatherapp.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class WeatherExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherExceptionHandler.class);

    @ExceptionHandler(value = {JsonMappingException.class})
    protected ResponseEntity<Object> JSONMappingErrorHandler(RuntimeException ex, WebRequest request) {
        LOGGER.error(Constants.ERROR_JSON_MAPPING_MESSAGE);
        return handleExceptionInternal(ex, Constants.ERROR_JSON_MAPPING_MESSAGE, new HttpHeaders(),
                HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(value = {JsonProcessingException.class})
    protected ResponseEntity<Object> JSONProcessingErrorHandler(RuntimeException ex, WebRequest request) {
        LOGGER.error(Constants.ERROR_JSON_PROCESSING_MESSAGE);
        return handleExceptionInternal(ex, Constants.ERROR_JSON_PROCESSING_MESSAGE, new HttpHeaders(),
                HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(value = {IOException.class})
    protected ResponseEntity<Object> IOExceptionHandler(RuntimeException ex, WebRequest request) {
        LOGGER.error(Constants.ERROR_IO_EXCEPTION_MESSAGE);
        return handleExceptionInternal(ex, Constants.ERROR_IO_EXCEPTION_MESSAGE, new HttpHeaders(),
                HttpStatus.SERVICE_UNAVAILABLE, request);
    }

    @ExceptionHandler(value = {InternalServerError.class})
    protected ResponseEntity<Object> InternalServerErrorHandler(RuntimeException ex, WebRequest request) {
        LOGGER.error(Constants.ERROR_INTERNAL_SERVER);
        return handleExceptionInternal(ex, Constants.ERROR_INTERNAL_SERVER, new HttpHeaders(),
                HttpStatus.EXPECTATION_FAILED, request);
    }

    @ExceptionHandler(value = {HttpClientErrorException.class})
    protected ResponseEntity<Object> HttpClientErrorHandler(RuntimeException ex, WebRequest request) {
        LOGGER.error(Constants.UNAUTHORIZED);
        return handleExceptionInternal(ex, Constants.UNAUTHORIZED, new HttpHeaders(),
                HttpStatus.UNAUTHORIZED, request);
    }
}
