package com.commit.connections.exception;

import com.commit.connections.dto.ApiError;
import com.commit.connections.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleUserNotFound(UserNotFoundException ex) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
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
    public ResponseEntity<ApiResponse<Void>> handleUserNotFound(InvalidCredentials ex) {
        HttpStatus httpStatus = HttpStatus.FORBIDDEN;
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
