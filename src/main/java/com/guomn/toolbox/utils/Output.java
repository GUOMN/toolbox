package com.guomn.toolbox.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class Output {

    private int code;

    private String message;

    private String text;

    private Object data;

    private Output(int code, String message, String text, Object data) {
        this.code = code;
        this.message = message;
        this.text = text;
        this.data = data;
    }

    private Output(int code, String errorMessage) {
        this.code = code;
        this.message = errorMessage;
    }


    public static Output success(Object data) {
        return new Output(0, null, null, data);
    }


    public static Output success() {
        return new Output(0, null, null, null);
    }


    public static Output error(Error error) {
        return new Output(100, error.getMessage());
    }
    public static Output error(String errorMessage) {
        return new Output(100, errorMessage);
    }


}
