package com.deloitte.core.response;

public class R {

    public static <T> Result<T> success() {
        return new Result<>(SystemResponse.SYS0000);
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(SystemResponse.SYS0000, data);
    }

    public static <T> Result<T> fail(T data) {
        return new Result<>(SystemResponse.SYS9999, data);
    }

    public static <T> Result<T> error(Response response, T data) {
        return new Result<>(response, data);
    }

    public static <T> Result<T> error(Response response) {
        return new Result<>(response);
    }
}
