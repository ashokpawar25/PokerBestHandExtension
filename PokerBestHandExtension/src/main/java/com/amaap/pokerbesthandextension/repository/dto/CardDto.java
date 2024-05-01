package com.amaap.pokerbesthandextension.repository.dto;

import java.util.Objects;

public class CardDto {
    private final String code;
    public CardDto(String code) {
        this.code = code;
    }

    public static CardDto create(String code) {
        return new CardDto(code);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardDto cardDto = (CardDto) o;
        return Objects.equals(code, cardDto.code);
    }
}
