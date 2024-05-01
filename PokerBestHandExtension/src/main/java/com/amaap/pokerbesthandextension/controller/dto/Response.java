package com.amaap.pokerbesthandextension.controller.dto;

import java.util.Objects;

public class Response {
    private final HttpStatus httpStatus;
    private final String message;

    public Response(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Response response = (Response) o;
        return httpStatus == response.httpStatus && Objects.equals(message, response.message);
    }
}
