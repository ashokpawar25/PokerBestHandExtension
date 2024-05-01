package com.amaap.pokerbesthandextension.repository.dto;

import com.amaap.pokerbesthandextension.repository.dto.exception.InvalidCardCodeException;
import com.amaap.pokerbesthandextension.repository.dto.validator.CardValidator;

import java.util.Objects;

public class CardDto {
    private final String code;
    public CardDto(String code) {
        this.code = code;
    }

    public static CardDto create(String code) throws InvalidCardCodeException {
        if(!CardValidator.isValidCode(code)) throw new InvalidCardCodeException("Invalid Card code:"+code);
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
