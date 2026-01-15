package com.task.common.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private static final String success_status = "SUCCESS";
    private static final String error_status  = "ERROR";

    private String status;
    private String message;
    private T data;

    public static <T> ApiResponse<T> createSuccess(T data) {
        return new ApiResponse<>(success_status,"요청 성공",data);
    }

    public static ApiResponse<?> createError(String message) {
        return new ApiResponse<>(error_status,message,null);
    }
}
