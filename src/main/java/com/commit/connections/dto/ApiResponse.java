package com.commit.connections.dto;

public class ApiResponse<T> {

    private final String status;
    private final T data;
    private final ApiError error;

    public ApiResponse(String status, T data, ApiError error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public static <T> ApiResponse<T> ok(T data) {
        return new ApiResponse<>("OK", data, null);
    }

    public static <T> ApiResponse<T> error(ApiError error) {
        return new ApiResponse<>("ERROR", null, error);
    }

    public String getStatus() {
        return status;
    }

    public T getData() {
        return data;
    }

    public ApiError getError() {
        return error;
    }
}
