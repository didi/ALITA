package com.alita.common;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Lydia
 * @version V1.0
 * @since 2019-12-05 20:00:30
 */
public class ServiceResponse<T> {

    @Getter
    @Setter
    private Boolean success;

    @Getter
    @Setter
    private Integer status;

    @Getter
    @Setter
    private String msg;

    @Getter
    @Setter
    private T data;

    private ServiceResponse() {
        //不能初始化构造器
    }

    private ServiceResponse(Boolean success, Integer status, String message, T data) {
        this.success = success;
        this.status = status;
        this.msg = message;
        this.data = data;
    }

    public static <T> ServiceResponse<T> successOf(String message) {
        return new ServiceResponse<>(true, 10000, message, null);
    }

    public static <T> ServiceResponse<T> successOf(String message, T data) {
        return new ServiceResponse<>(true, 10000, message, data);
    }

    public static <T> ServiceResponse<T> failOf(Integer status, String message) {
        return new ServiceResponse<>(false, status, message, null);
    }

    public static <T> ServiceResponse<T> failOf(Integer status, String message, T data) {
        return new ServiceResponse<>(false, status, message, data);
    }

}
