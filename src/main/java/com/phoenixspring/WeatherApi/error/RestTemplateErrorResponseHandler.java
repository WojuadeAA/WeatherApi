package com.phoenixspring.WeatherApi.error;


import com.phoenixspring.WeatherApi.WeatherApiApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;
import java.net.URI;

@Component
public class RestTemplateErrorResponseHandler implements ResponseErrorHandler {


    /**
     * Indicate whether the given response has any errors.
     * <p>Implementations will typically inspect the
     * {@link ClientHttpResponse#getStatusCode() HttpStatus} of the response.
     *
     * @param response the response to inspect
     * @return {@code true} if the response indicates an error; {@code false} otherwise
     * @throws IOException in case of I/O errors
     */
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
      return   response.getStatusCode().is4xxClientError()|| response.getStatusCode().is5xxServerError();
    }

    /**
     * Handle the error in the given response.
     * <p>This method is only called when {@link #hasError(ClientHttpResponse)}
     * has returned {@code true}.
     *
     * @param url      the request URL
     * @param method   the HTTP method
     * @param response the response with the error
     * @throws IOException in case of I/O errors
     * @since 5.0
     */
   private static final Logger log =
            LoggerFactory.getLogger(WeatherApiApplication.class);
    @Override
    public void handleError(URI url, HttpMethod method, ClientHttpResponse response) throws IOException {
    if(response.getStatusCode().is4xxClientError()){
        log.error("Client error: " + response.getStatusCode());
        log.error("Response body: " + response.getBody());


        throw new WeatherServiceException( response.getStatusText());
    }else if(response.getStatusCode().is5xxServerError()){
        throw new WeatherServiceException("Server error");

    }else {
        throw  new WeatherServiceException("Unknown error");
    }
}}
