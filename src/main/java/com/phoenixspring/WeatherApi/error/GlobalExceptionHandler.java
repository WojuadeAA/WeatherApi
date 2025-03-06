package com.phoenixspring.WeatherApi.error;

import com.phoenixspring.WeatherApi.WeatherApiApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(WeatherServiceException.class)
    public ProblemDetail handleWeatherServiceException(WeatherServiceException ex,
                                                       WebRequest request, HttpStatus status) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(status, ex.getMessage());
   return  problemDetail;
    }

    @ExceptionHandler(RestClientResponseException.class)
    public ProblemDetail handleRestClientException(
            RestClientResponseException ex, WebRequest request) {

        return buildErrorResponse(
                ex,
                HttpStatus.valueOf(ex.getStatusCode().value()),
                request,
                ex.getResponseBodyAsString()
        );
    }
    private static final Logger log = LoggerFactory.getLogger(WeatherApiApplication.class);

    private ProblemDetail buildErrorResponse(
            Exception ex,
            HttpStatus status,
            WebRequest request,
            String originalError) {
        log.error("Error: ", ex);
        log.error("Original error: ", originalError);

    return   ProblemDetail.forStatusAndDetail(status, originalError);
    }

}

