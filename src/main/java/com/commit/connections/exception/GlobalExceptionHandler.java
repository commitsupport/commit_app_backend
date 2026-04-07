package com.commit.connections.exception;

import com.commit.connections.dto.ApiError;
import com.commit.connections.dto.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleGeneralException(Exception ex) {
        String traceId = MDC.get("traceId");
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        log.error("Unhandled exception, traceId={}", traceId, ex);

        ApiError error = new ApiError(
                httpStatus.value(),
                ErrorCode.INTERNAL_SERVER_ERROR,
                "Wystąpił nieoczekiwany błąd",
                traceId != null ? "traceId: " + traceId : "Brak traceId"
        );

        return ResponseEntity
                .status(httpStatus)
                .body(ApiResponse.error(error));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleUserNotFound(UserNotFoundException ex) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        String traceId = MDC.get("traceId");
        log.warn("UserNotFoundException, traceId={}, code={}, message={}",
                traceId, ex.getCode(), ex.getMessage());
        ApiError error = new ApiError(
                httpStatus.value(),
                ex.getCode(),
                ex.getMessage(),
                ex.getDetails()
        );
        return ResponseEntity
                .status(httpStatus)
                .body(ApiResponse.error(error));
    }

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<ApiResponse<Void>> handleInvalidCredentials(InvalidCredentials ex) {
        HttpStatus httpStatus = HttpStatus.FORBIDDEN;
        String traceId = MDC.get("traceId");
        log.warn("InvalidCredentials, traceId={}, code={}, message={}",
                traceId, ex.getCode(), ex.getMessage());
        ApiError error = new ApiError(
                httpStatus.value(),
                ex.getCode(),
                ex.getMessage(),
                ex.getDetails()
        );
        return ResponseEntity
                .status(httpStatus)
                .body(ApiResponse.error(error));
    }

    @ExceptionHandler(SingleConnectionNotFound.class)
    public ResponseEntity<ApiResponse<Void>> handleSingleConnectionNotFound(SingleConnectionNotFound ex) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        String traceId = MDC.get("traceId");
        log.warn("SingleConnectionNotFound, traceId={}, code={}, message={}",
                traceId, ex.getCode(), ex.getMessage());
        ApiError error = new ApiError(
                httpStatus.value(),
                ex.getCode(),
                ex.getMessage(),
                ex.getDetails()
        );
        return ResponseEntity
                .status(httpStatus)
                .body(ApiResponse.error(error));
    }
}
