package com.amaap.pokerbesthandextension.controller;

import com.amaap.pokerbesthandextension.repository.dto.CardDto;
import com.amaap.pokerbesthandextension.repository.dto.exception.InvalidCardCodeException;

public class CardController {
    public CardDto create(String code) throws InvalidCardCodeException {
        return CardDto.create(code);
    }
}
