package com.assignment.dropbox.config;

import com.assignment.dropbox.exception.DropboxApiException;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Objects;

/**
 * Feign configuration for Dropbox API integration.
 *
 * Handles:
 *  - Setting the Authorization header for every request.
 *  - Ensuring the Content-Type is always JSON for POST calls.
 *  - Converting Dropbox API errors into readable exceptions.
 *
 * Keeps all Dropbox-specific Feign logic isolated from business code.
 */
@Configuration
@RequiredArgsConstructor
@Slf4j
public class DropboxFeignConfig {

    @Value("${dropbox.access-token}")
    private String accessToken;

    /**
     * Intercepts every Feign request to automatically attach
     * required Dropbox headers (Authorization, Content-Type).
     */
    @Bean
    public RequestInterceptor dropboxRequestInterceptor() {
        return (RequestTemplate template) -> {
            // Add access token to every call
            template.header("Authorization", "Bearer " + accessToken);

            // Dropbox APIs expect JSON requests for all POST endpoints
            if ("POST".equalsIgnoreCase(template.method())) {
                if (!template.headers().containsKey("Content-Type")) {
                    template.header("Content-Type", "application/json");
                }
                // For endpoints that require an explicit null body (e.g. get_info)
                if (Objects.isNull(template.body()) || template.body().length == 0) {
                    template.body("null");
                }
            }
        };
    }

    /**
     * Custom Feign error decoder that captures Dropbox API error responses
     * and rethrows them as a unified {@link DropboxApiException}.
     */
    @Bean
    public ErrorDecoder dropboxErrorDecoder() {
        return (methodKey, response) -> {
            String body = "";
            try {
                if (response.body() != null) {
                    body = new String(response.body().asInputStream().readAllBytes());
                }
            } catch (IOException e) {
                log.error("Failed to read Dropbox error body", e);
            }

            log.error("Dropbox API error during {} -> status: {}, body: {}", methodKey, response.status(), body);

            // Propagate original error response as-is for better debugging
            return new DropboxApiException(response.status(), body);
        };
    }
}
