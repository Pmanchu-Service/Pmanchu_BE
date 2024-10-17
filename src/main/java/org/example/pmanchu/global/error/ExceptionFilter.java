package org.example.pmanchu.global.error;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.pmanchu.global.error.exception.ErrorCode;
import org.example.pmanchu.global.error.exception.PmanchuException;
import org.springframework.http.MediaType;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
public class ExceptionFilter extends OncePerRequestFilter {
    private final ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (PmanchuException e) {
            sendErrorMessage(response, e.getErrorCode());
        } catch (Exception e) {
            logger.error(e);
            sendErrorMessage(response, ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }

    private void sendErrorMessage(HttpServletResponse response, ErrorCode errorCode) throws IOException {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .status(errorCode.getHttpStatus())
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .build();
        String errorResponseJson = objectMapper.writeValueAsString(errorResponse);

        response.setStatus(errorCode.getHttpStatus());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write(errorResponseJson);
    }
}